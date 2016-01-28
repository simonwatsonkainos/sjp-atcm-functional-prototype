package uk.gov.moj.sjp.atcm.write.cst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.gov.moj.sjp.atcm.command.CreateSjpCase;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;
import uk.gov.moj.sjp.atcm.write.bot.SjpCaseBotWrite;

@RestController
public class SjpCaseWrite {

    @Autowired
    private SjpCaseBotWrite sjpCaseBotWrite;

    @RequestMapping(value = "/sjp-case", method = RequestMethod.POST)
    public SjpCase createSjpCase(@RequestBody CreateSjpCase createSjpCase) {
        return sjpCaseBotWrite.createCase(createSjpCase);
    }
}
