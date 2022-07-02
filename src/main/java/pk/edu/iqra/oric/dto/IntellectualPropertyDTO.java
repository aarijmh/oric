package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.IntellectualProperty;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class IntellectualPropertyDTO extends DtoInterface {


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
    private String patentFiledWith;
    private String fieldOfUse;
    private String dateOfFilling;
    private String financialSupport;
    private String previousDisclosure;
    private String status;
    private Integer oricSessionId;
    private Integer facultyId;
    private String facultyName;
    private String campusName;


    public IntellectualPropertyDTO() {
    }


    public IntellectualPropertyDTO(IntellectualProperty intellectualProperty) {
        copyFromObject(this, intellectualProperty);
    }


    public static void copyFromObject(IntellectualPropertyDTO intellectualPropertyDTO, IntellectualProperty classObject) {

        intellectualPropertyDTO.id = classObject.getId();
        if (classObject.getInventor() != null) {
            intellectualPropertyDTO.inventorId = classObject.getInventor().getId();
            intellectualPropertyDTO.inventorName = UserUtility.getNameFromUser(classObject.getInventor());
        }
        if (classObject.getCoInventor() != null) {
            intellectualPropertyDTO.coInventorId = classObject.getCoInventor().getId();
            intellectualPropertyDTO.coInventorName = UserUtility.getNameFromUser(classObject.getCoInventor());
        }
        intellectualPropertyDTO.title = classObject.getTitle();
        intellectualPropertyDTO.category = classObject.getCategory();
        intellectualPropertyDTO.developmentStatus = classObject.getDevelopmentStatus();
        intellectualPropertyDTO.keyScientificAspects = classObject.getKeyScientificAspects();
        intellectualPropertyDTO.commercialPartner = classObject.getCommercialPartner();
        intellectualPropertyDTO.national = classObject.getNational();
        intellectualPropertyDTO.patentFiledWith = classObject.getPatentFiledWith();
        intellectualPropertyDTO.fieldOfUse = classObject.getFieldOfUse();
        intellectualPropertyDTO.dateOfFilling = UtilityFunctions.localDateToString(classObject.getDateOfFilling());
        intellectualPropertyDTO.financialSupport = classObject.getFinancialSupport();
        intellectualPropertyDTO.previousDisclosure = classObject.getPreviousDisclosure();
        intellectualPropertyDTO.status = classObject.getStatus();
        if (classObject.getOricSession() != null) {
            intellectualPropertyDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if (classObject.getFaculty() != null) {
            intellectualPropertyDTO.facultyId = classObject.getFaculty().getId();
            intellectualPropertyDTO.facultyName = classObject.getFaculty().getName();
            intellectualPropertyDTO.campusName = classObject.getFaculty().getCampus().getName();
        }


    }


    public static void copyFromDto(IntellectualPropertyDTO intellectualPropertyDTO, IntellectualProperty classObject) {
        classObject.setId(intellectualPropertyDTO.id);
        classObject.setTitle(intellectualPropertyDTO.title);
        classObject.setCategory(intellectualPropertyDTO.category);
        classObject.setDevelopmentStatus(intellectualPropertyDTO.developmentStatus);
        classObject.setKeyScientificAspects(intellectualPropertyDTO.keyScientificAspects);
        classObject.setCommercialPartner(intellectualPropertyDTO.commercialPartner);
        classObject.setNational(intellectualPropertyDTO.national);
        classObject.setPatentFiledWith(intellectualPropertyDTO.patentFiledWith);
        classObject.setFieldOfUse(intellectualPropertyDTO.fieldOfUse);
        classObject.setDateOfFilling(UtilityFunctions.stringToInstantDate(intellectualPropertyDTO.dateOfFilling));
        classObject.setFinancialSupport(intellectualPropertyDTO.financialSupport);
        classObject.setPreviousDisclosure(intellectualPropertyDTO.previousDisclosure);
        classObject.setStatus(intellectualPropertyDTO.status);

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

    public String getPatentFiledWith() {
        return patentFiledWith;
    }

    public void setPatentFiledWith(String patentFiledWith) {
        this.patentFiledWith = patentFiledWith;
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

    public String getFinancialSupport() {
        return financialSupport;
    }

    public void setFinancialSupport(String financialSupport) {
        this.financialSupport = financialSupport;
    }

    public String getPreviousDisclosure() {
        return previousDisclosure;
    }

    public void setPreviousDisclosure(String previousDisclosure) {
        this.previousDisclosure = previousDisclosure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
