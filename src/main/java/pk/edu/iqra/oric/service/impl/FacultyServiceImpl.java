package pk.edu.iqra.oric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.Campus;
import pk.edu.iqra.oric.domain.Faculty;
import pk.edu.iqra.oric.dto.FacultyDTO;
import pk.edu.iqra.oric.repository.FacultyRepository;
import pk.edu.iqra.oric.service.CampusService;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;
    private CampusService campusService;

    private UserService userService;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, CampusService campusService,
                              UserService userService) {
        this.facultyRepository = facultyRepository;
        this.campusService = campusService;
        this.userService = userService;
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

    @Override
    public List<Faculty> getFacultiesOfCampus(Integer campusId) {
        return facultyRepository.findFacultiesByCampus(campusId);
    }

    @Override
    public List<FacultyDTO> getFacultiesDTOOfCampus(Integer campusI) {
        return getFacultiesOfCampus(campusI).stream().map(x->new FacultyDTO(x)).collect(Collectors.toList());
    }

    @Override
    public FacultyDTO saveFaculty(FacultyDTO facultyDTO, Integer campusId){

        Faculty faculty = null;

        if(facultyDTO.getId() == null || facultyDTO.getId().equals(0)){
            faculty = new Faculty();
            faculty.setCampus(campusService.getById(campusId));

            facultyDTO.setCampusName(faculty.getCampus().getName());
        }

        if(facultyDTO.getDeanId() != null){
            faculty.setDean(userService.getUserByUserId(facultyDTO.getDeanId()));
            facultyDTO.setDeanName(UserUtility.getNameFromUser(faculty.getDean()));
        }

        FacultyDTO.copyFromDto(facultyDTO,faculty);
        facultyDTO.setId(facultyRepository.save(faculty).getId());

        return facultyDTO;
    }
}
