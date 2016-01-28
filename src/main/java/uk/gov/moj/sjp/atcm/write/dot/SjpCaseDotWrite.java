package uk.gov.moj.sjp.atcm.write.dot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.persistence.SjpCaseRepository;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;

@Component
public class SjpCaseDotWrite {

    @Autowired
    private SjpCaseRepository sjpCaseRepository;

    public SjpCase save(SjpCase sjpCase) {
        return sjpCaseRepository.save(sjpCase);
    }
}
