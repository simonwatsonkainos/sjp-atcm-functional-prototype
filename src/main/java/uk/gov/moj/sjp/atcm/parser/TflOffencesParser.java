package uk.gov.moj.sjp.atcm.parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import uk.gov.moj.sjp.atcm.command.domain.SjpOffence;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TflOffencesParser {

    private static final int CASE_ID = 0;
    private static final int OFFENCE_SEQ_NUMBER = 1;
    private static final int LIBRA_OFFENCE_CODE = 2;
    private static final int LIBRA_OFFENCE_DATE_CODE = 7;
    private static final int OFFENCE_START_DATE = 8;
    private static final int OFFENCE_WORDING = 15;

    public TflOffencesParser() { }

    public List<SjpOffence> getOffences(File offencesFile) throws IOException {

        List<SjpOffence> offences = new ArrayList<>();

        try {
            Reader reader = new FileReader(offencesFile);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);

            records.forEach(record -> createOffence(offences, record));
        }
        catch (IOException e) {
            System.err.println("Error reading offences file.");
            e.printStackTrace();
            throw e;
        }

        return offences;
    }

    private void createOffence(List<SjpOffence> offences, CSVRecord record) {
        SjpOffence offenceToAdd = new SjpOffence(
                record.get(CASE_ID),
                Integer.parseInt(record.get(OFFENCE_SEQ_NUMBER)),
                record.get(LIBRA_OFFENCE_CODE),
                Integer.parseInt(record.get(LIBRA_OFFENCE_DATE_CODE)),
                record.get(OFFENCE_START_DATE),
                record.get(OFFENCE_WORDING)
        );

        offences.add(offenceToAdd);
    }
}