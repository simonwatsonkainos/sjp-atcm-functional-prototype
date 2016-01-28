package uk.gov.moj.sjp.atcm.write.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.command.CreateSjpCase;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;
import uk.gov.moj.sjp.atcm.write.dot.SjpCaseDotWrite;

@Component
public class SjpCaseBotWrite {

    @Autowired
    private SjpCaseDotWrite sjpCaseDotWrite;

    public SjpCase createCase(CreateSjpCase createSjpCase) {

        // Demonstrating some business logic
        SjpCase sjpCase = new SjpCase(createSjpCase.getName());
        return sjpCaseDotWrite.save(sjpCase);
    }
}
