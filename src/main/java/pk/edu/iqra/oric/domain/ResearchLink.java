package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "research_link")
public class ResearchLink implements Serializable {
    private static final long serialVersionUID = 5765243217173851567L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pi")
    private User pi;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "national", length = 50)
    private String national;

    @Column(name = "host_instituition", length = 200)
    private String hostInstituition;

    @Column(name = "collaborating_instituition", length = 200)
    private String collaboratingInstituition;

    @Column(name = "area", length = 100)
    private String area;

    @Column(name = "scope", length = 200)
    private String scope;

    @Column(name = "link_date")
    private Instant linkDate;

    @Column(name = "salient_feature", length = 200)
    private String salientFeature;

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

    public String getCollaboratingInstituition() {
        return collaboratingInstituition;
    }

    public void setCollaboratingInstituition(String collaboratingInstituition) {
        this.collaboratingInstituition = collaboratingInstituition;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Instant getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(Instant linkDate) {
        this.linkDate = linkDate;
    }

    public String getSalientFeature() {
        return salientFeature;
    }

    public void setSalientFeature(String salientFeature) {
        this.salientFeature = salientFeature;
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