package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.TrainingOric;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class TrainingOricDTO extends DtoInterface {


    private Integer id;
    private String title;
    private String dateOfEvent;
    private Integer noOfParticipants;
    private String focusArea;
    private String organizer;
    private String audienceType;
    private String remarks;
    private String type;
    private String national;
    private Integer oricSessionId;

    private Boolean arrangedByOric;
    private Boolean forOricPersonnel;

    public TrainingOricDTO() {
    }


    public TrainingOricDTO(TrainingOric trainingOric) {
        copyFromObject(this, trainingOric);
    }


    public static void copyFromObject(TrainingOricDTO trainingOricDTO, TrainingOric classObject) {

        trainingOricDTO.id = classObject.getId();
        trainingOricDTO.title = classObject.getTitle();
        trainingOricDTO.dateOfEvent = UtilityFunctions.localDateToString(classObject.getDateOfEvent());
        trainingOricDTO.noOfParticipants = classObject.getNoOfParticipants();
        trainingOricDTO.focusArea = classObject.getFocusArea();
        trainingOricDTO.organizer = classObject.getOrganizer();
        trainingOricDTO.audienceType = classObject.getAudienceType();
        trainingOricDTO.remarks = classObject.getRemarks();
        trainingOricDTO.type = classObject.getType();
        trainingOricDTO.national = classObject.getNational();
        if (classObject.getOricSession() != null) {
            trainingOricDTO.oricSessionId = classObject.getOricSession().getId();
        }

        trainingOricDTO.arrangedByOric = classObject.getArrangedByOric();
        trainingOricDTO.forOricPersonnel = classObject.getForOricPersonnel();
    }


    public static void copyFromDto(TrainingOricDTO trainingOricDTO, TrainingOric classObject) {
        classObject.setId(trainingOricDTO.id);
        classObject.setTitle(trainingOricDTO.title);
        classObject.setDateOfEvent(UtilityFunctions.stringToInstantDate(trainingOricDTO.dateOfEvent));
        classObject.setNoOfParticipants(trainingOricDTO.noOfParticipants);
        classObject.setFocusArea(trainingOricDTO.focusArea);
        classObject.setOrganizer(trainingOricDTO.organizer);
        classObject.setAudienceType(trainingOricDTO.audienceType);
        classObject.setRemarks(trainingOricDTO.remarks);
        classObject.setType(trainingOricDTO.type);
        classObject.setNational(trainingOricDTO.national);
        classObject.setArrangedByOric(trainingOricDTO.arrangedByOric);
        classObject.setForOricPersonnel(trainingOricDTO.forOricPersonnel);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public Integer getNoOfParticipants() {
        return noOfParticipants;
    }

    public void setNoOfParticipants(Integer noOfParticipants) {
        this.noOfParticipants = noOfParticipants;
    }

    public String getFocusArea() {
        return focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getAudienceType() {
        return audienceType;
    }

    public void setAudienceType(String audienceType) {
        this.audienceType = audienceType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public Boolean getArrangedByOric() {
        return arrangedByOric;
    }

    public void setArrangedByOric(Boolean arrangedByOric) {
        this.arrangedByOric = arrangedByOric;
    }

    public Boolean getForOricPersonnel() {
        return forOricPersonnel;
    }

    public void setForOricPersonnel(Boolean forOricPersonnel) {
        this.forOricPersonnel = forOricPersonnel;
    }
}
