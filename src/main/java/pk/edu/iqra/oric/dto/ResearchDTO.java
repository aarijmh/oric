package pk.edu.iqra.oric.dto;
import pk.edu.iqra.oric.domain.Research;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class ResearchDTO extends DtoInterface{


    private Integer id;
    private String nameGrant;
    private Integer principalInvestigatorId;
    private String principalInvestigatorName;
    private Integer facultyId;
    private String facultyName;
    private String thematicArea;
    private String title;
    private String dateStart;
    private String dateEnd;
    private Double fundingRequested;
    private String collaboratingPartners;
    private String cofunders;
    private String remarks;
    private Integer coInvestigator1Id;
    private String coInvestigator1Name;
    private Integer coInvestigator2Id;
    private String coInvestigator2Name;
    private String status;
    private Integer createdById;
    private String createdByName;
    private Integer updatedById;
    private String updatedByName;
    private Integer oricSessionId;
    private String createdOn;
    private String updatedOn;
    private Double fundingGranted;
    private String coInvestigatorOther1;
    private String coInvestigatorOther2;
    private String national;
    private String industrialPartner;
    private Integer proposalTypeId;
    private String proposalTypeName;

    private String campusName;

    public ResearchDTO (){}


    public ResearchDTO (Research research){
        copyFromObject(this,research);
    }


    public static void copyFromObject(ResearchDTO researchDTO, Research classObject) {

        researchDTO.id = classObject.getId();
        researchDTO.nameGrant = classObject.getNameGrant();
        if(classObject.getPrincipalInvestigator() != null ) {
            researchDTO.principalInvestigatorId = classObject.getPrincipalInvestigator().getId();
            researchDTO.principalInvestigatorName = UserUtility.getNameFromUser(classObject.getPrincipalInvestigator());
        }
        if(classObject.getFaculty() != null ) {
            researchDTO.facultyId = classObject.getFaculty().getId();
            researchDTO.facultyName = classObject.getFaculty().getName();
            if(classObject.getFaculty().getCampus() != null)
                researchDTO.campusName = classObject.getFaculty().getCampus().getName();
        }
        researchDTO.thematicArea = classObject.getThematicArea();
        researchDTO.title = classObject.getTitle();
        researchDTO.dateStart = UtilityFunctions.localDateToString(classObject.getDateStart());
        researchDTO.dateEnd = UtilityFunctions.localDateToString(classObject.getDateEnd());
        researchDTO.fundingRequested = classObject.getFundingRequested();
        researchDTO.collaboratingPartners = classObject.getCollaboratingPartners();
        researchDTO.cofunders = classObject.getCofunders();
        researchDTO.remarks = classObject.getRemarks();
        if(classObject.getCoInvestigator1() != null ) {
            researchDTO.coInvestigator1Id = classObject.getCoInvestigator1().getId();
            researchDTO.coInvestigator1Name = UserUtility.getNameFromUser(classObject.getCoInvestigator1());
        }
        if(classObject.getCoInvestigator2() != null ) {
            researchDTO.coInvestigator2Id = classObject.getCoInvestigator2().getId();
            researchDTO.coInvestigator2Name = UserUtility.getNameFromUser(classObject.getCoInvestigator2());
        }
        researchDTO.status = classObject.getStatus();
        if(classObject.getCreatedBy() != null ) {
            researchDTO.createdById = classObject.getCreatedBy().getId();
            researchDTO.createdByName = UserUtility.getNameFromUser(classObject.getCreatedBy());
        }
        if(classObject.getUpdatedBy() != null ) {
            researchDTO.updatedById = classObject.getUpdatedBy().getId();
            researchDTO.updatedByName = UserUtility.getNameFromUser(classObject.getUpdatedBy());
        }
        if(classObject.getOricSession() != null ) {
            researchDTO.oricSessionId = classObject.getOricSession().getId();
        }
        researchDTO.createdOn = UtilityFunctions.localDateToString(classObject.getCreatedOn());
        researchDTO.updatedOn = UtilityFunctions.localDateToString(classObject.getUpdatedOn());
        researchDTO.fundingGranted = classObject.getFundingGranted();
        researchDTO.coInvestigatorOther1 = classObject.getCoInvestigatorOther1();
        researchDTO.coInvestigatorOther2 = classObject.getCoInvestigatorOther2();
        researchDTO.national = classObject.getNational();
        researchDTO.industrialPartner = classObject.getIndustrialPartner();
        if(classObject.getProposalType() != null ) {
            researchDTO.proposalTypeId = classObject.getProposalType().getId();
            researchDTO.proposalTypeName = classObject.getProposalType().getName();
        }
    }



    public static void copyFromDto(ResearchDTO researchDTO, Research classObject) {
        classObject.setId(researchDTO.id);
        classObject.setNameGrant(researchDTO.nameGrant);
        classObject.setThematicArea(researchDTO.thematicArea);
        classObject.setTitle(researchDTO.title);
        classObject.setDateStart(UtilityFunctions.stringToLocalDate(researchDTO.dateStart));
        classObject.setDateEnd(UtilityFunctions.stringToLocalDate(researchDTO.dateEnd));
        classObject.setFundingRequested(researchDTO.fundingRequested);
        classObject.setCollaboratingPartners(researchDTO.collaboratingPartners);
        classObject.setCofunders(researchDTO.cofunders);
        classObject.setRemarks(researchDTO.remarks);
        classObject.setStatus(researchDTO.status);
        classObject.setCreatedOn(UtilityFunctions.stringToLocalDate(researchDTO.createdOn));
        classObject.setUpdatedOn(UtilityFunctions.stringToLocalDate(researchDTO.updatedOn));
        classObject.setFundingGranted(researchDTO.fundingGranted);
        classObject.setCoInvestigatorOther1(researchDTO.coInvestigatorOther1);
        classObject.setCoInvestigatorOther2(researchDTO.coInvestigatorOther2);
        classObject.setNational(researchDTO.national);
        classObject.setIndustrialPartner(researchDTO.industrialPartner);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGrant() {
        return nameGrant;
    }

    public void setNameGrant(String nameGrant) {
        this.nameGrant = nameGrant;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
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

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
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

    public Integer getProposalTypeId() {
        return proposalTypeId;
    }

    public void setProposalTypeId(Integer typeId) {
        this.proposalTypeId = typeId;
    }

    public String getProposalTypeName() {
        return proposalTypeName;
    }

    public void setProposalTypeName(String typeName) {
        this.proposalTypeName = typeName;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}