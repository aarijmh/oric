package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.Announcement;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class AnnouncementDTO extends DtoInterface {


    private Integer id;
    private Integer announcementTypeId;
    private String announcementTypeName;
    private String title;
    private String shortDescription;
    private String url;
    private String longDescription;
    private Double amount;

    private Integer oricSessionId;

    private Integer facultyId;
    private String facultyName;
    private String campusName;

    private String expiryDate;

    private String expiryTime;

    public AnnouncementDTO() {
    }


    public AnnouncementDTO(Announcement announcement) {
        copyFromObject(this, announcement);
    }


    public static void copyFromObject(AnnouncementDTO announcementDTO, Announcement classObject) {

        announcementDTO.id = classObject.getId();
        if (classObject.getAnnouncementType() != null) {
            announcementDTO.announcementTypeId = classObject.getAnnouncementType().getId();
            announcementDTO.announcementTypeName = classObject.getAnnouncementType().getName();
        }
        if(classObject.getFaculty() != null ) {
            announcementDTO.facultyId = classObject.getFaculty().getId();
            announcementDTO.facultyName = classObject.getFaculty().getName();
            if(classObject.getFaculty().getCampus() != null)
                announcementDTO.campusName = classObject.getFaculty().getCampus().getName();
        }
        announcementDTO.title = classObject.getTitle();
        announcementDTO.shortDescription = classObject.getShortDescription();
        announcementDTO.url = classObject.getUrl();
        announcementDTO.longDescription = classObject.getLongDescription();
        announcementDTO.amount = classObject.getAmount();
        announcementDTO.expiryDate = UtilityFunctions.localDateToString(classObject.getExpiryDate());
        announcementDTO.expiryTime = classObject.getExpiryTime();
        if (classObject.getOricSession() != null) {
            announcementDTO.oricSessionId = classObject.getOricSession().getId();
        }
    }


    public static void copyFromDto(AnnouncementDTO announcementDTO, Announcement classObject) {
        classObject.setId(announcementDTO.id);
        classObject.setTitle(announcementDTO.title);
        classObject.setShortDescription(announcementDTO.shortDescription);
        classObject.setUrl(announcementDTO.url);
        classObject.setLongDescription(announcementDTO.longDescription);
        classObject.setAmount(announcementDTO.amount);
        classObject.setExpiryDate(UtilityFunctions.stringToLocalDate(announcementDTO.expiryDate));
        classObject.setExpiryTime(announcementDTO.expiryTime);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnnouncementTypeId() {
        return announcementTypeId;
    }

    public void setAnnouncementTypeId(Integer announcementTypeId) {
        this.announcementTypeId = announcementTypeId;
    }

    public String getAnnouncementTypeName() {
        return announcementTypeName;
    }

    public void setAnnouncementTypeName(String announcementTypeName) {
        this.announcementTypeName = announcementTypeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
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

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }
}
