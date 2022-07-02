package pk.edu.iqra.oric.dto;
import pk.edu.iqra.oric.domain.ConsultancyContract;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class ConsultancyContractDTO extends DtoInterface{


    private Integer id;
    private Integer piId;
    private String piName;
    private Integer coPiId;
    private String coPiName;
    private String title;
    private String dateExecution;
    private String national;
    private String hostInstituition;
    private String sponsoringInstituition;
    private String counterpartIndustry;
    private String startDate;
    private String endDate;
    private Double volume;
    private String type;
    private String salientFeature;
    private Double oricPercentage;
    private String remarks;
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

    public ConsultancyContractDTO (){}


    public ConsultancyContractDTO (ConsultancyContract consultancyContract){
        copyFromObject(this,consultancyContract);
    }


    public static void copyFromObject(ConsultancyContractDTO consultancyContractDTO, ConsultancyContract classObject) {

        consultancyContractDTO.id = classObject.getId();
        if(classObject.getPi() != null ) {
            consultancyContractDTO.piId = classObject.getPi().getId();
            consultancyContractDTO.piName = UserUtility.getNameFromUser(classObject.getPi());
        }
        if(classObject.getCoPi() != null ) {
            consultancyContractDTO.coPiId = classObject.getCoPi().getId();
            consultancyContractDTO.coPiName = UserUtility.getNameFromUser(classObject.getCoPi());
        }
        consultancyContractDTO.title = classObject.getTitle();
        consultancyContractDTO.dateExecution = UtilityFunctions.localDateToString(classObject.getDateExecution());
        consultancyContractDTO.national = classObject.getNational();
        consultancyContractDTO.hostInstituition = classObject.getHostInstituition();
        consultancyContractDTO.sponsoringInstituition = classObject.getSponsoringInstituition();
        consultancyContractDTO.counterpartIndustry = classObject.getCounterpartIndustry();
        consultancyContractDTO.startDate = UtilityFunctions.localDateToString(classObject.getStartDate());
        consultancyContractDTO.endDate = UtilityFunctions.localDateToString(classObject.getEndDate());
        consultancyContractDTO.volume = classObject.getVolume();
        consultancyContractDTO.type = classObject.getType();
        consultancyContractDTO.salientFeature = classObject.getSalientFeature();
        consultancyContractDTO.oricPercentage = classObject.getOricPercentage();
        consultancyContractDTO.remarks = classObject.getRemarks();
        if(classObject.getOricSession() != null ) {
            consultancyContractDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if(classObject.getCreatedBy() != null ) {
            consultancyContractDTO.createdById = classObject.getCreatedBy().getId();
            consultancyContractDTO.createdByName = UserUtility.getNameFromUser(classObject.getCreatedBy());
        }
        if(classObject.getModifiedBy() != null ) {
            consultancyContractDTO.modifiedById = classObject.getModifiedBy().getId();
            consultancyContractDTO.modifiedByName = UserUtility.getNameFromUser(classObject.getModifiedBy());
        }
        consultancyContractDTO.createdOn = UtilityFunctions.localDateToString(classObject.getCreatedOn());
        consultancyContractDTO.modifiedOn = UtilityFunctions.localDateToString(classObject.getModifiedOn());
        if(classObject.getFaculty() != null ) {
            consultancyContractDTO.facultyId = classObject.getFaculty().getId();
            consultancyContractDTO.facultyName = classObject.getFaculty().getName();
            if(classObject.getFaculty().getCampus() != null){
                consultancyContractDTO.campusName = classObject.getFaculty().getCampus().getName();
            }
        }
    }



    public static void copyFromDto(ConsultancyContractDTO consultancyContractDTO, ConsultancyContract classObject) {
        classObject.setId(consultancyContractDTO.id);
        classObject.setTitle(consultancyContractDTO.title);
        classObject.setDateExecution(UtilityFunctions.stringToInstantDate(consultancyContractDTO.dateExecution));
        classObject.setNational(consultancyContractDTO.national);
        classObject.setHostInstituition(consultancyContractDTO.hostInstituition);
        classObject.setSponsoringInstituition(consultancyContractDTO.sponsoringInstituition);
        classObject.setCounterpartIndustry(consultancyContractDTO.counterpartIndustry);
        classObject.setStartDate(UtilityFunctions.stringToInstantDate(consultancyContractDTO.startDate));
        classObject.setEndDate(UtilityFunctions.stringToInstantDate(consultancyContractDTO.endDate));
        classObject.setVolume(consultancyContractDTO.volume);
        classObject.setType(consultancyContractDTO.type);
        classObject.setSalientFeature(consultancyContractDTO.salientFeature);
        classObject.setOricPercentage(consultancyContractDTO.oricPercentage);
        classObject.setRemarks(consultancyContractDTO.remarks);
        classObject.setCreatedOn(UtilityFunctions.stringToInstantDate(consultancyContractDTO.createdOn));
        classObject.setModifiedOn(UtilityFunctions.stringToInstantDate(consultancyContractDTO.modifiedOn));
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(String dateExecution) {
        this.dateExecution = dateExecution;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalientFeature() {
        return salientFeature;
    }

    public void setSalientFeature(String salientFeature) {
        this.salientFeature = salientFeature;
    }

    public Double getOricPercentage() {
        return oricPercentage;
    }

    public void setOricPercentage(Double oricPercentage) {
        this.oricPercentage = oricPercentage;
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