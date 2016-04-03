package uk.gov.moj.sjp.atcm.persistence.dao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "offence")
public class Offence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID caseId;
    private String tflCaseId;
    private int offenceSequenceNo;
    private String libraOffenceCode;
    private int libraOffenceDateCode;
    private String offenceDate;
    private String offenceWording;

    public Offence() {

    }

    @JsonCreator
    public Offence(@JsonProperty UUID caseId,
                   @JsonProperty String tflCaseId,
                   @JsonProperty int offenceSequenceNo,
                   @JsonProperty String libraOffenceCode,
                   @JsonProperty int libraOffenceDateCode,
                   @JsonProperty String offenceDate,
                   @JsonProperty String offenceWording) {
        this.caseId = caseId;
        this.tflCaseId = tflCaseId;
        this.offenceSequenceNo = offenceSequenceNo;
        this.libraOffenceCode = libraOffenceCode;
        this.libraOffenceDateCode = libraOffenceDateCode;
        this.offenceDate = offenceDate;
        this.offenceWording = offenceWording;
    }

    public UUID getCaseId() {
        return caseId;
    }

    public void setCaseId(UUID caseId) {
        this.caseId = caseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
