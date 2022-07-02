package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.Award;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class AwardDTO extends DtoInterface {


    private Integer id;
    private Integer awardWinnerId;
    private String awardWinnerName;
    private String title;
    private String authority;
    private String awardCertificate;
    private String brief;
    private Double amount;
    private String remarks;
    private Integer oricSessionId;
    private Integer facultyId;
    private String facultyName;
    private String campusName;

    public AwardDTO() {
    }


    public AwardDTO(Award award) {
        copyFromObject(this, award);
    }


    public static void copyFromObject(AwardDTO awardDTO, Award classObject) {

        awardDTO.id = classObject.getId();
        if (classObject.getAwardWinner() != null) {
            awardDTO.awardWinnerId = classObject.getAwardWinner().getId();
            awardDTO.awardWinnerName = UserUtility.getNameFromUser(classObject.getAwardWinner());
        }
        awardDTO.title = classObject.getTitle();
        awardDTO.authority = classObject.getAuthority();
        awardDTO.awardCertificate = classObject.getAwardCertificate();
        awardDTO.brief = classObject.getBrief();
        awardDTO.amount = classObject.getAmount();
        awardDTO.remarks = classObject.getRemarks();
        if (classObject.getOricSession() != null) {
            awardDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if (classObject.getFaculty() != null) {
            awardDTO.facultyId = classObject.getFaculty().getId();
            awardDTO.facultyName = classObject.getFaculty().getName();
            awardDTO.campusName = classObject.getFaculty().getCampus().getName();
        }

    }


    public static void copyFromDto(AwardDTO awardDTO, Award classObject) {
        classObject.setId(awardDTO.id);
        classObject.setTitle(awardDTO.title);
        classObject.setAuthority(awardDTO.authority);
        classObject.setAwardCertificate(awardDTO.awardCertificate);
        classObject.setBrief(awardDTO.brief);
        classObject.setAmount(awardDTO.amount);
        classObject.setRemarks(awardDTO.remarks);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAwardWinnerId() {
        return awardWinnerId;
    }

    public void setAwardWinnerId(Integer awardWinnerId) {
        this.awardWinnerId = awardWinnerId;
    }

    public String getAwardWinnerName() {
        return awardWinnerName;
    }

    public void setAwardWinnerName(String awardWinnerName) {
        this.awardWinnerName = awardWinnerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAwardCertificate() {
        return awardCertificate;
    }

    public void setAwardCertificate(String awardCertificate) {
        this.awardCertificate = awardCertificate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
