package uk.gov.moj.sjp.atcm.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateSjpPlea {

    private String plea;

    @JsonCreator
    public UpdateSjpPlea(@JsonProperty String plea) {
        this.plea = plea;
    }


    public UpdateSjpPlea() {
    }

    public String getPlea() {
        return plea;
    }

    public void setPlea(String plea) {
        this.plea = plea;
    }
}
