package uk.gov.moj.sjp.atcm.command;


import java.util.List;

public class CreateSjpCase {

    private String name;

    private List<Offence> offences;

    public CreateSjpCase() {

    }

    public CreateSjpCase(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Offence> getOffences() {
        return offences;
    }

    public void setOffences(List<Offence> offences) {
        this.offences = offences;
    }
}
