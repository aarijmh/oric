package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.JointResearch;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class JointResearchDTO extends DtoInterface {


    private Integer id;
    private String nameGrant;
    private String dateSubmission;
    private Integer principalInvestigatorId;
    private String principalInvestigatorName;
    private String thematicArea;
    private String title;
    private String dateStart;
    private String dateEnd;
    private Double fundingRequested;
    private String collaboratingPartners;
    private String cofunders;
    private String status;
    private Integer facultyId;
    private String facultyName;
    private Integer coInvestigator1Id;
    private String coInvestigator1Name;
    private Integer coInvestigator2Id;
    private String coInvestigator2Name;
    private String remarks;
    private Integer createdById;
    private String createdByName;
    private Integer modifiedById;
    private String modifiedByName;
    private Integer oricSessionId;
    private String createdOn;
    private String modifiedOn;
    private Double fundingGranted;
    private String coInvestigatorOther1;
    private String coInvestigatorOther2;
    private String national;
    private String industrialPartner;

    private String campusName;

    public JointResearchDTO() {
    }


    public JointResearchDTO(JointResearch jointResearch) {
        copyFromObject(this, jointResearch);
    }


    public static void copyFromObject(JointResearchDTO jointResearchDTO, JointResearch classObject) {

        jointResearchDTO.id = classObject.getId();
        jointResearchDTO.nameGrant = classObject.getNameGrant();
        jointResearchDTO.dateSubmission = UtilityFunctions.localDateToString(classObject.getDateSubmission());
        if (classObject.getPrincipalInvestigator() != null) {
            jointResearchDTO.principalInvestigatorId = classObject.getPrincipalInvestigator().getId();
            jointResearchDTO.principalInvestigatorName = UserUtility.getNameFromUser(classObject.getPrincipalInvestigator());
        }
        jointResearchDTO.thematicArea = classObject.getThematicArea();
        jointResearchDTO.title = classObject.getTitle();
        jointResearchDTO.dateStart = UtilityFunctions.localDateToString(classObject.getDateStart());
        jointResearchDTO.dateEnd = UtilityFunctions.localDateToString(classObject.getDateEnd());
        jointResearchDTO.fundingRequested = classObject.getFundingRequested();
        jointResearchDTO.collaboratingPartners = classObject.getCollaboratingPartners();
        jointResearchDTO.cofunders = classObject.getCofunders();
        jointResearchDTO.status = classObject.getStatus();
        if (classObject.getFaculty() != null) {
            jointResearchDTO.facultyId = classObject.getFaculty().getId();
            jointResearchDTO.facultyName = classObject.getFaculty().getName();
            jointResearchDTO.campusName = classObject.getFaculty().getCampus().getName();
        }
        if (classObject.getCoInvestigator1() != null) {
            jointResearchDTO.coInvestigator1Id = classObject.getCoInvestigator1().getId();
            jointResearchDTO.coInvestigator1Name = UserUtility.getNameFromUser(classObject.getCoInvestigator1());
        }
        if (classObject.getCoInvestigator2() != null) {
            jointResearchDTO.coInvestigator2Id = classObject.getCoInvestigator2().getId();
            jointResearchDTO.coInvestigator2Name = UserUtility.getNameFromUser(classObject.getCoInvestigator2());
        }
        jointResearchDTO.remarks = classObject.getRemarks();

        jointResearchDTO.createdOn = UtilityFunctions.localDateToString(classObject.getCreatedOn());
        jointResearchDTO.modifiedOn = UtilityFunctions.localDateToString(classObject.getModifiedOn());
        jointResearchDTO.fundingGranted = classObject.getFundingGranted();
        jointResearchDTO.coInvestigatorOther1 = classObject.getCoInvestigatorOther1();
        jointResearchDTO.coInvestigatorOther2 = classObject.getCoInvestigatorOther2();
        jointResearchDTO.national = classObject.getNational();
        jointResearchDTO.industrialPartner = classObject.getIndustrialPartner();
    }


    public static void copyFromDto(JointResearchDTO jointResearchDTO, JointResearch classObject) {
        classObject.setId(jointResearchDTO.id);
        classObject.setNameGrant(jointResearchDTO.nameGrant);
        classObject.setDateSubmission(UtilityFunctions.stringToLocalDate(jointResearchDTO.dateSubmission));
        classObject.setThematicArea(jointResearchDTO.thematicArea);
        classObject.setTitle(jointResearchDTO.title);
        classObject.setDateStart(UtilityFunctions.stringToLocalDate(jointResearchDTO.dateStart));
        classObject.setDateEnd(UtilityFunctions.stringToLocalDate(jointResearchDTO.dateEnd));
        classObject.setFundingRequested(jointResearchDTO.fundingRequested);
        classObject.setCollaboratingPartners(jointResearchDTO.collaboratingPartners);
        classObject.setCofunders(jointResearchDTO.cofunders);
        classObject.setStatus(jointResearchDTO.status);
        classObject.setRemarks(jointResearchDTO.remarks);
        classObject.setCreatedOn(UtilityFunctions.stringToLocalDate(jointResearchDTO.createdOn));
        classObject.setModifiedOn(UtilityFunctions.stringToLocalDate(jointResearchDTO.modifiedOn));
        classObject.setFundingGranted(jointResearchDTO.fundingGranted);
        classObject.setCoInvestigatorOther1(jointResearchDTO.coInvestigatorOther1);
        classObject.setCoInvestigatorOther2(jointResearchDTO.coInvestigatorOther2);
        classObject.setNational(jointResearchDTO.national);
        classObject.setIndustrialPartner(jointResearchDTO.industrialPartner);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGrant() {
        return nameGrant;
    }

    public void setNameGrant(String nameGrant) {
        this.nameGrant = nameGrant;
    }

    public String getDateSubmission() {
        return dateSubmission;
    }

    public void setDateSubmission(String dateSubmission) {
        this.dateSubmission = dateSubmission;
    }

    public Integer getPrincipalInvestigatorId() {
        return principalInvestigatorId;
    }

    public void setPrincipalInvestigatorId(Integer principalInvestigatorId) {
        this.principalInvestigatorId = principalInvestigatorId;
    }

    public String getPrincipalInvestigatorName() {
        return principalInvestigatorName;
    }

    public void setPrincipalInvestigatorName(String principalInvestigatorName) {
        this.principalInvestigatorName = principalInvestigatorName;
    }

    public String getThematicArea() {
        return thematicArea;
    }

    public void setThematicArea(String thematicArea) {
        this.thematicArea = thematicArea;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Double getFundingRequested() {
        return fundingRequested;
    }

    public void setFundingRequested(Double fundingRequested) {
        this.fundingRequested = fundingRequested;
    }

    public String getCollaboratingPartners() {
        return collaboratingPartners;
    }

    public void setCollaboratingPartners(String collaboratingPartners) {
        this.collaboratingPartners = collaboratingPartners;
    }

    public String getCofunders() {
        return cofunders;
    }

    public void setCofunders(String cofunders) {
        this.cofunders = cofunders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getCoInvestigator1Id() {
        return coInvestigator1Id;
    }

    public void setCoInvestigator1Id(Integer coInvestigator1Id) {
        this.coInvestigator1Id = coInvestigator1Id;
    }

    public String getCoInvestigator1Name() {
        return coInvestigator1Name;
    }

    public void setCoInvestigator1Name(String coInvestigator1Name) {
        this.coInvestigator1Name = coInvestigator1Name;
    }

    public Integer getCoInvestigator2Id() {
        return coInvestigator2Id;
    }

    public void setCoInvestigator2Id(Integer coInvestigator2Id) {
        this.coInvestigator2Id = coInvestigator2Id;
    }

    public String getCoInvestigator2Name() {
        return coInvestigator2Name;
    }

    public void setCoInvestigator2Name(String coInvestigator2Name) {
        this.coInvestigator2Name = coInvestigator2Name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public Integer getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Integer modifiedById) {
        this.modifiedById = modifiedById;
    }

    public String getModifiedByName() {
        return modifiedByName;
    }

    public void setModifiedByName(String modifiedByName) {
        this.modifiedByName = modifiedByName;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Double getFundingGranted() {
        return fundingGranted;
    }

    public void setFundingGranted(Double fundingGranted) {
        this.fundingGranted = fundingGranted;
    }

    public String getCoInvestigatorOther1() {
        return coInvestigatorOther1;
    }

    public void setCoInvestigatorOther1(String coInvestigatorOther1) {
        this.coInvestigatorOther1 = coInvestigatorOther1;
    }

    public String getCoInvestigatorOther2() {
        return coInvestigatorOther2;
    }

    public void setCoInvestigatorOther2(String coInvestigatorOther2) {
        this.coInvestigatorOther2 = coInvestigatorOther2;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIndustrialPartner() {
        return industrialPartner;
    }

    public void setIndustrialPartner(String industrialPartner) {
        this.industrialPartner = industrialPartner;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
