package pk.edu.iqra.oric.service;

import org.springframework.data.jpa.repository.Query;
import pk.edu.iqra.oric.domain.Campus;
import pk.edu.iqra.oric.domain.Faculty;
import pk.edu.iqra.oric.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    public Faculty getFacultyById(Integer facultyId);

    Campus getCampusOfFaculty(Integer facultyId);
    
    List<Faculty> getFacultiesOfAdministrator(Integer adminId);
    
    List<FacultyDTO> getFacultiesDTOOfAdministrator(Integer adminId);

    FacultyDTO saveFaculty(FacultyDTO facultyDTO, Integer campusId);

    List<Faculty> getFacultiesOfCampus(Integer campusId);

    List<FacultyDTO> getFacultiesDTOOfCampus(Integer campusI);
}
