package pk.edu.iqra.oric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.Campus;
import pk.edu.iqra.oric.domain.Faculty;
import pk.edu.iqra.oric.dto.FacultyDTO;
import pk.edu.iqra.oric.repository.FacultyRepository;
import pk.edu.iqra.oric.service.FacultyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty getFacultyById(Integer facultyId) {
        return facultyRepository.findById(facultyId).get();
    }

    @Override
    public Campus getCampusOfFaculty(Integer facultyId) {
        return facultyRepository.findCampusOfFaculty(facultyId);
    }

    @Override
    public List<Faculty> getFacultiesOfAdministrator(Integer adminId) {
        return facultyRepository.findFacultiesOfUniversityAdmin(adminId);
    }

    @Override
    public List<FacultyDTO> getFacultiesDTOOfAdministrator(Integer adminId) {
        return getFacultiesOfAdministrator(adminId).stream().map(x->new FacultyDTO(x)).collect(Collectors.toList());
    }
}
