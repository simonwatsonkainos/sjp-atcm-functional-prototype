package uk.gov.moj.sjp.atcm.write.cst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gov.moj.sjp.atcm.command.UpdateSjpPlea;
import uk.gov.moj.sjp.atcm.write.bot.SjpCaseBotWrite;

import java.util.UUID;

@RestController
@RequestMapping("/sjp-case")
public class SjpCase {

    @Autowired
    private SjpCaseBotWrite sjpCaseBotWrite;

    @RequestMapping(value = "/{caseId}/updatePlea", method = RequestMethod.POST)
    public ResponseEntity<Void> createSjpCase(@PathVariable("caseId") String caseId, @RequestBody UpdateSjpPlea updateSjpPlea) {
        sjpCaseBotWrite.updateSjpPlea(updateSjpPlea, UUID.fromString(caseId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
