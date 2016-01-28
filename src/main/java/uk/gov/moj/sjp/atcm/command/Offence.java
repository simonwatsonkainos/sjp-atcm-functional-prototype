package uk.gov.moj.sjp.atcm.command;

public class Offence {

    private String offenceCode;
    private String offenceWording;

    public Offence() { }

    public String getOffenceCode() {
        return offenceCode;
    }

    public String getOffenceWording() {
        return offenceWording;
    }

    public void setOffenceCode(String offenceCode) {
        this.offenceCode = offenceCode;
    }

    public void setOffenceWording(String offenceWording) {
        this.offenceWording = offenceWording;
    }
}
