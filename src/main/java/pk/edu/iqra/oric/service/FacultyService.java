package pk.edu.iqra.oric.service;

import org.springframework.data.jpa.repository.Query;
import pk.edu.iqra.oric.domain.Campus;
import pk.edu.iqra.oric.domain.Faculty;
import pk.edu.iqra.oric.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {
    @Query("from Faculty f left join fetch f.campus campus where f.id = ?1")
    Faculty getFacultyById(Integer facultyId);
    Campus getCampusOfFaculty(Integer facultyId);
    
    List<Faculty> getFacultiesOfAdministrator(Integer adminId);
    
    List<FacultyDTO> getFacultiesDTOOfAdministrator(Integer adminId);

    // TODO: 6/13/2022 getFaculties for Campus Id
}
