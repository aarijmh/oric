package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.University;

public class UniversityDTO {

    private Integer id;
    private String name;
    private String phone;
    private String address;
    private String sector;
    private String province;
    private Integer vacantPosts;
    private Integer vc;
    private Integer vcPa;
    private Integer registrar;
    private Integer registrarPa;

    public UniversityDTO(){

    }

    public UniversityDTO(University university){
        this.id = university.getId();
        this.name = university.getName();
        this.address = university.getAddress();
        this.sector = university.getSector();
        this.province = university.getProvince();
        this.vacantPosts = university.getVacantPosts();
        if(university.getVc() != null)
            this.vc = university.getVc().getId();
        if(university.getVcPa() != null)
            this.vcPa = university.getVcPa().getId();
        if(university.getRegistrar() != null)
            this.registrar = university.getRegistrar().getId();
        if(university.getRegistrarPa() != null)
            this.registrarPa = university.getRegistrarPa().getId();
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getVacantPosts() {
        return vacantPosts;
    }

    public void setVacantPosts(Integer vacantPosts) {
        this.vacantPosts = vacantPosts;
    }

    public Integer getVc() {
        return vc;
    }

    public void setVc(Integer vc) {
        this.vc = vc;
    }

    public Integer getVcPa() {
        return vcPa;
    }

    public void setVcPa(Integer vcPa) {
        this.vcPa = vcPa;
    }

    public Integer getRegistrar() {
        return registrar;
    }

    public void setRegistrar(Integer registrar) {
        this.registrar = registrar;
    }

    public Integer getRegistrarPa() {
        return registrarPa;
    }

    public void setRegistrarPa(Integer registrarPa) {
        this.registrarPa = registrarPa;
    }
}
