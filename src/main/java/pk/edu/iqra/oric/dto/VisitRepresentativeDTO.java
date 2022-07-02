package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.VisitRepresentative;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class VisitRepresentativeDTO extends DtoInterface {


    private Integer id;
    private String nameVisitor;
    private String dateVisit;
    private String agenda;
    private String remarks;
    private Integer oricSessionId;
    private Integer facultyId;
    private String facultyName;
    private String campusName;

    public VisitRepresentativeDTO() {
    }


    public VisitRepresentativeDTO(VisitRepresentative visitRepresentative) {
        copyFromObject(this, visitRepresentative);
    }


    public static void copyFromObject(VisitRepresentativeDTO visitRepresentativeDTO, VisitRepresentative classObject) {

        visitRepresentativeDTO.id = classObject.getId();
        visitRepresentativeDTO.nameVisitor = classObject.getNameVisitor();
        visitRepresentativeDTO.dateVisit = UtilityFunctions.localDateToString(classObject.getDateVisit());
        visitRepresentativeDTO.agenda = classObject.getAgenda();
        visitRepresentativeDTO.remarks = classObject.getRemarks();
        if (classObject.getOricSession() != null) {
            visitRepresentativeDTO.oricSessionId = classObject.getOricSession().getId();
        }
        if (classObject.getFaculty() != null) {
            visitRepresentativeDTO.facultyId = classObject.getFaculty().getId();
            visitRepresentativeDTO.facultyName = classObject.getFaculty().getName();
            visitRepresentativeDTO.campusName = classObject.getFaculty().getCampus().getName();
        }

    }


    public static void copyFromDto(VisitRepresentativeDTO visitRepresentativeDTO, VisitRepresentative classObject) {
        classObject.setId(visitRepresentativeDTO.id);
        classObject.setNameVisitor(visitRepresentativeDTO.nameVisitor);
        classObject.setDateVisit(UtilityFunctions.stringToInstantDate(visitRepresentativeDTO.dateVisit));
        classObject.setAgenda(visitRepresentativeDTO.agenda);
        classObject.setRemarks(visitRepresentativeDTO.remarks);

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameVisitor() {
        return nameVisitor;
    }

    public void setNameVisitor(String nameVisitor) {
        this.nameVisitor = nameVisitor;
    }

    public String getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(String dateVisit) {
        this.dateVisit = dateVisit;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
