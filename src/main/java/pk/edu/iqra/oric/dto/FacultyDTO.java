package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.Faculty;

public class FacultyDTO {
    private Integer id;
    private String name;
    private String facultyShortName;
    private Integer campusId;
    private String campusName;

    public FacultyDTO(){

    }

    public FacultyDTO(Faculty faculty){
        this.id = faculty.getId();
        this.name = faculty.getName();
        this.facultyShortName = faculty.getShortName();
        if(faculty.getCampus() != null){
            this.campusId = faculty.getCampus().getId();
            this.campusName = faculty.getCampus().getName();
        }
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

    public String getFacultyShortName() {
        return facultyShortName;
    }

    public void setFacultyShortName(String facultyShortName) {
        this.facultyShortName = facultyShortName;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
