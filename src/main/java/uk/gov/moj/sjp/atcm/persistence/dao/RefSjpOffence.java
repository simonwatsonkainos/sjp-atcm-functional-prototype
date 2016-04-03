package uk.gov.moj.sjp.atcm.persistence.dao;


import javax.persistence.*;

@Entity
@Table(name = "ref_sjp_offence")
public class RefSjpOffence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String offenceCode;
    private String offenceDescription;
    private boolean fine;
    private boolean compensation;
    private boolean previousCharges;

    public RefSjpOffence(Long id, String offenceCode, String offenceDescription, boolean fine, boolean compensation, boolean previousCharges) {
        this.id = id;
        this.offenceCode = offenceCode;
        this.offenceDescription = offenceDescription;
        this.fine = fine;
        this.compensation = compensation;
        this.previousCharges = previousCharges;
    }

    public RefSjpOffence() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffenceCode() {
        return offenceCode;
    }

    public void setOffenceCode(String offenceCode) {
        this.offenceCode = offenceCode;
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

    @Override
    public String toString() {
        return "RefSjpOffence{" +
                "id=" + id +
                ", offenceCode='" + offenceCode + '\'' +
                ", offenceDescription='" + offenceDescription + '\'' +
                ", fine=" + fine +
                ", compensation=" + compensation +
                ", previousCharges=" + previousCharges +
                '}';
    }
}
