package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "policy_case")
public class PolicyCase implements Serializable {
    private static final long serialVersionUID = -4331690531851290102L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "govt_body", length = 100)
    private String govtBody;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pi", nullable = false)
    private User pi;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oric_session", nullable = false)
    private OricSession oricSession;

    @Column(name = "area", length = 100)
    private String area;

    @Column(name = "brief", length = 1000)
    private String brief;

    @Column(name = "coalition_partner", length = 200)
    private String coalitionPartner;

    @Column(name = "issue_verification", length = 200)
    private String issueVerification;

    @Column(name = "advocacy_tools", length = 500)
    private String advocacyTools;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_pi_1")
    private User coPi1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_pi_2")
    private User coPi2;

    @Column(name = "remarks", length = 500)
    private String remarks;

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

    public String getGovtBody() {
        return govtBody;
    }

    public void setGovtBody(String govtBody) {
        this.govtBody = govtBody;
    }

    public User getPi() {
        return pi;
    }

    public void setPi(User pi) {
        this.pi = pi;
    }

    public OricSession getOricSession() {
        return oricSession;
    }

    public void setOricSession(OricSession oricSession) {
        this.oricSession = oricSession;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCoalitionPartner() {
        return coalitionPartner;
    }

    public void setCoalitionPartner(String coalitionPartner) {
        this.coalitionPartner = coalitionPartner;
    }

    public String getIssueVerification() {
        return issueVerification;
    }

    public void setIssueVerification(String issueVerification) {
        this.issueVerification = issueVerification;
    }

    public String getAdvocacyTools() {
        return advocacyTools;
    }

    public void setAdvocacyTools(String advocacyTools) {
        this.advocacyTools = advocacyTools;
    }

    public User getCoPi1() {
        return coPi1;
    }

    public void setCoPi1(User coPi1) {
        this.coPi1 = coPi1;
    }

    public User getCoPi2() {
        return coPi2;
    }

    public void setCoPi2(User coPi2) {
        this.coPi2 = coPi2;
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