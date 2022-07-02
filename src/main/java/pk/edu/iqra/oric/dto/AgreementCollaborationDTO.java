package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.AggrementCollaboration;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class AgreementCollaborationDTO extends DtoInterface {


    private Integer id;
    private Integer initiatorId;
    private String initiatorName;
    private String typeLink;
    private String national;
    private String hostInstituition;
    private Integer duration;
    private String keyInitiative;
    private String fieldOfUse;
    private String scope;
    private String dateOfEstablishment;
    private String financialSupport;
    private String remarks;
    private Integer oricSessionId;
    private Integer facultyId;
    private String facultyName;

    private String campusName;

    public AgreementCollaborationDTO() {
    }


    public AgreementCollaborationDTO(AggrementCollaboration aggrementCollaboration) {
        copyFromObject(this, aggrementCollaboration);
    }


    public static void copyFromObject(AgreementCollaborationDTO agreementCollaborationDTO, AggrementCollaboration classObject) {

        agreementCollaborationDTO.id = classObject.getId();
        if (classObject.getInitiator() != null) {
            agreementCollaborationDTO.initiatorId = classObject.getInitiator().getId();
            agreementCollaborationDTO.initiatorName = UserUtility.getNameFromUser(classObject.getInitiator());
        }
        agreementCollaborationDTO.typeLink = classObject.getTypeLink();
        agreementCollaborationDTO.national = classObject.getNational();
        agreementCollaborationDTO.hostInstituition = classObject.getHostInstituition();
        agreementCollaborationDTO.duration = classObject.getDuration();
        agreementCollaborationDTO.keyInitiative = classObject.getKeyInitiative();
        agreementCollaborationDTO.fieldOfUse = classObject.getFieldOfUse();
        agreementCollaborationDTO.scope = classObject.getScope();
        agreementCollaborationDTO.dateOfEstablishment = UtilityFunctions.localDateToString(classObject.getDateOfEstablishment());
        agreementCollaborationDTO.financialSupport = classObject.getFinancialSupport();
        agreementCollaborationDTO.remarks = classObject.getRemarks();
        if (classObject.getOricSession() != null) {
            agreementCollaborationDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if (classObject.getFaculty() != null) {
            agreementCollaborationDTO.facultyId = classObject.getFaculty().getId();
            agreementCollaborationDTO.facultyName = classObject.getFaculty().getName();
            agreementCollaborationDTO.campusName = classObject.getFaculty().getCampus().getName();
        }

    }


    public static void copyFromDto(AgreementCollaborationDTO agreementCollaborationDTO, AggrementCollaboration classObject) {
        classObject.setId(agreementCollaborationDTO.id);
        classObject.setTypeLink(agreementCollaborationDTO.typeLink);
        classObject.setNational(agreementCollaborationDTO.national);
        classObject.setHostInstituition(agreementCollaborationDTO.hostInstituition);
        classObject.setDuration(agreementCollaborationDTO.duration);
        classObject.setKeyInitiative(agreementCollaborationDTO.keyInitiative);
        classObject.setFieldOfUse(agreementCollaborationDTO.fieldOfUse);
        classObject.setScope(agreementCollaborationDTO.scope);
        classObject.setDateOfEstablishment(UtilityFunctions.stringToInstantDate(agreementCollaborationDTO.dateOfEstablishment));
        classObject.setFinancialSupport(agreementCollaborationDTO.financialSupport);
        classObject.setRemarks(agreementCollaborationDTO.remarks);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(Integer initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getTypeLink() {
        return typeLink;
    }

    public void setTypeLink(String typeLink) {
        this.typeLink = typeLink;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getKeyInitiative() {
        return keyInitiative;
    }

    public void setKeyInitiative(String keyInitiative) {
        this.keyInitiative = keyInitiative;
    }

    public String getFieldOfUse() {
        return fieldOfUse;
    }

    public void setFieldOfUse(String fieldOfUse) {
        this.fieldOfUse = fieldOfUse;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(String dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getFinancialSupport() {
        return financialSupport;
    }

    public void setFinancialSupport(String financialSupport) {
        this.financialSupport = financialSupport;
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
