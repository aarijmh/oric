package pk.edu.iqra.oric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.AnnouncementType;
import pk.edu.iqra.oric.domain.OricPositionsTitle;
import pk.edu.iqra.oric.domain.ProposalType;
import pk.edu.iqra.oric.domain.Role;
import pk.edu.iqra.oric.dto.FacultyDTO;
import pk.edu.iqra.oric.repository.AnnouncementTypeRepository;
import pk.edu.iqra.oric.repository.OricPositionTitleRepository;
import pk.edu.iqra.oric.repository.ProposalTypeRepository;
import pk.edu.iqra.oric.service.DataService;
import pk.edu.iqra.oric.service.FacultyService;
import pk.edu.iqra.oric.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private FacultyService facultyService;

    private UserService userService;

    private ProposalTypeRepository proposalTypeRepository;

    private OricPositionTitleRepository oricPositionTitleRepository;

    private AnnouncementTypeRepository announcementTypeRepository;

    @Autowired
    public DataServiceImpl(FacultyService facultyService,UserService userService, ProposalTypeRepository proposalTypeRepository,
                           OricPositionTitleRepository oricPositionTitleRepository,
                           AnnouncementTypeRepository announcementTypeRepository) {
        this.facultyService = facultyService;
        this.userService = userService;
        this.proposalTypeRepository = proposalTypeRepository;
        this.oricPositionTitleRepository = oricPositionTitleRepository;
        this.announcementTypeRepository = announcementTypeRepository;
    }

    @Override
    public List<FacultyDTO> getFacultyDTOForSelect(Integer userId) {
        List<Role> roles = userService.findUserRolesById(userId);
        boolean adminFound = false;
        for (Role role : roles) {
            if(role.getRole().equalsIgnoreCase("university_admin")){
                adminFound = true;
                break;
            }
        }
        if(adminFound)
            return facultyService.getFacultiesDTOOfAdministrator(userId);

        return facultyService.getFacultiesDTOOfCampusAdministrator(userId);
    }

    @Override
    public List<ProposalType> getProposalTypes() {
        List<ProposalType> returnList = new ArrayList<>();
        proposalTypeRepository.findAll().forEach(returnList::add);
        return returnList;
    }

    @Override
    public ProposalType getProposalType(Integer proposalId) {
        return proposalTypeRepository.findById(proposalId).get();
    }

    @Override
    public List<OricPositionsTitle> getOricPositionsTitles() {
        List<OricPositionsTitle> list = new ArrayList<>();
        oricPositionTitleRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public List<AnnouncementType> getAnnouncementTypes() {
        List<AnnouncementType> list = new ArrayList<>();
        announcementTypeRepository.findAll().forEach(list::add);
        return list;
    }
}
