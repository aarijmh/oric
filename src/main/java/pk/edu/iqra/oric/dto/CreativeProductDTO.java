package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.CreativeProduct;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class CreativeProductDTO extends DtoInterface {


    private Integer id;
    private Integer leadId;
    private String leadName;
    private Integer coLeadId;
    private String coLeadName;
    private String title;
    private String category;
    private String national;
    private String forum;
    private String dateOfFilling;
    private String fieldOfUse;
    private String financialSupport;
    private String status;
    private String remarks;
    private Integer oricSessionId;
    private Integer facultyId;
    private String facultyName;

    private String campusName;

    public CreativeProductDTO() {
    }


    public CreativeProductDTO(CreativeProduct creativeProduct) {
        copyFromObject(this, creativeProduct);
    }


    public static void copyFromObject(CreativeProductDTO creativeProductDTO, CreativeProduct classObject) {

        creativeProductDTO.id = classObject.getId();
        if (classObject.getLead() != null) {
            creativeProductDTO.leadId = classObject.getLead().getId();
            creativeProductDTO.leadName = UserUtility.getNameFromUser(classObject.getLead());
        }
        if (classObject.getCoLead() != null) {
            creativeProductDTO.coLeadId = classObject.getCoLead().getId();
            creativeProductDTO.coLeadName = UserUtility.getNameFromUser(classObject.getCoLead());
        }
        creativeProductDTO.title = classObject.getTitle();
        creativeProductDTO.category = classObject.getCategory();
        creativeProductDTO.national = classObject.getNational();
        creativeProductDTO.forum = classObject.getForum();
        creativeProductDTO.dateOfFilling = UtilityFunctions.localDateToString(classObject.getDateOfFilling());
        creativeProductDTO.fieldOfUse = classObject.getFieldOfUse();
        creativeProductDTO.financialSupport = classObject.getFinancialSupport();
        creativeProductDTO.status = classObject.getStatus();
        creativeProductDTO.remarks = classObject.getRemarks();
        if (classObject.getOricSession() != null) {
            creativeProductDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if (classObject.getFaculty() != null) {
            creativeProductDTO.facultyId = classObject.getFaculty().getId();
            creativeProductDTO.facultyName = classObject.getFaculty().getName();
            creativeProductDTO.campusName = classObject.getFaculty().getCampus().getName();
        }

    }


    public static void copyFromDto(CreativeProductDTO creativeProductDTO, CreativeProduct classObject) {
        classObject.setId(creativeProductDTO.id);
        classObject.setTitle(creativeProductDTO.title);
        classObject.setCategory(creativeProductDTO.category);
        classObject.setNational(creativeProductDTO.national);
        classObject.setForum(creativeProductDTO.forum);
        classObject.setDateOfFilling(UtilityFunctions.stringToInstantDate(creativeProductDTO.dateOfFilling));
        classObject.setFieldOfUse(creativeProductDTO.fieldOfUse);
        classObject.setFinancialSupport(creativeProductDTO.financialSupport);
        classObject.setStatus(creativeProductDTO.status);
        classObject.setRemarks(creativeProductDTO.remarks);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public Integer getCoLeadId() {
        return coLeadId;
    }

    public void setCoLeadId(Integer coLeadId) {
        this.coLeadId = coLeadId;
    }

    public String getCoLeadName() {
        return coLeadName;
    }

    public void setCoLeadName(String coLeadName) {
        this.coLeadName = coLeadName;
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

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }

    public String getFieldOfUse() {
        return fieldOfUse;
    }

    public void setFieldOfUse(String fieldOfUse) {
        this.fieldOfUse = fieldOfUse;
    }

    public String getFinancialSupport() {
        return financialSupport;
    }

    public void setFinancialSupport(String financialSupport) {
        this.financialSupport = financialSupport;
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
