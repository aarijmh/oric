package pk.edu.iqra.oric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.Oric;
import pk.edu.iqra.oric.domain.University;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.UniversityDTO;
import pk.edu.iqra.oric.publicdto.PublicOricDTO;
import pk.edu.iqra.oric.repository.UniversityRepository;
import pk.edu.iqra.oric.service.UniversityService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {
    private UniversityRepository universityRepository;
    private UserService userService;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository, UserService userService){
        this.universityRepository = universityRepository;
        this.userService = userService;
    }

    @Override
    public UniversityDTO getUniversityDTOOfAdministrator(Integer adminId) {
        return new UniversityDTO(getUniversityOfAdministrator(adminId));
    }

    @Override
    public University getUniversityOfAdministrator(Integer adminId) {
        return universityRepository.findUniversityOfAdministrator(adminId);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
        University university = null;

        if(universityDTO.getId() == null || universityDTO.getId().equals(0)){
            university = new University();
        }
        else{
            university = universityRepository.findById(universityDTO.getId()).get();
        }

        university.setName(universityDTO.getName());
        university.setAddress(universityDTO.getAddress());
        university.setPhone(universityDTO.getPhone());
        university.setProvince(universityDTO.getProvince());
        university.setSector(universityDTO.getSector());
        university.setVacantPosts(universityDTO.getVacantPosts());

        List<Integer> userList = new ArrayList<>();

        if(universityDTO.getVc() != null)
            userList.add(universityDTO.getVc());
        if(universityDTO.getVcPa() != null)
            userList.add(universityDTO.getVcPa());
        if(universityDTO.getRegistrar() != null)
            userList.add(universityDTO.getRegistrar());
        if(universityDTO.getRegistrarPa() != null)
            userList.add(universityDTO.getRegistrarPa());

        Map<Integer,User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId,x->x));

        if(universityDTO.getVc() != null)
            university.setVc(userMap.get(universityDTO.getVc()));
        else
            university.setVc(null);

        if(universityDTO.getVcPa() != null)
            university.setVcPa(userMap.get(universityDTO.getVcPa()));
        else
            university.setVcPa(null);

        if(universityDTO.getRegistrar() != null)
            university.setRegistrar(userMap.get(universityDTO.getRegistrar()));
        else
            university.setRegistrar(null);

        if(universityDTO.getRegistrarPa() != null)
            university.setRegistrarPa(userMap.get(universityDTO.getRegistrarPa()));
        else
            university.setRegistrarPa(null);

        universityRepository.save(university);

        universityDTO.setId(university.getId());

        return universityDTO;
    }

    @Override
    public University getUniversityByEncryptedId(String encryptedId) {
        return universityRepository.findUniversityByEncryptedId(encryptedId);
    }

    @Override
    public PublicOricDTO getPublicInfoAboutORIC(String encryptedId) {
        Oric oric = universityRepository.findOricOfUniversity(encryptedId);
        PublicOricDTO publicOricDTO = new PublicOricDTO();
        publicOricDTO.setAbout(oric.getAbout());
        publicOricDTO.setMission(oric.getMission());
        publicOricDTO.setVision(oric.getVision());
        return publicOricDTO;
    }
}
