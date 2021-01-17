package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Branch;
import pl.kab.carstogo.model.RentalCompany;

import java.util.List;
import java.util.Objects;

public class RentalCompanyEntity {
    private String name;
    private String domain;
    private String contactInfo;
    private String owners;
    //private (typ) logo;
    private List<Branch> branches;

    public RentalCompanyEntity() {
    }

    public RentalCompanyEntity(String name, String domain, String contactInfo, String owners, List<Branch> branches) {
        this.name = name;
        this.domain = domain;
        this.contactInfo = contactInfo;
        this.owners = owners;
        this.branches = branches;
    }

    public RentalCompany mapToRentalCompany(){
        RentalCompany rentalCompany = new RentalCompany(name,domain,contactInfo,owners,branches);
        return  rentalCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

}
