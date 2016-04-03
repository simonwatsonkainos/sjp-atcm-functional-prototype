package uk.gov.moj.sjp.atcm.command.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.ArrayList;
import java.util.List;

public class SjpCase {

    private String tflCaseId;
    private String initiationCode;

    private char summonsCode;
    private String informantName;
    private String libraOriginatingOrg;
    private String libraHearingLocation;
    private String dateOfHearing;
    private String timeOfHearing;

    private SjpDefendant defendant;

    @JsonUnwrapped
    private List<SjpOffence> offences = new ArrayList<SjpOffence>();

    public SjpCase() { }

    @JsonCreator
    public SjpCase(@JsonProperty("tflCaseId") String tflCaseId,
                   @JsonProperty("initiationCode") String initiationCode,
                   @JsonProperty("libraOriginatingOrg") String libraOriginatingOrg,
                   @JsonProperty("summonsCode") char summonsCode,
                   @JsonProperty("informantName") String informantName,
                   @JsonProperty("libraHearingLocation") String libraHearingLocation,
                   @JsonProperty("dateOfHearing") String dateOfHearing,
                   @JsonProperty("timeOfHearing") String timeOfHearing,
                   @JsonProperty("defendant") SjpDefendant defendant,
                   @JsonProperty("offences") List<SjpOffence> offences) {
        this.tflCaseId = tflCaseId;
        this.initiationCode = initiationCode;
        this.libraOriginatingOrg = libraOriginatingOrg;
        this.summonsCode = summonsCode;
        this.informantName = informantName;
        this.libraHearingLocation = libraHearingLocation;
        this.dateOfHearing = dateOfHearing;
        this.timeOfHearing = timeOfHearing;
        this.defendant = defendant;

        if(offences != null) {
            this.offences = offences;
        }
    }

    public String getTflCaseId() {
        return tflCaseId;
    }

    public void setTflCaseId(String tflCaseId) {
        this.tflCaseId = tflCaseId;
    }

    public String getInitiationCode() {
        return initiationCode;
    }

    public void setInitiationCode(String initiationCode) {
        this.initiationCode = initiationCode;
    }

    public String getLibraOriginatingOrg() {
        return libraOriginatingOrg;
    }

    public void setLibraOriginatingOrg(String libraOriginationOrg) {
        this.libraOriginatingOrg = libraOriginationOrg;
    }

    public char getSummonsCode() {
        return summonsCode;
    }

    public void setSummonsCode(char summonsCode) {
        this.summonsCode = summonsCode;
    }

    public String getInformantName() {
        return informantName;
    }

    public void setInformantName(String informantName) {
        this.informantName = informantName;
    }

    public String getDateOfHearing() {
        return dateOfHearing;
    }

    public void setDateoFHearing(String dateOfHearing) {
        this.dateOfHearing = dateOfHearing;
    }

    public SjpDefendant getDefendant() {
        return defendant;
    }

    public void setDefendant(SjpDefendant defendant) {
        this.defendant = defendant;
    }

    public String getLibraHearingLocation() {
        return libraHearingLocation;
    }

    public void setLibraHearingLocation(String libraHearingLocation) {
        this.libraHearingLocation = libraHearingLocation;
    }

    public void setDateOfHearing(String dateOfHearing) {
        this.dateOfHearing = dateOfHearing;
    }

    public String getTimeOfHearing() {
        return timeOfHearing;
    }

    public void setTimeOfHearing(String timeOfHearing) {
        this.timeOfHearing = timeOfHearing;
    }

    public List<SjpOffence> getOffences() {
        return offences;
    }

    public void addOffence(SjpOffence offence) {
        this.offences.add(offence);
    }
}
