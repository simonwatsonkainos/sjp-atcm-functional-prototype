package uk.gov.moj.sjp.atcm.command.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SjpOffence {

    private String tflCaseId;
    private int offenceSequenceNo;
    private String libraOffenceCode;
    private int libraOffenceDateCode;
    private String offenceDate;
    private String offenceWording;

    @JsonCreator
    public SjpOffence(@JsonProperty("tflCaseId") String tflCaseId,
                      @JsonProperty("offenceSequenceNo") int offenceSequenceNo,
                      @JsonProperty("libraOffenceCode") String libraOffenceCode,
                      @JsonProperty("libraOffenceDateCode") int libraOffenceDateCode,
                      @JsonProperty("offenceDate") String offenceDate,
                      @JsonProperty("offenceWording") String offenceWording) {
        this.tflCaseId = tflCaseId;
        this.offenceSequenceNo = offenceSequenceNo;
        this.libraOffenceCode = libraOffenceCode;
        this.libraOffenceDateCode = libraOffenceDateCode;
        this.offenceDate = offenceDate;
        this.offenceWording = offenceWording;
    }

    public SjpOffence() { }

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

    @Override
    public String toString() {
        return "Offence{" +
                "tflCaseId='" + tflCaseId + '\'' +
                ", offenceSequenceNo=" + offenceSequenceNo +
                ", libraOffenceCode='" + libraOffenceCode + '\'' +
                ", libraOffenceDateCode=" + libraOffenceDateCode +
                ", offenceDate='" + offenceDate + '\'' +
                ", offenceWording='" + offenceWording + '\'' +
                '}';
    }
}
