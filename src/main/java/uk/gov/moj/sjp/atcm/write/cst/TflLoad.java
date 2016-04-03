package uk.gov.moj.sjp.atcm.write.cst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uk.gov.moj.sjp.atcm.command.CreateSjpCase;
import uk.gov.moj.sjp.atcm.command.domain.SjpCase;
import uk.gov.moj.sjp.atcm.command.domain.SjpOffence;
import uk.gov.moj.sjp.atcm.parser.TflCasesParser;
import uk.gov.moj.sjp.atcm.parser.TflCasesValidator;
import uk.gov.moj.sjp.atcm.parser.TflOffencesParser;
import uk.gov.moj.sjp.atcm.write.bot.SjpCaseBotWrite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/tfl-cases")
public class TflLoad {

    @Autowired
    private SjpCaseBotWrite sjpCaseBotWrite;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> uploadTfLCaseFiles(@RequestParam("header") MultipartFile casesMultipartFile,
                                                   @RequestParam("offences") MultipartFile offencesMulipartFile)
            throws IOException {

        File casesFile = convertMultipartFileToFile(casesMultipartFile);
        File offencesFile = convertMultipartFileToFile(offencesMulipartFile);

        List<SjpCase> cases = new TflCasesParser().getCases(casesFile);
        List<SjpOffence> offences = new TflOffencesParser().getOffences(offencesFile);

        List<SjpCase> newCasesCommand = new TflCasesValidator().reconcileCasesWithOffences(cases, offences);

        for(SjpCase kase : newCasesCommand) {
            sjpCaseBotWrite.createCase(kase);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private File convertMultipartFileToFile(MultipartFile mpFile) throws IOException {
        File file = new File(mpFile.getOriginalFilename());
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(mpFile.getBytes());
        fos.close();

        return file;
    }
}
