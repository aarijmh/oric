package pk.edu.iqra.oric.domain;

import javax.persistence.*;

@Entity
@Table(name = "oric")
public class Oric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "university", nullable = false)
    private University university;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "website", length = 200)
    private String website;

    @Column(name = "website_short", length = 45)
    private String websiteShort;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "focal_person")
    private User focalPerson;

    @Column(name = "webpage_focal_person")
    private String webpageFocalPerson;

    @Column(name = "bank_account_number", length = 200)
    private String bankAccountNumber;

    @Column(name = "mission")
    private String mission;

    @Column(name = "vision")
    private String vision;

    @Column(name = "about", length = 200)
    private String about;

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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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

    public User getFocalPerson() {
        return focalPerson;
    }

    public void setFocalPerson(User focalPerson) {
        this.focalPerson = focalPerson;
    }

    public String getWebpageFocalPerson() {
        return webpageFocalPerson;
    }

    public void setWebpageFocalPerson(String webpageFocalPerson) {
        this.webpageFocalPerson = webpageFocalPerson;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
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