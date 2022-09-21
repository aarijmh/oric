package pk.edu.iqra.oric.publicdto;

import pk.edu.iqra.oric.domain.Announcement;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import java.time.LocalDate;

public class PublicAnnouncementDTO {
    private Integer id;
    private String shortDescription;
    private String title;
    private String url;
    private String expiryDate;
    private String expiryTime;

    private String longDescription;

    public PublicAnnouncementDTO(){

    }

    public PublicAnnouncementDTO(Announcement announcement){
        this.id = announcement.getId();
        this.shortDescription = announcement.getShortDescription();
        this.title = announcement.getTitle();
        this.longDescription = announcement.getLongDescription();
        this.url = announcement.getUrl();
        this.expiryDate = UtilityFunctions.localDateToString(announcement.getExpiryDate());
        this.expiryTime = announcement.getExpiryTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
