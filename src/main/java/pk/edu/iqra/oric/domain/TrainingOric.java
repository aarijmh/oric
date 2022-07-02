package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "trainings_oric")
public class TrainingOric implements Serializable {
    private static final long serialVersionUID = -6000638576155164347L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 300)
    private String title;

    @Column(name = "date_of_event")
    private Instant dateOfEvent;

    @Column(name = "no_of_participants")
    private Integer noOfParticipants;

    @Column(name = "focus_area", length = 500)
    private String focusArea;

    @Column(name = "organizer", length = 500)
    private String organizer;

    @Column(name = "audience_type", length = 50)
    private String audienceType;

    @Column(name = "remarks", length = 300)
    private String remarks;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "national", length = 50)
    private String national;

    @Column(name = "arranged_by_oric")
    private Boolean arrangedByOric;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oric_session", nullable = false)
    private OricSession oricSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    private User modifiedBy;

    @Column(name = "created_on")
    private Instant createdOn;

    @Column(name = "modified_on")
    private Instant modifiedOn;

    @Column(name = "for_oric_personnel")
    private Boolean forOricPersonnel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Instant dateOfEvent) {
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

    public Boolean getArrangedByOric() {
        return arrangedByOric;
    }

    public void setArrangedByOric(Boolean arrangedByOric) {
        this.arrangedByOric = arrangedByOric;
    }

    public OricSession getOricSession() {
        return oricSession;
    }

    public void setOricSession(OricSession oricSession) {
        this.oricSession = oricSession;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Instant modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Boolean getForOricPersonnel() {
        return forOricPersonnel;
    }

    public void setForOricPersonnel(Boolean forOricPersonnel) {
        this.forOricPersonnel = forOricPersonnel;
    }

}