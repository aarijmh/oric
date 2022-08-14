package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.PolicyCase;
import pk.edu.iqra.oric.domain.Research;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.PolicyCaseDTO;
import pk.edu.iqra.oric.dto.ResearchDTO;
import pk.edu.iqra.oric.dto.ResearchLinkDTO;
import pk.edu.iqra.oric.repository.OricSessionRepository;
import pk.edu.iqra.oric.repository.PolicyCaseRepository;
import pk.edu.iqra.oric.repository.ProposalTypeRepository;
import pk.edu.iqra.oric.repository.ResearchRepository;
import pk.edu.iqra.oric.service.*;
import pk.edu.iqra.oric.utility.ServiceConstants;
import pk.edu.iqra.oric.utility.UserUtility;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OricSessionServiceImpl implements OricSessionService {

    private OricSessionRepository oricSessionRepository;
    private ResearchRepository researchRepository;
    private UserService userService;

    private FacultyService facultyService;

    private FileService fileService;

    private ResearchLinkService researchLinkService;
    private ResearchContractService researchContractService;


    private ProposalTypeRepository proposalTypeRepository;

    private PolicyCaseRepository policyCaseRepository;


    @Autowired
    public OricSessionServiceImpl(OricSessionRepository oricSessionRepository, ResearchRepository researchRepository,
                                  UserService userService, FacultyService facultyService,
                                  ProposalTypeRepository proposalTypeRepository,PolicyCaseRepository policyCaseRepository,
                                  FileService fileService, ResearchLinkService researchLinkService,
                                  ResearchContractService researchContractService) {
        this.oricSessionRepository = oricSessionRepository;
        this.researchRepository = researchRepository;
        this.userService = userService;
        this.facultyService = facultyService;
        this.proposalTypeRepository = proposalTypeRepository;
        this.fileService = fileService;
        this.policyCaseRepository = policyCaseRepository;
        this.researchLinkService = researchLinkService;
        this.researchContractService = researchContractService;
    }

    @Override
    public List<ResearchDTO> getResearches(Integer oricSessionId,Integer typeId) {
        return oricSessionRepository.findResearchTypeOfOricSession(oricSessionId,typeId).stream().map(x -> new ResearchDTO(x)).collect(Collectors.toList());
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ResearchDTO saveResearch(Integer oricSessionId, Integer userId, ResearchDTO dto) throws Exception {
        Research classObject = null;
        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new Research();
            classObject.setCreatedOn(LocalDate.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = researchRepository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }
        if(dto.getProposalTypeId() != null)
            classObject.setProposalType(proposalTypeRepository.findById(dto.getProposalTypeId()).get());

        ResearchDTO.copyFromDto(dto, classObject);
        classObject.setUpdatedBy(creator);
        classObject.setUpdatedOn(LocalDate.now());

        List<Integer> userList = new ArrayList<>();


        if(dto.getPrincipalInvestigatorId() != null)
            userList.add(dto.getPrincipalInvestigatorId());
        if(dto.getCoInvestigator1Id() != null)
            userList.add(dto.getCoInvestigator1Id());
        if(dto.getCoInvestigator2Id() != null)
            userList.add(dto.getCoInvestigator2Id());

        Map<Integer,User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId,x->x));
        if(dto.getPrincipalInvestigatorId() != null) {
            classObject.setPrincipalInvestigator(userMap.get(dto.getPrincipalInvestigatorId()));
            dto.setPrincipalInvestigatorName(UserUtility.getNameFromUser(classObject.getPrincipalInvestigator()));
        }
        else
            classObject.setPrincipalInvestigator(null);

        if(dto.getCoInvestigator1Id() != null) {
            classObject.setCoInvestigator1(userMap.get(dto.getCoInvestigator1Id()));
            dto.setCoInvestigator1Name(UserUtility.getNameFromUser(classObject.getCoInvestigator1()));
        }
        else
            classObject.setCoInvestigator1(null);

        if(dto.getCoInvestigator2Id() != null) {
            classObject.setCoInvestigator2(userMap.get(dto.getCoInvestigator2Id()));
            dto.setCoInvestigator1Name(UserUtility.getNameFromUser(classObject.getCoInvestigator1()));
        }
        else
            classObject.setCoInvestigator2(null);

        if(dto.getFacultyId() != null) {
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));
            dto.setFacultyName(classObject.getFaculty().getName());
            dto.setCampusName(classObject.getFaculty().getCampus().getName());
        }

        if(dto.getProposalTypeId() != null && !dto.getProposalTypeId().equals(0))
            classObject.setProposalType(proposalTypeRepository.findById(dto.getProposalTypeId()).get());



        dto.setId(researchRepository.save(classObject).getId());

        return dto;
    }

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteResearch(Integer oricSessionId, Integer userId, Integer proposalId) {
        researchRepository.deleteById(proposalId);
    }

    @Override
    public DtoInterface uploadResearchFiles(Integer oricSessionId, Integer userId, Integer typeId, String researchDTO, List<MultipartFile> files) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        DtoInterface dtoInterface = null;


        switch (typeId.intValue()){
            case ServiceConstants.RESEARCH_PROPOSALS:
                dtoInterface = mapper.readValue(researchDTO,ResearchDTO.class);
                dtoInterface = saveResearch(oricSessionId,userId,(ResearchDTO) dtoInterface);
                break;
            case ServiceConstants.POLICY_CASE:
                dtoInterface = savePolicy(oricSessionId,userId,researchDTO);
                break;
            case ServiceConstants.RESEARCH_LINK:
                dtoInterface = researchLinkService.saveResource(oricSessionId,userId,researchDTO);
                break;
            case ServiceConstants.RESEARCH_CONTRACT:
                dtoInterface = researchContractService.saveResource(oricSessionId,userId,researchDTO);
                break;
            default:
                dtoInterface = null;
                break;
        }
        //

        fileService.uploadFiles(Path.of(UtilityFunctions.getURLForDocumentUpload(oricSessionId,dtoInterface.getId(),typeId)),files);

        return dtoInterface;
    }

    @Override
    public File getFileOfResearch(Integer oricSessionId, Integer researchId, String fileName, Integer typeId) throws IOException {
        return fileService.getFileFromDirectory(Path.of(UtilityFunctions.getURLForDocumentUpload(oricSessionId,researchId,typeId)),fileName);
    }

    @Override
    public void deleteFileOfResearch(Integer oricSessionId, Integer researchId, String fileName, Integer typeId) throws IOException {
        fileService.deleteFileFromDirectory(Path.of(UtilityFunctions.getURLForDocumentUpload(oricSessionId,researchId,typeId)),fileName);
    }

    @Override
    public List<String> getFiles(Integer oricSessionId, Integer researchId, Integer typeId) {
        try {
            return fileService.getNamesOfAllFilesInDirectory(Path.of(UtilityFunctions.getURLForDocumentUpload(oricSessionId,researchId,typeId)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        Policy Case Things
     */
    @Override
    public List<PolicyCase> getPolicies(Integer oricSessionId) {
        return policyCaseRepository.findOfOricSession(oricSessionId);
    }

    @Override
    public List<PolicyCaseDTO> getPoliciesDTO(Integer oricSessionId) {
        return getPolicies(oricSessionId).stream().map(x->new PolicyCaseDTO(x)).collect(Collectors.toList());
    }

    @Override
    public PolicyCaseDTO savePolicy(Integer oricSessionId, Integer userId, String dtoString) throws Exception {
        PolicyCase classObject = null;
        ObjectMapper mapper = new ObjectMapper();
        PolicyCaseDTO dto = mapper.readValue(dtoString,PolicyCaseDTO.class);
        User creator = userService.getUserByUserId(userId);
        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();

        if (dto.getId() == null || dto.getId().equals(0)) {
            classObject = new PolicyCase();
            classObject.setCreatedOn(Instant.now());
            classObject.setCreatedBy(creator);
            classObject.setOricSession(oricSession);

        } else {
            classObject = policyCaseRepository.findById(dto.getId()).get();
            if (classObject == null)
                throw new Exception("Illegal Request");
        }


        PolicyCaseDTO.copyFromDto(dto, classObject);
        classObject.setModifiedBy(creator);
        classObject.setModifiedOn(Instant.now());

        List<Integer> userList = new ArrayList<>();

        if(dto.getPiId() != null)
            userList.add(dto.getPiId());
        if(dto.getCoPi1Id() != null)
            userList.add(dto.getCoPi1Id());
        if(dto.getCoPi2Id() != null)
            userList.add(dto.getCoPi2Id());

        Map<Integer,User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId,x->x));
        if(dto.getPiId() != null)
            classObject.setPi(userMap.get(dto.getPiId()));
        else
            classObject.setPi(null);
        if(dto.getCoPi1Id() != null)
            classObject.setCoPi1(userMap.get(dto.getCoPi1Id()));
        else
            classObject.setCoPi1(null);
        if(dto.getCoPi2Id() != null)
            classObject.setCoPi2(userMap.get(dto.getCoPi2Id()));
        else
            classObject.setCoPi2(null);

        if(dto.getFacultyId() != null && !dto.getFacultyId().equals(0))
            classObject.setFaculty(facultyService.getFacultyById(dto.getFacultyId()));

        dto.setId(policyCaseRepository.save(classObject).getId());

        return dto;
    }
    /*
    End Policy Case Things
     */

}
