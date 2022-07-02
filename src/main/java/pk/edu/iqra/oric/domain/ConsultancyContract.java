package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "consultancy_contract")
public class ConsultancyContract implements Serializable {
    private static final long serialVersionUID = 5017764678757083314L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pi")
    private User pi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_pi")
    private User coPi;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "date_execution")
    private Instant dateExecution;

    @Column(name = "national", length = 50)
    private String national;

    @Column(name = "host_instituition", length = 200)
    private String hostInstituition;

    @Column(name = "sponsoring_instituition", length = 200)
    private String sponsoringInstituition;

    @Column(name = "counterpart_industry", length = 200)
    private String counterpartIndustry;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "salient_feature", length = 500)
    private String salientFeature;

    @Column(name = "oric_percentage")
    private Double oricPercentage;

    @Column(name = "remarks", length = 500)
    private String remarks;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "faculty", nullable = false)
    private Faculty faculty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getPi() {
        return pi;
    }

    public void setPi(User pi) {
        this.pi = pi;
    }

    public User getCoPi() {
        return coPi;
    }

    public void setCoPi(User coPi) {
        this.coPi = coPi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(Instant dateExecution) {
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

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}