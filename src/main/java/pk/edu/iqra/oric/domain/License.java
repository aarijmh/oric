package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "license")
public class License implements Serializable {
    private static final long serialVersionUID = 5117310025180807061L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventor", nullable = false)
    private User inventor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_inventor")
    private User coInventor;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "development_status", length = 100)
    private String developmentStatus;

    @Column(name = "key_scientific_aspects", length = 200)
    private String keyScientificAspects;

    @Column(name = "commercial_partner", length = 200)
    private String commercialPartner;

    @Column(name = "national", length = 45)
    private String national;

    @Column(name = "field_of_use", length = 300)
    private String fieldOfUse;

    @Column(name = "date_of_filling")
    private Instant dateOfFilling;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "licensee", length = 200)
    private String licensee;

    @Column(name = "financial_support", length = 200)
    private String financialSupport;

    @Column(name = "exclusive", length = 200)
    private String exclusive;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "remarks", length = 300)
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oric_session", nullable = false)
    private OricSession oricSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "faculty", nullable = false)
    private Faculty faculty;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getInventor() {
        return inventor;
    }

    public void setInventor(User inventor) {
        this.inventor = inventor;
    }

    public User getCoInventor() {
        return coInventor;
    }

    public void setCoInventor(User coInventor) {
        this.coInventor = coInventor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDevelopmentStatus() {
        return developmentStatus;
    }

    public void setDevelopmentStatus(String developmentStatus) {
        this.developmentStatus = developmentStatus;
    }

    public String getKeyScientificAspects() {
        return keyScientificAspects;
    }

    public void setKeyScientificAspects(String keyScientificAspects) {
        this.keyScientificAspects = keyScientificAspects;
    }

    public String getCommercialPartner() {
        return commercialPartner;
    }

    public void setCommercialPartner(String commercialPartner) {
        this.commercialPartner = commercialPartner;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getFieldOfUse() {
        return fieldOfUse;
    }

    public void setFieldOfUse(String fieldOfUse) {
        this.fieldOfUse = fieldOfUse;
    }

    public Instant getDateOfFilling() {
        return dateOfFilling;
    }

    public void setDateOfFilling(Instant dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLicensee() {
        return licensee;
    }

    public void setLicensee(String licensee) {
        this.licensee = licensee;
    }

    public String getFinancialSupport() {
        return financialSupport;
    }

    public void setFinancialSupport(String financialSupport) {
        this.financialSupport = financialSupport;
    }

    public String getExclusive() {
        return exclusive;
    }

    public void setExclusive(String exclusive) {
        this.exclusive = exclusive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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

}