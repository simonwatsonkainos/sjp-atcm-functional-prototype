package uk.gov.moj.sjp.atcm.persistence.dao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "defendant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Defendant {

    @Id
    private UUID id;
    private String title;
    private String forename;
    private String familyName;
    private String address;
    private String town;
    private String county;
    private String postcode;
    private String dob;
    private char gender;

    public Defendant() { }

    @JsonCreator
    public Defendant(@JsonProperty UUID id,
                     @JsonProperty String title,
                     @JsonProperty String forename,
                     @JsonProperty String familyName,
                     @JsonProperty String address,
                     @JsonProperty String town,
                     @JsonProperty String county,
                     @JsonProperty String postcode,
                     @JsonProperty String dob,
                     @JsonProperty char gender) {
        this.id = id;
        this.title = title;
        this.forename = forename;
        this.familyName = familyName;
        this.address = address;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
        this.dob = dob;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
