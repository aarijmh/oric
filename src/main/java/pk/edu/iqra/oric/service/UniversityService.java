package pk.edu.iqra.oric.service;

import pk.edu.iqra.oric.domain.University;
import pk.edu.iqra.oric.dto.UniversityDTO;

public interface UniversityService {

    UniversityDTO getUniversityDTOOfAdministrator(Integer adminId);

    University getUniversityOfAdministrator(Integer adminId);

    UniversityDTO saveUniversity(UniversityDTO universityDTO);
}
