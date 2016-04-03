package uk.gov.moj.sjp.atcm.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.gov.moj.sjp.atcm.persistence.dao.Defendant;
import uk.gov.moj.sjp.atcm.persistence.dao.Offence;

import java.util.UUID;

public class SjpCaseQuery {

    private UUID id;
    private String prosecutorId;
    private String initiationCode;
    private String libraOriginatingOrg;
    private char summonsCode;
    private String informantName;
    private String libraHearingLocation;
    private String dateOfHearing;
    private String timeOfHearing;
    private String status;
    private Defendant defendant;

    @JsonProperty("offence")
    private SjpOffenceQuery sjpOffenceQuery;

    public SjpCaseQuery() { }

    @JsonCreator
    public SjpCaseQuery(@JsonProperty UUID id,
                        @JsonProperty String prosecutorId,
                        @JsonProperty String initiationCode,
                        @JsonProperty String libraOriginatingOrg,
                        @JsonProperty char summonsCode,
                        @JsonProperty String informantName,
                        @JsonProperty String libraHearingLocation,
                        @JsonProperty String dateOfHearing,
                        @JsonProperty String timeOfHearing,
                        @JsonProperty String status,
                        @JsonProperty Defendant defendant,
                        @JsonProperty("offence") SjpOffenceQuery sjpOffenceQuery) {
        this.id = id;
        this.prosecutorId = prosecutorId;
        this.initiationCode = initiationCode;
        this.libraOriginatingOrg = libraOriginatingOrg;
        this.summonsCode = summonsCode;
        this.informantName = informantName;
        this.libraHearingLocation = libraHearingLocation;
        this.dateOfHearing = dateOfHearing;
        this.timeOfHearing = timeOfHearing;
        this.status = status;
        this.defendant = defendant;
        this.sjpOffenceQuery = sjpOffenceQuery;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProsecutorId() {
        return prosecutorId;
    }

    public void setProsecutorId(String prosecutorId) {
        this.prosecutorId = prosecutorId;
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

    public void setLibraOriginatingOrg(String libraOriginatingOrg) {
        this.libraOriginatingOrg = libraOriginatingOrg;
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

    public String getLibraHearingName() {
        return libraHearingLocation;
    }

    public void setLibraHearingName(String libraHearingName) {
        this.libraHearingLocation = libraHearingName;
    }

    public String getDateOfHearing() {
        return dateOfHearing;
    }

    public void setDateoFHearing(String dateOfHearing) {
        this.dateOfHearing = dateOfHearing;
    }

    public Defendant getDefendant() {
        return defendant;
    }

    public void setDefendant(Defendant defendant) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SjpOffenceQuery getSjpOffenceQuery() {
        return sjpOffenceQuery;
    }

    public void setSjpOffenceQuery(SjpOffenceQuery sjpOffenceQuery) {
        this.sjpOffenceQuery = sjpOffenceQuery;
    }

    @Override
    public String toString() {
        return "CreateSjpCase{" +
                "tflCaseId='" + prosecutorId + '\'' +
                ", initiationCode='" + initiationCode + '\'' +
                ", libraOriginatingOrg='" + libraOriginatingOrg + '\'' +
                ", summonsCode=" + summonsCode +
                ", informantName='" + informantName + '\'' +
                ", libraHearingLocation='" + libraHearingLocation + '\'' +
                ", dateOfHearing='" + dateOfHearing + '\'' +
                ", timeOfHearing='" + timeOfHearing + '\'' +
                ", defendant=" + defendant +
                ", sjpOffenceQuery=" + sjpOffenceQuery +
                '}';
    }
}

