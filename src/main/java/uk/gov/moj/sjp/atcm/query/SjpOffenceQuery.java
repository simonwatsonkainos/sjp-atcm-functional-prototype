package uk.gov.moj.sjp.atcm.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class SjpOffenceQuery {

    private Long id;
    private UUID caseId;
    private String tflCaseId;
    private int offenceSequenceNo;
    private String libraOffenceCode;
    private int libraOffenceDateCode;
    private String offenceDate;
    private String offenceWording;
    private String offenceDescription;
    private boolean fine;
    private boolean compensation;
    private boolean previousCharges;

    public SjpOffenceQuery() {

    }

    @JsonCreator
    public SjpOffenceQuery(@JsonProperty Long id,
                           @JsonProperty UUID caseId,
                           @JsonProperty String tflCaseId,
                           @JsonProperty int offenceSequenceNo,
                           @JsonProperty String libraOffenceCode,
                           @JsonProperty int libraOffenceDateCode,
                           @JsonProperty String offenceDate,
                           @JsonProperty String offenceWording,
                           @JsonProperty String offenceDescription,
                           @JsonProperty boolean fine,
                           @JsonProperty boolean compensation,
                           @JsonProperty boolean previousCharges) {
        this.id = id;
        this.caseId = caseId;
        this.tflCaseId = tflCaseId;
        this.offenceSequenceNo = offenceSequenceNo;
        this.libraOffenceCode = libraOffenceCode;
        this.libraOffenceDateCode = libraOffenceDateCode;
        this.offenceDate = offenceDate;
        this.offenceWording = offenceWording;
        this.offenceDescription = offenceDescription;
        this.fine = fine;
        this.compensation = compensation;
        this.previousCharges = previousCharges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getCaseId() {
        return caseId;
    }

    public void setCaseId(UUID caseId) {
        this.caseId = caseId;
    }

    public String getTflCaseId() {
        return tflCaseId;
    }

    public void setTflCaseId(String tflCaseId) {
        this.tflCaseId = tflCaseId;
    }

    public int getOffenceSequenceNo() {
        return offenceSequenceNo;
    }

    public void setOffenceSequenceNo(int offenceSequenceNo) {
        this.offenceSequenceNo = offenceSequenceNo;
    }

    public String getLibraOffenceCode() {
        return libraOffenceCode;
    }

    public void setLibraOffenceCode(String libraOffenceCode) {
        this.libraOffenceCode = libraOffenceCode;
    }

    public int getLibraOffenceDateCode() {
        return libraOffenceDateCode;
    }

    public void setLibraOffenceDateCode(int libraOffenceDateCode) {
        this.libraOffenceDateCode = libraOffenceDateCode;
    }

    public String getOffenceDate() {
        return offenceDate;
    }

    public void setOffenceDate(String offenceDate) {
        this.offenceDate = offenceDate;
    }

    public String getOffenceWording() {
        return offenceWording;
    }

    public void setOffenceWording(String offenceWording) {
        this.offenceWording = offenceWording;
    }

    public String getOffenceDescription() {
        return offenceDescription;
    }

    public void setOffenceDescription(String offenceDescription) {
        this.offenceDescription = offenceDescription;
    }

    public boolean isFine() {
        return fine;
    }

    public void setFine(boolean fine) {
        this.fine = fine;
    }

    public boolean isCompensation() {
        return compensation;
    }

    public void setCompensation(boolean compensation) {
        this.compensation = compensation;
    }

    public boolean isPreviousCharges() {
        return previousCharges;
    }

    public void setPreviousCharges(boolean previousCharges) {
        this.previousCharges = previousCharges;
    }
}
