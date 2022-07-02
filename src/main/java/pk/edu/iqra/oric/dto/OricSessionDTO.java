package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.utility.UtilityFunctions;

public class OricSessionDTO {
    private Integer id;
    private String startDate;
    private String endDate;
    private String description;
    private Boolean isClosed;

    public OricSessionDTO(){

    }

    public OricSessionDTO(OricSession oricSession){
        this.id = oricSession.getId();
        this.startDate = UtilityFunctions.localDateToString(oricSession.getStartDate());
        this.endDate = UtilityFunctions.localDateToString(oricSession.getEndDate());
        this.description = oricSession.getDescription();
        this.isClosed = oricSession.getIsClosed();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean closed) {
        isClosed = closed;
    }
}
