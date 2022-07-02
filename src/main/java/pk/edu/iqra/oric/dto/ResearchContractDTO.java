package pk.edu.iqra.oric.dto;
import pk.edu.iqra.oric.domain.ResearchContract;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class ResearchContractDTO extends DtoInterface{


    private Integer id;
    private Integer piId;
    private String piName;
    private Integer coPiId;
    private String coPiName;
    private String type;
    private String national;
    private String hostInstituition;
    private String sponsoringInstituition;
    private String counterpartIndustry;
    private String startDate;
    private String endDate;
    private Double volume;
    private String salientFeature;
    private String contractDate;
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

    public ResearchContractDTO (){}


    public ResearchContractDTO (ResearchContract researchContract){
        copyFromObject(this,researchContract);
    }


    public static void copyFromObject(ResearchContractDTO researchContractDTO, ResearchContract classObject) {

        researchContractDTO.id = classObject.getId();
        if(classObject.getPi() != null ) {
            researchContractDTO.piId = classObject.getPi().getId();
            researchContractDTO.piName = UserUtility.getNameFromUser(classObject.getPi());
        }
        if(classObject.getCoPi() != null ) {
            researchContractDTO.coPiId = classObject.getCoPi().getId();
            researchContractDTO.coPiName = UserUtility.getNameFromUser(classObject.getCoPi());
        }
        researchContractDTO.type = classObject.getType();
        researchContractDTO.national = classObject.getNational();
        researchContractDTO.hostInstituition = classObject.getHostInstituition();
        researchContractDTO.sponsoringInstituition = classObject.getSponsoringInstituition();
        researchContractDTO.counterpartIndustry = classObject.getCounterpartIndustry();
        researchContractDTO.startDate = UtilityFunctions.localDateToString(classObject.getStartDate());
        researchContractDTO.endDate = UtilityFunctions.localDateToString(classObject.getEndDate());
        researchContractDTO.volume = classObject.getVolume();
        researchContractDTO.salientFeature = classObject.getSalientFeature();
        researchContractDTO.contractDate = UtilityFunctions.localDateToString(classObject.getContractDate());
        if(classObject.getOricSession() != null ) {
            researchContractDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if(classObject.getCreatedBy() != null ) {
            researchContractDTO.createdById = classObject.getCreatedBy().getId();
            researchContractDTO.createdByName = UserUtility.getNameFromUser(classObject.getCreatedBy());
        }
        if(classObject.getModifiedBy() != null ) {
            researchContractDTO.modifiedById = classObject.getModifiedBy().getId();
            researchContractDTO.modifiedByName = UserUtility.getNameFromUser(classObject.getModifiedBy());
        }
        researchContractDTO.createdOn = UtilityFunctions.localDateToString(classObject.getCreatedOn());
        researchContractDTO.modifiedOn = UtilityFunctions.localDateToString(classObject.getModifiedOn());
        if(classObject.getFaculty() != null ) {
            researchContractDTO.facultyId = classObject.getFaculty().getId();
            researchContractDTO.facultyName = classObject.getFaculty().getName();
            if(classObject.getFaculty().getCampus() != null)
                researchContractDTO.campusName = classObject.getFaculty().getCampus().getName();
        }
    }



    public static void copyFromDto(ResearchContractDTO researchContractDTO, ResearchContract classObject) {
        classObject.setId(researchContractDTO.id);
        classObject.setType(researchContractDTO.type);
        classObject.setNational(researchContractDTO.national);
        classObject.setHostInstituition(researchContractDTO.hostInstituition);
        classObject.setSponsoringInstituition(researchContractDTO.sponsoringInstituition);
        classObject.setCounterpartIndustry(researchContractDTO.counterpartIndustry);
        classObject.setStartDate(UtilityFunctions.stringToInstantDate(researchContractDTO.startDate));
        classObject.setEndDate(UtilityFunctions.stringToInstantDate(researchContractDTO.endDate));
        classObject.setVolume(researchContractDTO.volume);
        classObject.setSalientFeature(researchContractDTO.salientFeature);
        classObject.setContractDate(UtilityFunctions.stringToInstantDate(researchContractDTO.contractDate));
        classObject.setCreatedOn(UtilityFunctions.stringToInstantDate(researchContractDTO.createdOn));
        classObject.setModifiedOn(UtilityFunctions.stringToInstantDate(researchContractDTO.modifiedOn));
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

    public Integer getCoPiId() {
        return coPiId;
    }

    public void setCoPiId(Integer coPiId) {
        this.coPiId = coPiId;
    }

    public String getCoPiName() {
        return coPiName;
    }

    public void setCoPiName(String coPiName) {
        this.coPiName = coPiName;
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

    public String getSponsoringInstituition() {
        return sponsoringInstituition;
    }

    public void setSponsoringInstituition(String sponsoringInstituition) {
        this.sponsoringInstituition = sponsoringInstituition;
    }

    public String getCounterpartIndustry() {
        return counterpartIndustry;
    }

    public void setCounterpartIndustry(String counterpartIndustry) {
        this.counterpartIndustry = counterpartIndustry;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getSalientFeature() {
        return salientFeature;
    }

    public void setSalientFeature(String salientFeature) {
        this.salientFeature = salientFeature;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
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

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}