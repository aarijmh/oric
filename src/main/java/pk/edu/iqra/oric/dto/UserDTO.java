package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.utility.UserUtility;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import java.util.Objects;

public class UserDTO {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String cnic;
    private String salutation;
    private String permanentStatus;
    private String qualificationLevel;
    private String qualificationTitle;
    private String personalUrl;
    private Boolean status;
    private String fieldOfStudy;
    private String name;

    private String dob;
    private String joinningDate;

    private String mobile;
    private String phone;

    private String password;

    public UserDTO(){

    }

    public UserDTO(User user){
    this.id = user.getId();
    this.name = UserUtility.getNameFromUser(user);
    this.firstName = user.getFirstName();
    this.middleName = user.getMiddleName();
    this.lastName = user.getLastName();
    this.email = user.getEmail();
    this.cnic = user.getCnic();
    this.salutation = user.getSalutation();
    this.permanentStatus = user.getPermanentStatus();
    this.qualificationLevel = user.getQualificationLevel();
    this.qualificationTitle = user.getQualificationTitle();
    this.personalUrl = user.getPersonalUrl();
    this.status = user.getStatus();
    this.fieldOfStudy = user.getFieldOfStudy();
    this.dob = UtilityFunctions.localDateToString(user.getDob());
    this.joinningDate = UtilityFunctions.localDateToString(user.getJoinningDate());
    this.mobile = user.getMobile();
    this.phone = user.getPhone();


    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public String getPersonalUrl() {
        return personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getJoinningDate() {
        return joinningDate;
    }

    public void setJoinningDate(String joinningDate) {
        this.joinningDate = joinningDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(getId(), userDTO.getId()) && Objects.equals(getFirstName(), userDTO.getFirstName()) && Objects.equals(getMiddleName(), userDTO.getMiddleName()) && Objects.equals(getLastName(), userDTO.getLastName()) && Objects.equals(getEmail(), userDTO.getEmail()) && Objects.equals(getCnic(), userDTO.getCnic()) && Objects.equals(getSalutation(), userDTO.getSalutation()) && Objects.equals(getPermanentStatus(), userDTO.getPermanentStatus()) && Objects.equals(getQualificationLevel(), userDTO.getQualificationLevel()) && Objects.equals(getQualificationTitle(), userDTO.getQualificationTitle()) && Objects.equals(getPersonalUrl(), userDTO.getPersonalUrl()) && Objects.equals(getStatus(), userDTO.getStatus()) && Objects.equals(getFieldOfStudy(), userDTO.getFieldOfStudy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getMiddleName(), getLastName(), getEmail(), getCnic(), getSalutation(), getPermanentStatus(), getQualificationLevel(), getQualificationTitle(), getPersonalUrl(), getStatus(), getFieldOfStudy());
    }
}
