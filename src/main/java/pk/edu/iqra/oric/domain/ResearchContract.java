package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "research_contract")
public class ResearchContract implements Serializable {
    private static final long serialVersionUID = -4308467896860563449L;
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

    @Column(name = "type", length = 100)
    private String type;

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

    @Column(name = "salient_feature", length = 200)
    private String salientFeature;

    @Column(name = "contract_date")
    private Instant contractDate;

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

    public String getSalientFeature() {
        return salientFeature;
    }

    public void setSalientFeature(String salientFeature) {
        this.salientFeature = salientFeature;
    }

    public Instant getContractDate() {
        return contractDate;
    }

    public void setContractDate(Instant contractDate) {
        this.contractDate = contractDate;
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