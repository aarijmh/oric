package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.Oric;

public class OricDTO {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String website;
    private String websiteShort;
    private String focalPersonWebsite;
    private Integer focal;
    private String bankAccount;

    private String mission;
    private String vision;
    private String about;

    public OricDTO(){

    }

    public OricDTO(Oric oric){
        if(oric == null)
            return;
        this.id = oric.getId();
        this.name = oric.getName();
        this.address = oric.getAddress();
        this.email = oric.getEmail();
        this.website = oric.getWebsite();
        this.websiteShort = oric.getWebsiteShort();
        this.bankAccount = oric.getBankAccountNumber();
        this.focalPersonWebsite = oric.getWebpageFocalPerson();
        this.focal = oric.getFocalPerson().getId();
        this.about = oric.getAbout();
        this.mission = oric.getMission();
        this.vision = oric.getVision();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsiteShort() {
        return websiteShort;
    }

    public void setWebsiteShort(String websiteShort) {
        this.websiteShort = websiteShort;
    }

    public String getFocalPersonWebsite() {
        return focalPersonWebsite;
    }

    public void setFocalPersonWebsite(String focalPersonWebsite) {
        this.focalPersonWebsite = focalPersonWebsite;
    }

    public Integer getFocal() {
        return focal;
    }

    public void setFocal(Integer focal) {
        this.focal = focal;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
