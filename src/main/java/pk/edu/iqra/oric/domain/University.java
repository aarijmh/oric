package pk.edu.iqra.oric.domain;

import javax.persistence.*;

@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "phone", length = 45)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vc")
    private User vc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registrar")
    private User registrar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vc_pa")
    private User vcPa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registrar_pa")
    private User registrarPa;

    @Column(name = "vacant_posts")
    private Integer vacantPosts;

    @Column(name = "sector", length = 45)
    private String sector;

    @Column(name = "province", length = 45)
    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getVc() {
        return vc;
    }

    public void setVc(User vc) {
        this.vc = vc;
    }

    public User getRegistrar() {
        return registrar;
    }

    public void setRegistrar(User registrar) {
        this.registrar = registrar;
    }

    public User getVcPa() {
        return vcPa;
    }

    public void setVcPa(User vcPa) {
        this.vcPa = vcPa;
    }

    public User getRegistrarPa() {
        return registrarPa;
    }

    public void setRegistrarPa(User registrarPa) {
        this.registrarPa = registrarPa;
    }

    public Integer getVacantPosts() {
        return vacantPosts;
    }

    public void setVacantPosts(Integer vacantPosts) {
        this.vacantPosts = vacantPosts;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}