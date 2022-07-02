package pk.edu.iqra.oric.dto;
import pk.edu.iqra.oric.domain.ResearchLink;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class ResearchLinkDTO extends DtoInterface{


    private Integer id;
    private Integer piId;
    private String piName;
    private String type;
    private String national;
    private String hostInstituition;
    private String collaboratingInstituition;
    private String area;
    private String scope;
    private String linkDate;
    private String salientFeature;
    private Integer oricSessionId;
    private Integer createdById;
    private String createdByName;
    private Integer modifiedById;
    private String modifiedByName;
    private String createdOn;
    private String modifiedOn;
    private Integer facultyId;
    private String facultyName;

    private String campusName;

    public ResearchLinkDTO (){}


    public ResearchLinkDTO (ResearchLink researchLink){
        copyFromObject(this,researchLink);
    }


    public static void copyFromObject(ResearchLinkDTO researchLinkDTO, ResearchLink classObject) {

        researchLinkDTO.id = classObject.getId();
        if(classObject.getPi() != null ) {
            researchLinkDTO.piId = classObject.getPi().getId();
            researchLinkDTO.piName = UserUtility.getNameFromUser(classObject.getPi());
        }
        researchLinkDTO.type = classObject.getType();
        researchLinkDTO.national = classObject.getNational();
        researchLinkDTO.hostInstituition = classObject.getHostInstituition();
        researchLinkDTO.collaboratingInstituition = classObject.getCollaboratingInstituition();
        researchLinkDTO.area = classObject.getArea();
        researchLinkDTO.scope = classObject.getScope();
        researchLinkDTO.linkDate = UtilityFunctions.localDateToString(classObject.getLinkDate());
        researchLinkDTO.salientFeature = classObject.getSalientFeature();
        if(classObject.getOricSession() != null ) {
            researchLinkDTO.oricSessionId = classObject.getOricSession().getId();
        }

        if(classObject.getFaculty() != null ) {
            researchLinkDTO.facultyId = classObject.getFaculty().getId();
            researchLinkDTO.facultyName = classObject.getFaculty().getShortName();
            if(classObject.getFaculty().getCampus() != null){
                researchLinkDTO.campusName = classObject.getFaculty().getCampus().getName();
            }
        }
    }



    public static void copyFromDto(ResearchLinkDTO researchLinkDTO, ResearchLink classObject) {
        classObject.setId(researchLinkDTO.id);
        classObject.setType(researchLinkDTO.type);
        classObject.setNational(researchLinkDTO.national);
        classObject.setHostInstituition(researchLinkDTO.hostInstituition);
        classObject.setCollaboratingInstituition(researchLinkDTO.collaboratingInstituition);
        classObject.setArea(researchLinkDTO.area);
        classObject.setScope(researchLinkDTO.scope);
        classObject.setLinkDate(UtilityFunctions.stringToInstantDate(researchLinkDTO.linkDate));
        classObject.setSalientFeature(researchLinkDTO.salientFeature);
        classObject.setCreatedOn(UtilityFunctions.stringToInstantDate(researchLinkDTO.createdOn));
        classObject.setModifiedOn(UtilityFunctions.stringToInstantDate(researchLinkDTO.modifiedOn));
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getHostInstituition() {
        return hostInstituition;
    }

    public void setHostInstituition(String hostInstituition) {
        this.hostInstituition = hostInstituition;
    }

    public String getCollaboratingInstituition() {
        return collaboratingInstituition;
    }

    public void setCollaboratingInstituition(String collaboratingInstituition) {
        this.collaboratingInstituition = collaboratingInstituition;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(String linkDate) {
        this.linkDate = linkDate;
    }

    public String getSalientFeature() {
        return salientFeature;
    }

    public void setSalientFeature(String salientFeature) {
        this.salientFeature = salientFeature;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
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

    public void setCampusName(String cammpusName) {
        this.campusName = cammpusName;
    }
}