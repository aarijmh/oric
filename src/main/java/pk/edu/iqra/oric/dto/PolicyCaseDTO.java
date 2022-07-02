package pk.edu.iqra.oric.dto;
import pk.edu.iqra.oric.domain.PolicyCase;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class PolicyCaseDTO extends DtoInterface{


    private Integer id;
    private String govtBody;
    private Integer piId;
    private String piName;
    private Integer oricSessionId;
    private String area;
    private String brief;
    private String coalitionPartner;
    private String issueVerification;
    private String advocacyTools;
    private Integer coPi1Id;
    private String coPi1Name;
    private Integer coPi2Id;
    private String coPi2Name;
    private String remarks;
    private Integer createdById;
    private String createdByName;
    private Integer modifiedById;
    private String modifiedByName;
    private String createdOn;
    private String modifiedOn;
    private Integer facultyId;
    private String facultyName;

    private String campusName;

    public PolicyCaseDTO (){}


    public PolicyCaseDTO (PolicyCase policyCase){
        copyFromObject(this,policyCase);
    }


    public static void copyFromObject(PolicyCaseDTO policyCaseDTO, PolicyCase classObject) {

        policyCaseDTO.id = classObject.getId();
        policyCaseDTO.govtBody = classObject.getGovtBody();
        if(classObject.getPi() != null ) {
            policyCaseDTO.piId = classObject.getPi().getId();
            policyCaseDTO.piName = UserUtility.getNameFromUser(classObject.getPi());
        }
        if(classObject.getOricSession() != null ) {
            policyCaseDTO.oricSessionId = classObject.getOricSession().getId();
        }
        policyCaseDTO.area = classObject.getArea();
        policyCaseDTO.brief = classObject.getBrief();
        policyCaseDTO.coalitionPartner = classObject.getCoalitionPartner();
        policyCaseDTO.issueVerification = classObject.getIssueVerification();
        policyCaseDTO.advocacyTools = classObject.getAdvocacyTools();
        if(classObject.getCoPi1() != null ) {
            policyCaseDTO.coPi1Id = classObject.getCoPi1().getId();
            policyCaseDTO.coPi1Name = UserUtility.getNameFromUser(classObject.getCoPi1());
        }
        if(classObject.getCoPi2() != null ) {
            policyCaseDTO.coPi2Id = classObject.getCoPi2().getId();
            policyCaseDTO.coPi2Name = UserUtility.getNameFromUser(classObject.getCoPi2());
        }
        policyCaseDTO.remarks = classObject.getRemarks();
        if(classObject.getCreatedBy() != null ) {
            policyCaseDTO.createdById = classObject.getCreatedBy().getId();
            policyCaseDTO.createdByName = UserUtility.getNameFromUser(classObject.getCreatedBy());
        }
        if(classObject.getModifiedBy() != null ) {
            policyCaseDTO.modifiedById = classObject.getModifiedBy().getId();
            policyCaseDTO.modifiedByName = UserUtility.getNameFromUser(classObject.getModifiedBy());
        }
        policyCaseDTO.createdOn = UtilityFunctions.localDateToString(classObject.getCreatedOn());
        policyCaseDTO.modifiedOn = UtilityFunctions.localDateToString(classObject.getModifiedOn());
        if(classObject.getFaculty() != null ) {
            policyCaseDTO.facultyId = classObject.getFaculty().getId();
            policyCaseDTO.facultyName = classObject.getFaculty().getShortName();

           if( classObject.getFaculty().getCampus() != null){
               policyCaseDTO.campusName = classObject.getFaculty().getCampus().getName();
           }
        }
    }



    public static void copyFromDto(PolicyCaseDTO policyCaseDTO, PolicyCase classObject) {
        classObject.setId(policyCaseDTO.id);
        classObject.setGovtBody(policyCaseDTO.govtBody);
        classObject.setArea(policyCaseDTO.area);
        classObject.setBrief(policyCaseDTO.brief);
        classObject.setCoalitionPartner(policyCaseDTO.coalitionPartner);
        classObject.setIssueVerification(policyCaseDTO.issueVerification);
        classObject.setAdvocacyTools(policyCaseDTO.advocacyTools);
        classObject.setRemarks(policyCaseDTO.remarks);
        classObject.setCreatedOn(UtilityFunctions.stringToInstantDate(policyCaseDTO.createdOn));
        classObject.setModifiedOn(UtilityFunctions.stringToInstantDate(policyCaseDTO.modifiedOn));
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getGovtBody() {
        return govtBody;
    }

    public void setGovtBody(String govtBody) {
        this.govtBody = govtBody;
    }

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public String getPiName() {
        return piName;
    }

    public void setPiName(String piName) {
        this.piName = piName;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCoalitionPartner() {
        return coalitionPartner;
    }

    public void setCoalitionPartner(String coalitionPartner) {
        this.coalitionPartner = coalitionPartner;
    }

    public String getIssueVerification() {
        return issueVerification;
    }

    public void setIssueVerification(String issueVerification) {
        this.issueVerification = issueVerification;
    }

    public String getAdvocacyTools() {
        return advocacyTools;
    }

    public void setAdvocacyTools(String advocacyTools) {
        this.advocacyTools = advocacyTools;
    }

    public Integer getCoPi1Id() {
        return coPi1Id;
    }

    public void setCoPi1Id(Integer coPi1Id) {
        this.coPi1Id = coPi1Id;
    }

    public String getCoPi1Name() {
        return coPi1Name;
    }

    public void setCoPi1Name(String coPi1Name) {
        this.coPi1Name = coPi1Name;
    }

    public Integer getCoPi2Id() {
        return coPi2Id;
    }

    public void setCoPi2Id(Integer coPi2Id) {
        this.coPi2Id = coPi2Id;
    }

    public String getCoPi2Name() {
        return coPi2Name;
    }

    public void setCoPi2Name(String coPi2Name) {
        this.coPi2Name = coPi2Name;
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