package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.License;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class LicenseDTO extends DtoInterface {


    private Integer id;
    private Integer inventorId;
    private String inventorName;
    private Integer coInventorId;
    private String coInventorName;
    private String title;
    private String category;
    private String developmentStatus;
    private String keyScientificAspects;
    private String commercialPartner;
    private String national;
    private String fieldOfUse;
    private String dateOfFilling;
    private Integer duration;
    private String licensee;
    private String financialSupport;
    private String exclusive;
    private String status;
    private String remarks;
    private Integer oricSessionId;
    private Integer facultyId;
    private String facultyName;

    private String campusName;

    public LicenseDTO() {
    }


    public LicenseDTO(License license) {
        copyFromObject(this, license);
    }


    public static void copyFromObject(LicenseDTO licenseDTO, License classObject) {

        licenseDTO.id = classObject.getId();
        if (classObject.getInventor() != null) {
            licenseDTO.inventorId = classObject.getInventor().getId();
            licenseDTO.inventorName = UserUtility.getNameFromUser(classObject.getInventor());
        }
        if (classObject.getCoInventor() != null) {
            licenseDTO.coInventorId = classObject.getCoInventor().getId();
            licenseDTO.coInventorName = UserUtility.getNameFromUser(classObject.getCoInventor());
        }
        licenseDTO.title = classObject.getTitle();
        licenseDTO.category = classObject.getCategory();
        licenseDTO.developmentStatus = classObject.getDevelopmentStatus();
        licenseDTO.keyScientificAspects = classObject.getKeyScientificAspects();
        licenseDTO.commercialPartner = classObject.getCommercialPartner();
        licenseDTO.national = classObject.getNational();
        licenseDTO.fieldOfUse = classObject.getFieldOfUse();
        licenseDTO.dateOfFilling = UtilityFunctions.localDateToString(classObject.getDateOfFilling());
        licenseDTO.duration = classObject.getDuration();
        licenseDTO.licensee = classObject.getLicensee();
        licenseDTO.financialSupport = classObject.getFinancialSupport();
        licenseDTO.exclusive = classObject.getExclusive();
        licenseDTO.status = classObject.getStatus();
        licenseDTO.remarks = classObject.getRemarks();
        if (classObject.getOricSession() != null) {
            licenseDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if (classObject.getFaculty() != null) {
            licenseDTO.facultyId = classObject.getFaculty().getId();
            licenseDTO.facultyName = classObject.getFaculty().getName();
            licenseDTO.campusName = classObject.getFaculty().getCampus().getName();
        }
    }


    public static void copyFromDto(LicenseDTO licenseDTO, License classObject) {
        classObject.setId(licenseDTO.id);
        classObject.setTitle(licenseDTO.title);
        classObject.setCategory(licenseDTO.category);
        classObject.setDevelopmentStatus(licenseDTO.developmentStatus);
        classObject.setKeyScientificAspects(licenseDTO.keyScientificAspects);
        classObject.setCommercialPartner(licenseDTO.commercialPartner);
        classObject.setNational(licenseDTO.national);
        classObject.setFieldOfUse(licenseDTO.fieldOfUse);
        classObject.setDateOfFilling(UtilityFunctions.stringToInstantDate(licenseDTO.dateOfFilling));
        classObject.setDuration(licenseDTO.duration);
        classObject.setLicensee(licenseDTO.licensee);
        classObject.setFinancialSupport(licenseDTO.financialSupport);
        classObject.setExclusive(licenseDTO.exclusive);
        classObject.setStatus(licenseDTO.status);
        classObject.setRemarks(licenseDTO.remarks);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventorId() {
        return inventorId;
    }

    public void setInventorId(Integer inventorId) {
        this.inventorId = inventorId;
    }

    public String getInventorName() {
        return inventorName;
    }

    public void setInventorName(String inventorName) {
        this.inventorName = inventorName;
    }

    public Integer getCoInventorId() {
        return coInventorId;
    }

    public void setCoInventorId(Integer coInventorId) {
        this.coInventorId = coInventorId;
    }

    public String getCoInventorName() {
        return coInventorName;
    }

    public void setCoInventorName(String coInventorName) {
        this.coInventorName = coInventorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDevelopmentStatus() {
        return developmentStatus;
    }

    public void setDevelopmentStatus(String developmentStatus) {
        this.developmentStatus = developmentStatus;
    }

    public String getKeyScientificAspects() {
        return keyScientificAspects;
    }

    public void setKeyScientificAspects(String keyScientificAspects) {
        this.keyScientificAspects = keyScientificAspects;
    }

    public String getCommercialPartner() {
        return commercialPartner;
    }

    public void setCommercialPartner(String commercialPartner) {
        this.commercialPartner = commercialPartner;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getFieldOfUse() {
        return fieldOfUse;
    }

    public void setFieldOfUse(String fieldOfUse) {
        this.fieldOfUse = fieldOfUse;
    }

    public String getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLicensee() {
        return licensee;
    }

    public void setLicensee(String licensee) {
        this.licensee = licensee;
    }

    public String getFinancialSupport() {
        return financialSupport;
    }

    public void setFinancialSupport(String financialSupport) {
        this.financialSupport = financialSupport;
    }

    public String getExclusive() {
        return exclusive;
    }

    public void setExclusive(String exclusive) {
        this.exclusive = exclusive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
