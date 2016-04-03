package uk.gov.moj.sjp.atcm.read.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.query.SjpCaseQuery;
import uk.gov.moj.sjp.atcm.read.dot.SjpCaseDotRead;

import java.util.List;
import java.util.UUID;

@Component
public class SjpCaseBotRead {

    @Autowired
    private SjpCaseDotRead sjpCaseDotRead;

    public List<SjpCaseQuery> getCasesByStatus(String status) {
        return sjpCaseDotRead.getCasesByStatus(status);
    }

    public SjpCaseQuery getCaseById(UUID id) {
        return sjpCaseDotRead.getCaseById(id);
    }

    public List<SjpCaseQuery> searchCases(String searchTerm) {
        if(searchTerm.contains("TFL")) {
            return sjpCaseDotRead.searchCasesByProsecutorId(searchTerm);
        } else {
            return sjpCaseDotRead.searchCasesByDefendantName(searchTerm);
        }
    }

    public List<SjpCaseQuery> getAllSjpCases() {
        return sjpCaseDotRead.getAllSjpCases();
    }
}
