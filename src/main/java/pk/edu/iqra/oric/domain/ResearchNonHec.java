package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "research_non_hec")
public class ResearchNonHec implements Serializable {
    private static final long serialVersionUID = -3213632380627299706L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_grant", length = 45)
    private String nameGrant;

    @Column(name = "date_submission")
    private LocalDate dateSubmission;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "principal_investigator", nullable = false)
    private User principalInvestigator;

    @Column(name = "thematic_area", length = 70)
    private String thematicArea;

    @Column(name = "title", length = 400)
    private String title;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "funding_requested")
    private Double fundingRequested;

    @Column(name = "collaborating_partners", length = 100)
    private String collaboratingPartners;

    @Column(name = "cofunders", length = 100)
    private String cofunders;

    @Column(name = "status", length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "faculty", nullable = false)
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_investigator_1")
    private User coInvestigator1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_investigator_2")
    private User coInvestigator2;

    @Column(name = "remarks", length = 500)
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    private User modifiedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oric_session")
    private OricSession oricSession;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @Column(name = "modified_on")
    private LocalDate modifiedOn;

    @Column(name = "funding_granted")
    private Double fundingGranted;

    @Column(name = "co_investigator_other_1", length = 100)
    private String coInvestigatorOther1;

    @Column(name = "co_investigator_other_2", length = 100)
    private String coInvestigatorOther2;

    @Column(name = "national", length = 45)
    private String national;

    @Column(name = "industrial_partner", length = 500)
    private String industrialPartner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGrant() {
        return nameGrant;
    }

    public void setNameGrant(String nameGrant) {
        this.nameGrant = nameGrant;
    }

    public LocalDate getDateSubmission() {
        return dateSubmission;
    }

    public void setDateSubmission(LocalDate dateSubmission) {
        this.dateSubmission = dateSubmission;
    }

    public User getPrincipalInvestigator() {
        return principalInvestigator;
    }

    public void setPrincipalInvestigator(User principalInvestigator) {
        this.principalInvestigator = principalInvestigator;
    }

    public String getThematicArea() {
        return thematicArea;
    }

    public void setThematicArea(String thematicArea) {
        this.thematicArea = thematicArea;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Double getFundingRequested() {
        return fundingRequested;
    }

    public void setFundingRequested(Double fundingRequested) {
        this.fundingRequested = fundingRequested;
    }

    public String getCollaboratingPartners() {
        return collaboratingPartners;
    }

    public void setCollaboratingPartners(String collaboratingPartners) {
        this.collaboratingPartners = collaboratingPartners;
    }

    public String getCofunders() {
        return cofunders;
    }

    public void setCofunders(String cofunders) {
        this.cofunders = cofunders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public User getCoInvestigator1() {
        return coInvestigator1;
    }

    public void setCoInvestigator1(User coInvestigator1) {
        this.coInvestigator1 = coInvestigator1;
    }

    public User getCoInvestigator2() {
        return coInvestigator2;
    }

    public void setCoInvestigator2(User coInvestigator2) {
        this.coInvestigator2 = coInvestigator2;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public OricSession getOricSession() {
        return oricSession;
    }

    public void setOricSession(OricSession oricSession) {
        this.oricSession = oricSession;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDate modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Double getFundingGranted() {
        return fundingGranted;
    }

    public void setFundingGranted(Double fundingGranted) {
        this.fundingGranted = fundingGranted;
    }

    public String getCoInvestigatorOther1() {
        return coInvestigatorOther1;
    }

    public void setCoInvestigatorOther1(String coInvestigatorOther1) {
        this.coInvestigatorOther1 = coInvestigatorOther1;
    }

    public String getCoInvestigatorOther2() {
        return coInvestigatorOther2;
    }

    public void setCoInvestigatorOther2(String coInvestigatorOther2) {
        this.coInvestigatorOther2 = coInvestigatorOther2;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIndustrialPartner() {
        return industrialPartner;
    }

    public void setIndustrialPartner(String industrialPartner) {
        this.industrialPartner = industrialPartner;
    }

}