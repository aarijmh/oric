package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.Faculty;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class FacultyDTO extends DtoInterface {


    private Integer id;
    private Integer campusId;
    private String campusName;
    private String name;
    private Integer deanId;
    private String deanName;
    private String description;
    private String shortName;

    public FacultyDTO() {
    }


    public FacultyDTO(Faculty faculty) {
        copyFromObject(this, faculty);
    }


    public static void copyFromObject(FacultyDTO facultyDTO, Faculty classObject) {
        facultyDTO.id = classObject.getId();
        if (classObject.getCampus() != null) {
            facultyDTO.campusId = classObject.getCampus().getId();
            facultyDTO.campusName = classObject.getCampus().getName();
        }
        facultyDTO.name = classObject.getName();
        if (classObject.getDean() != null) {
            facultyDTO.deanId = classObject.getDean().getId();
            facultyDTO.deanName = UserUtility.getNameFromUser(classObject.getDean());
        }
        facultyDTO.description = classObject.getDescription();
        facultyDTO.shortName = classObject.getShortName();
    }


    public static void copyFromDto(FacultyDTO facultyDTO, Faculty classObject) {
        classObject.setId(facultyDTO.id);
        classObject.setName(facultyDTO.name);
        classObject.setDescription(facultyDTO.description);
        classObject.setShortName(facultyDTO.shortName);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeanId() {
        return deanId;
    }

    public void setDeanId(Integer deanId) {
        this.deanId = deanId;
    }

    public String getDeanName() {
        return deanName;
    }

    public void setDeanName(String deanName) {
        this.deanName = deanName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
