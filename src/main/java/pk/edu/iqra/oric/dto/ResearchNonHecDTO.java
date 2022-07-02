package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.ResearchNonHec;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class ResearchNonHecDTO extends DtoInterface {


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

    public ResearchNonHecDTO() {
    }


    public ResearchNonHecDTO(ResearchNonHec researchNonHec) {
        copyFromObject(this, researchNonHec);
    }


    public static void copyFromObject(ResearchNonHecDTO researchNonHecDTO, ResearchNonHec classObject) {

        researchNonHecDTO.id = classObject.getId();
        researchNonHecDTO.nameGrant = classObject.getNameGrant();
        researchNonHecDTO.dateSubmission = UtilityFunctions.localDateToString(classObject.getDateSubmission());
        if (classObject.getPrincipalInvestigator() != null) {
            researchNonHecDTO.principalInvestigatorId = classObject.getPrincipalInvestigator().getId();
            researchNonHecDTO.principalInvestigatorName = UserUtility.getNameFromUser(classObject.getPrincipalInvestigator());
        }
        researchNonHecDTO.thematicArea = classObject.getThematicArea();
        researchNonHecDTO.title = classObject.getTitle();
        researchNonHecDTO.dateStart = UtilityFunctions.localDateToString(classObject.getDateStart());
        researchNonHecDTO.dateEnd = UtilityFunctions.localDateToString(classObject.getDateEnd());
        researchNonHecDTO.fundingRequested = classObject.getFundingRequested();
        researchNonHecDTO.collaboratingPartners = classObject.getCollaboratingPartners();
        researchNonHecDTO.cofunders = classObject.getCofunders();
        researchNonHecDTO.status = classObject.getStatus();
        if (classObject.getFaculty() != null) {
            researchNonHecDTO.facultyId = classObject.getFaculty().getId();
            researchNonHecDTO.facultyName = classObject.getFaculty().getName();
            if(classObject.getFaculty().getCampus() != null)
                researchNonHecDTO.campusName = classObject.getFaculty().getCampus().getName();
        }
        if (classObject.getCoInvestigator1() != null) {
            researchNonHecDTO.coInvestigator1Id = classObject.getCoInvestigator1().getId();
            researchNonHecDTO.coInvestigator1Name = UserUtility.getNameFromUser(classObject.getCoInvestigator1());
        }
        if (classObject.getCoInvestigator2() != null) {
            researchNonHecDTO.coInvestigator2Id = classObject.getCoInvestigator2().getId();
            researchNonHecDTO.coInvestigator2Name = UserUtility.getNameFromUser(classObject.getCoInvestigator2());
        }
        researchNonHecDTO.remarks = classObject.getRemarks();

        researchNonHecDTO.fundingGranted = classObject.getFundingGranted();
        researchNonHecDTO.coInvestigatorOther1 = classObject.getCoInvestigatorOther1();
        researchNonHecDTO.coInvestigatorOther2 = classObject.getCoInvestigatorOther2();
        researchNonHecDTO.national = classObject.getNational();
        researchNonHecDTO.industrialPartner = classObject.getIndustrialPartner();
    }


    public static void copyFromDto(ResearchNonHecDTO researchNonHecDTO, ResearchNonHec classObject) {
        classObject.setId(researchNonHecDTO.id);
        classObject.setNameGrant(researchNonHecDTO.nameGrant);
        classObject.setDateSubmission(UtilityFunctions.stringToLocalDate(researchNonHecDTO.dateSubmission));
        classObject.setThematicArea(researchNonHecDTO.thematicArea);
        classObject.setTitle(researchNonHecDTO.title);
        classObject.setDateStart(UtilityFunctions.stringToLocalDate(researchNonHecDTO.dateStart));
        classObject.setDateEnd(UtilityFunctions.stringToLocalDate(researchNonHecDTO.dateEnd));
        classObject.setFundingRequested(researchNonHecDTO.fundingRequested);
        classObject.setCollaboratingPartners(researchNonHecDTO.collaboratingPartners);
        classObject.setCofunders(researchNonHecDTO.cofunders);
        classObject.setStatus(researchNonHecDTO.status);
        classObject.setRemarks(researchNonHecDTO.remarks);
        classObject.setCreatedOn(UtilityFunctions.stringToLocalDate(researchNonHecDTO.createdOn));
        classObject.setModifiedOn(UtilityFunctions.stringToLocalDate(researchNonHecDTO.modifiedOn));
        classObject.setFundingGranted(researchNonHecDTO.fundingGranted);
        classObject.setCoInvestigatorOther1(researchNonHecDTO.coInvestigatorOther1);
        classObject.setCoInvestigatorOther2(researchNonHecDTO.coInvestigatorOther2);
        classObject.setNational(researchNonHecDTO.national);
        classObject.setIndustrialPartner(researchNonHecDTO.industrialPartner);
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
