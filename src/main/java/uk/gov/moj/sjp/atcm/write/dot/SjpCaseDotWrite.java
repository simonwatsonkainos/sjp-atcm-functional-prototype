package uk.gov.moj.sjp.atcm.write.dot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.command.UpdateSjpPlea;
import uk.gov.moj.sjp.atcm.persistence.DefendantRepository;
import uk.gov.moj.sjp.atcm.persistence.OffenceRepository;
import uk.gov.moj.sjp.atcm.persistence.SjpCaseRepository;
import uk.gov.moj.sjp.atcm.persistence.dao.Defendant;
import uk.gov.moj.sjp.atcm.persistence.dao.Offence;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;

import java.util.UUID;

@Component
public class SjpCaseDotWrite {

    @Autowired
    private SjpCaseRepository sjpCaseRepository;

    @Autowired
    private DefendantRepository defendantRepository;

    @Autowired
    private OffenceRepository offenceRepository;

    public void saveSjpCase(SjpCase sjpCase, Defendant defendant, Offence offence) {
        sjpCaseRepository.save(sjpCase);
        defendantRepository.save(defendant);
        offenceRepository.save(offence);
    }

    public void updateSjpPlea(UpdateSjpPlea updateSjpPlea, UUID caseId) {
        SjpCase kase = sjpCaseRepository.findOne(caseId);
        kase.setStatus(updateSjpPlea.getPlea());
        sjpCaseRepository.save(sjpCaseRepository.findOne(caseId));
    }
}
