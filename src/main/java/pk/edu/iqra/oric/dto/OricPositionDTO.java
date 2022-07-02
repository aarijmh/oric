package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.OricPosition;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class OricPositionDTO extends DtoInterface {


    private Integer id;
    private Integer oricSessionId;
    private Integer userId;
    private String userName;
    private Integer positionId;
    private String positionName;
    private Integer order;
    private String dateOfAppointment;
    private String periodUpto;
    private Integer totalExperience;
    private Integer managerialExperience;

    public OricPositionDTO() {
    }


    public OricPositionDTO(OricPosition oricPosition) {
        copyFromObject(this, oricPosition);
    }


    public static void copyFromObject(OricPositionDTO oricPositionDTO, OricPosition classObject) {
        oricPositionDTO.id = classObject.getId();
        if (classObject.getOricSession() != null) {
            oricPositionDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if (classObject.getUser() != null) {
            oricPositionDTO.userId = classObject.getUser().getId();
            oricPositionDTO.userName = UserUtility.getNameFromUser(classObject.getUser());
        }
        if (classObject.getPosition() != null) {
            oricPositionDTO.positionId = classObject.getPosition().getId();
            oricPositionDTO.positionName = classObject.getPosition().getName();
        }
        oricPositionDTO.order = classObject.getOrder();
        oricPositionDTO.dateOfAppointment = UtilityFunctions.localDateToString(classObject.getDateOfAppointment());
        oricPositionDTO.periodUpto = UtilityFunctions.localDateToString(classObject.getPeriodUpto());
        oricPositionDTO.totalExperience = classObject.getTotalExperience();
        oricPositionDTO.managerialExperience = classObject.getManagerialExperience();
    }


    public static void copyFromDto(OricPositionDTO oricPositionDTO, OricPosition classObject) {
        classObject.setId(oricPositionDTO.id);
        classObject.setOrder(oricPositionDTO.order);
        classObject.setDateOfAppointment(UtilityFunctions.stringToLocalDate(oricPositionDTO.dateOfAppointment));
        classObject.setPeriodUpto(UtilityFunctions.stringToLocalDate(oricPositionDTO.periodUpto));
        classObject.setTotalExperience(oricPositionDTO.totalExperience);
        classObject.setManagerialExperience(oricPositionDTO.managerialExperience);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getPeriodUpto() {
        return periodUpto;
    }

    public void setPeriodUpto(String periodUpto) {
        this.periodUpto = periodUpto;
    }

    public Integer getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Integer totalExperience) {
        this.totalExperience = totalExperience;
    }

    public Integer getManagerialExperience() {
        return managerialExperience;
    }

    public void setManagerialExperience(Integer managerialExperience) {
        this.managerialExperience = managerialExperience;
    }
}
