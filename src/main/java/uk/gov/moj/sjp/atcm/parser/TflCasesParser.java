package uk.gov.moj.sjp.atcm.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import uk.gov.moj.sjp.atcm.command.domain.SjpCase;
import uk.gov.moj.sjp.atcm.command.domain.SjpDefendant;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TflCasesParser {

    // Offence related attributes
    private static final int CASE_ID = 0;
    private static final int INITIATION_CODE = 2;
    private static final int LIBRA_INITIATING_ORG = 3;
    private static final int SUMMONS_CODE = 4;
    private static final int INFORMANT_NAME = 5;
    private static final int LIBRA_HEARING_LOCATION = 6;
    private static final int DATE_OF_HEARING = 7;
    private static final int TIME_OF_HEARING = 8;

    // Defendant related attributes
    private static final int DEF_TITLE = 13;
    private static final int DEF_FORENAME = 14;
    private static final int DEF_FAMILY_NAME = 17;
    private static final int DEF_ADDRESS = 21;
    private static final int DEF_POST_TOWN = 23;
    private static final int DEF_COUNTY = 24;
    private static final int DEF_POSTCODE = 25;
    private static final int DEF_BIRTHDATE = 32;
    private static final int DEF_GENDER = 34;

    public TflCasesParser() { }

    public List<SjpCase> getCases(File casesFile) throws IOException {

        List<SjpCase> cases = new ArrayList<SjpCase>();

        try {
            Reader reader = new FileReader(casesFile);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);

            records.forEach(record -> createCase(cases, record));
        }
        catch (IOException e) {
            System.err.println("Error reading cases file.");
            e.printStackTrace();
            throw e;
        }

        return cases;
    }

    private void createCase(List<SjpCase> cases, CSVRecord record) {

        SjpDefendant defendant = new SjpDefendant(
                record.get(DEF_TITLE),
                record.get(DEF_FORENAME),
                record.get(DEF_FAMILY_NAME),
                record.get(DEF_ADDRESS),
                record.get(DEF_POST_TOWN),
                record.get(DEF_COUNTY),
                record.get(DEF_POSTCODE),
                record.get(DEF_BIRTHDATE),
                record.get(DEF_GENDER).toCharArray()[0]
        );

        SjpCase caseToAdd = new SjpCase(
                record.get(CASE_ID),
                record.get(INITIATION_CODE),
                record.get(LIBRA_INITIATING_ORG),
                record.get(SUMMONS_CODE).toCharArray()[0],
                record.get(INFORMANT_NAME),
                record.get(LIBRA_HEARING_LOCATION),
                record.get(DATE_OF_HEARING),
                record.get(TIME_OF_HEARING),
                defendant,
                null);

        cases.add(caseToAdd);
    }
}

