package uk.gov.moj.sjp.atcm.parser;

import uk.gov.moj.sjp.atcm.command.domain.SjpCase;
import uk.gov.moj.sjp.atcm.command.domain.SjpOffence;

import java.util.List;

public class TflCasesValidator {


    public List<SjpCase> reconcileCasesWithOffences(List<SjpCase> cases, List<SjpOffence> offences) {

        for(SjpCase caseRecord : cases) {
            for(SjpOffence offence : offences) {
                if(caseRecord.getTflCaseId().equals(offence.getTflCaseId())) {
                    caseRecord.addOffence(offence);
                }
            }
        }

        // Check for cases which don't have an offence
        for(SjpCase caseRecord : cases) {
            if(caseRecord.getOffences().size() > 1) {
                System.out.printf("Case %s has multiple offences", caseRecord.getTflCaseId());
            }
        }

        return cases;
    }

}
