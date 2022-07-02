package pk.edu.iqra.oric.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "oric_position")
public class OricPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jd", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oric_session", nullable = false)
    private OricSession oricSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "position", nullable = false)
    private OricPositionsTitle position;

    @Column(name = "`order`")
    private Integer order;

    @Column(name = "date_of_appointment")
    private LocalDate dateOfAppointment;

    @Column(name = "period_upto")
    private LocalDate periodUpto;

    @Column(name = "total_experience")
    private Integer totalExperience;

    @Column(name = "managerial_experience")
    private Integer managerialExperience;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OricSession getOricSession() {
        return oricSession;
    }

    public void setOricSession(OricSession oricSession) {
        this.oricSession = oricSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OricPositionsTitle getPosition() {
        return position;
    }

    public void setPosition(OricPositionsTitle position) {
        this.position = position;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public LocalDate getPeriodUpto() {
        return periodUpto;
    }

    public void setPeriodUpto(LocalDate periodUpto) {
        this.periodUpto = periodUpto;
    }

    public Integer getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Integer totalExperience) {
        this.totalExperience = totalExperience;
    }

    public Integer getManagerialExperience() {
        return managerialExperience;
    }

    public void setManagerialExperience(Integer managerialExperience) {
        this.managerialExperience = managerialExperience;
    }

}