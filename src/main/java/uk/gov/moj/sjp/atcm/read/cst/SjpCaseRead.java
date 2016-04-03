package uk.gov.moj.sjp.atcm.read.cst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.gov.moj.sjp.atcm.query.SjpCaseQuery;
import uk.gov.moj.sjp.atcm.read.bot.SjpCaseBotRead;

import java.util.List;
import java.util.UUID;

@RestController
public class SjpCaseRead {

    @Autowired
    private SjpCaseBotRead sjpCaseBotRead;

    @RequestMapping(value = "/sjp-case/{id}", method = RequestMethod.GET)
    public SjpCaseQuery getCasesById(@PathVariable UUID id) {
        return sjpCaseBotRead.getCaseById(id);
    }

    @RequestMapping(value = "/sjp-case/status/{status}", method = RequestMethod.GET)
    public List<SjpCaseQuery> getCasesByStatus(@PathVariable String status) {
        return sjpCaseBotRead.getCasesByStatus(status);
    }

    @RequestMapping(value = "/sjp-case/search", method = RequestMethod.GET, params = {"q"})
    public List<SjpCaseQuery> searchCases(@RequestParam String q) {
        return sjpCaseBotRead.searchCases(q);
    }

    @RequestMapping(value = "/sjp-case/getAll", method = RequestMethod.GET)
    public List<SjpCaseQuery> getAllSjpCases() {
        return sjpCaseBotRead.getAllSjpCases();
    }
}
