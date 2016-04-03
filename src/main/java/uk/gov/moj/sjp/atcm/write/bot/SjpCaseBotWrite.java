package uk.gov.moj.sjp.atcm.write.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.command.UpdateSjpPlea;
import uk.gov.moj.sjp.atcm.command.domain.SjpDefendant;
import uk.gov.moj.sjp.atcm.command.domain.SjpOffence;
import uk.gov.moj.sjp.atcm.persistence.dao.Defendant;
import uk.gov.moj.sjp.atcm.persistence.dao.Offence;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;
import uk.gov.moj.sjp.atcm.write.dot.SjpCaseDotWrite;

import java.util.UUID;

@Component
public class SjpCaseBotWrite {

    @Autowired
    private SjpCaseDotWrite sjpCaseDotWrite;

    public void createCase(uk.gov.moj.sjp.atcm.command.domain.SjpCase createSjpCase) {

        // Demonstrating some business logic (really just translation) Could possibly use model mapping tool?
        UUID caseId = UUID.randomUUID();
        UUID defendantId = UUID.randomUUID();
        sjpCaseDotWrite.saveSjpCase(createSjpCase(createSjpCase, caseId, defendantId),
                createDefendant(createSjpCase.getDefendant(), defendantId),
                createOffence(createSjpCase.getOffences().get(0), caseId));
    }

    public void updateSjpPlea(UpdateSjpPlea updateSjpPlea, UUID caseId) {
        sjpCaseDotWrite.updateSjpPlea(updateSjpPlea, caseId);
    }

    private SjpCase createSjpCase(uk.gov.moj.sjp.atcm.command.domain.SjpCase sjpCase, UUID caseId, UUID defendantId) {
        SjpCase caseToCreate = new SjpCase();
        caseToCreate.setCaseId(caseId);
        caseToCreate.setDefendantId(defendantId);
        caseToCreate.setProsecutorId(sjpCase.getTflCaseId());
        caseToCreate.setInitiationCode(sjpCase.getInitiationCode());
        caseToCreate.setLibraOriginatingOrg(sjpCase.getLibraOriginatingOrg());
        caseToCreate.setSummonsCode(sjpCase.getSummonsCode());
        caseToCreate.setInformantName(sjpCase.getInformantName());
        caseToCreate.setLibraHearingLocation(sjpCase.getLibraHearingLocation());
        caseToCreate.setDateOfHearing(sjpCase.getDateOfHearing());
        caseToCreate.setTimeOfHearing(sjpCase.getTimeOfHearing());
        caseToCreate.setStatus("AWAITING PLEA");

        return caseToCreate;
    }

    private Offence createOffence(SjpOffence sjpOffence, UUID caseId) {

        Offence offence = new Offence(
                caseId,
                sjpOffence.getTflCaseId(),
                sjpOffence.getOffenceSequenceNo(),
                sjpOffence.getLibraOffenceCode(),
                sjpOffence.getLibraOffenceDateCode(),
                sjpOffence.getOffenceDate(),
                sjpOffence.getOffenceWording()
        );

        return offence;
    }

    private Defendant createDefendant(SjpDefendant sjpDefendant, UUID defendantId) {

        Defendant defendant = new Defendant(
                defendantId,
                sjpDefendant.getTitle(),
                sjpDefendant.getForename(),
                sjpDefendant.getFamilyName(),
                sjpDefendant.getAddress(),
                sjpDefendant.getTown(),
                sjpDefendant.getCounty(),
                sjpDefendant.getPostcode(),
                sjpDefendant.getDob(),
                sjpDefendant.getGender()
        );

        return defendant;
    }
}
