package uk.gov.moj.sjp.atcm.read.dot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.persistence.DefendantRepository;
import uk.gov.moj.sjp.atcm.persistence.OffenceRepository;
import uk.gov.moj.sjp.atcm.persistence.RefSjpOffenceRepository;
import uk.gov.moj.sjp.atcm.persistence.SjpCaseRepository;
import uk.gov.moj.sjp.atcm.persistence.dao.Defendant;
import uk.gov.moj.sjp.atcm.persistence.dao.Offence;
import uk.gov.moj.sjp.atcm.persistence.dao.RefSjpOffence;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;
import uk.gov.moj.sjp.atcm.query.SjpCaseQuery;
import uk.gov.moj.sjp.atcm.query.SjpOffenceQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SjpCaseDotRead {

    @Autowired
    private SjpCaseRepository sjpCaseRepository;

    @Autowired
    private DefendantRepository defendantRepository;

    @Autowired
    private OffenceRepository offenceRepository;

    @Autowired
    private RefSjpOffenceRepository refSjpOffenceRepository;

    public SjpCaseQuery getCaseById(UUID id) {
        return buildSjpCase(sjpCaseRepository.findOne(id));
    }

    public List<SjpCaseQuery> getCasesByStatus(String status) {
        List<SjpCase> sjpCases =  sjpCaseRepository.findByStatus(status);
        return buildCases(sjpCases);
    }

    public List<SjpCaseQuery> searchCasesByProsecutorId(String prosecutorId) {
        List<SjpCase> hits = sjpCaseRepository.findByProsecutorId(prosecutorId);
        return buildCases(hits);
    }

    public List<SjpCaseQuery> searchCasesByDefendantName(String defendantName) {
        List<SjpCaseQuery> casesToReturn = new ArrayList<>();
        List<Defendant> hits = defendantRepository.searchDefendant(defendantName);
        return buildCasesFromDefendants(hits);
    }

    public List<SjpCaseQuery> getAllSjpCases() {
        return buildCases(sjpCaseRepository.findAll());
    }

    private List<SjpCaseQuery> buildCasesFromDefendants(List<Defendant> defendants) {

        List<SjpCase> casesHits = new ArrayList<>();
        List<SjpCaseQuery> casesToReturn = new ArrayList<>();

        defendants.forEach(defendant -> {
            casesHits.add(sjpCaseRepository.findByDefendantId(defendant.getId()));
        });

        defendants.forEach(defendant -> {
            casesHits.forEach(kase -> {
                if(kase.getDefendantId().equals(defendant.getId())) {
                    Offence offence = offenceRepository.getByCaseId(kase.getCaseId());
                    casesToReturn.add(generateCaseQuery(kase, defendant, offence));
                }
            });
        });

        return casesToReturn;
    }

    private SjpCaseQuery buildSjpCase(SjpCase sjpCase) {
        Defendant defendant = defendantRepository.getOne(sjpCase.getDefendantId());
        Offence offence = offenceRepository.getByCaseId(sjpCase.getCaseId());
        return generateCaseQuery(sjpCase, defendant, offence);
    }

    private List<SjpCaseQuery> buildCases(List<SjpCase> sjpCases) {

        List<SjpCaseQuery> casesToReturn = new ArrayList<>();

        for(SjpCase sjpCase : sjpCases) {
            Defendant defendant = defendantRepository.getOne(sjpCase.getDefendantId());
            Offence offence = offenceRepository.getByCaseId(sjpCase.getCaseId());
            SjpCaseQuery sjpCaseRecord = generateCaseQuery(sjpCase, defendant, offence);
            casesToReturn.add(sjpCaseRecord);
        }

        return casesToReturn;
    }

    private SjpCaseQuery generateCaseQuery(SjpCase kase, Defendant defendant, Offence offence) {
        SjpCaseQuery sjpCaseRecord = new SjpCaseQuery(
                kase.getCaseId(),
                kase.getProsecutorId(),
                kase.getInitiationCode(),
                kase.getLibraOriginatingOrg(),
                kase.getSummonsCode(),
                kase.getInformantName(),
                kase.getLibraHearingLocation(),
                kase.getDateOfHearing(),
                kase.getTimeOfHearing(),
                kase.getStatus(),
                defendant,
                generateSjpOffenceQuery(offence)
        );

        return sjpCaseRecord;
    }

    private SjpOffenceQuery generateSjpOffenceQuery(Offence offence) {
        // Run off and get offence description and terminal entries
        RefSjpOffence refSjpOffence = refSjpOffenceRepository.getByOffenceCode(offence.getLibraOffenceCode());

        return new SjpOffenceQuery(
                offence.getId(),
                offence.getCaseId(),
                offence.getTflCaseId(),
                offence.getOffenceSequenceNo(),
                offence.getLibraOffenceCode(),
                offence.getLibraOffenceDateCode(),
                offence.getOffenceDate(),
                offence.getOffenceWording(),
                refSjpOffence.getOffenceDescription(),
                refSjpOffence.isFine(),
                refSjpOffence.isCompensation(),
                refSjpOffence.isPreviousCharges()
        );
    }
}
