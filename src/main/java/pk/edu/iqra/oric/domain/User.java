package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "salutation", length = 45)
    private String salutation;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "middle_name", length = 45)
    private String middleName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "phone", length = 45)
    private String phone;

    @Column(name = "mobile", length = 45)
    private String mobile;

    @Column(name = "permanent_status", length = 45)
    private String permanentStatus;

    @Column(name = "qualification_level", length = 45)
    private String qualificationLevel;

    @Column(name = "qualification_title", length = 45)
    private String qualificationTitle;

    @Column(name = "cnic", length = 45)
    private String cnic;

    @Column(name = "personal_url", length = 45)
    private String personalUrl;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "field_of_study", length = 100)
    private String fieldOfStudy;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university")
    private University university;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "joinning_date")
    private LocalDate joinningDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDate getJoinningDate() {
        return joinningDate;
    }

    public void setJoinningDate(LocalDate joinningDate) {
        this.joinningDate = joinningDate;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPermanentStatus() {
        return permanentStatus;
    }

    public void setPermanentStatus(String permanentStatus) {
        this.permanentStatus = permanentStatus;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public String getQualificationTitle() {
        return qualificationTitle;
    }

    public void setQualificationTitle(String qualificationTitle) {
        this.qualificationTitle = qualificationTitle;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPersonalUrl() {
        return personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}