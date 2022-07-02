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
        announcementDTO.title = classObject.getTitle();
        announcementDTO.shortDescription = classObject.getShortDescription();
        announcementDTO.url = classObject.getUrl();
        announcementDTO.longDescription = classObject.getLongDescription();
        announcementDTO.amount = classObject.getAmount();


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

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }
}
