package uk.gov.moj.sjp.atcm.command;

import uk.gov.moj.sjp.atcm.persistence.dao.Defendant;
import uk.gov.moj.sjp.atcm.persistence.dao.Offence;

public class CreateSjpCase {

    private String tflCaseId;
    private String initiationCode;
    private String libraOriginatingOrg;
    private char summonsCode;
    private String informantName;
    private String libraHearingLocation;
    private String dateOfHearing;
    private String timeOfHearing;
    private Defendant defendant;
    private Offence offence;

    public CreateSjpCase() { }

    public CreateSjpCase(String tflCaseId, String initiationCode, String libraOriginatingOrg, char summonsCode,
                         String informantName, String libraHearingLocation, String dateOfHearing,
                         String timeOfHearing, Defendant defendant) {
        this.tflCaseId = tflCaseId;
        this.initiationCode = initiationCode;
        this.libraOriginatingOrg = libraOriginatingOrg;
        this.summonsCode = summonsCode;
        this.informantName = informantName;
        this.libraHearingLocation = libraHearingLocation;
        this.dateOfHearing = dateOfHearing;
        this.timeOfHearing = timeOfHearing;
        this.defendant = defendant;
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

    public Offence getOffence() {
        return offence;
    }

    public void setOffence(Offence offence) {
        this.offence = offence;
    }

    @Override
    public String toString() {
        return "CreateSjpCase{" +
                "tflCaseId='" + tflCaseId + '\'' +
                ", initiationCode='" + initiationCode + '\'' +
                ", libraOriginatingOrg='" + libraOriginatingOrg + '\'' +
                ", summonsCode=" + summonsCode +
                ", informantName='" + informantName + '\'' +
                ", libraHearingLocation='" + libraHearingLocation + '\'' +
                ", dateOfHearing='" + dateOfHearing + '\'' +
                ", timeOfHearing='" + timeOfHearing + '\'' +
                ", defendant=" + defendant +
                ", offence=" + offence +
                '}';
    }
}
