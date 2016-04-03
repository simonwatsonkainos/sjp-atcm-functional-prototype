package uk.gov.moj.sjp.atcm.persistence.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "sjp_case")
public class SjpCase {

    @Id
    private UUID caseId;
    private UUID defendantId;
    private String prosecutorId;
    private String initiationCode;
    private String libraOriginatingOrg;
    private char summonsCode;
    private String informantName;
    private String libraHearingLocation;
    private String dateOfHearing;
    private String timeOfHearing;
    private String status;

    public SjpCase() { }

    public UUID getCaseId() {
        return caseId;
    }

    public void setCaseId(UUID caseId) {
        this.caseId = caseId;
    }

    public UUID getDefendantId() {
        return defendantId;
    }

    public void setDefendantId(UUID defendantId) {
        this.defendantId = defendantId;
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

    public String getLibraHearingLocation() {
        return libraHearingLocation;
    }

    public void setLibraHearingLocation(String libraHearingLocation) {
        this.libraHearingLocation = libraHearingLocation;
    }

    public String getDateOfHearing() {
        return dateOfHearing;
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

    @Override
    public String toString() {
        return "SjpCaseRead{" +
                "caseId=" + caseId +
                ", prosecutorId='" + prosecutorId + '\'' +
                ", initiationCode='" + initiationCode + '\'' +
                ", libraOriginatingOrg='" + libraOriginatingOrg + '\'' +
                ", summonsCode=" + summonsCode +
                ", informantName='" + informantName + '\'' +
                ", libraHearingLocation='" + libraHearingLocation + '\'' +
                ", dateOfHearing='" + dateOfHearing + '\'' +
                ", timeOfHearing='" + timeOfHearing + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
