package pk.edu.iqra.oric.service;

import pk.edu.iqra.oric.domain.University;
import pk.edu.iqra.oric.dto.UniversityDTO;
import pk.edu.iqra.oric.publicdto.PublicOricDTO;

public interface UniversityService {

    UniversityDTO getUniversityDTOOfAdministrator(Integer adminId);

    University getUniversityOfAdministrator(Integer adminId);

    UniversityDTO saveUniversity(UniversityDTO universityDTO);

    University getUniversityByEncryptedId(String encryptedId);

    PublicOricDTO getPublicInfoAboutORIC(String encryptedId);
}
