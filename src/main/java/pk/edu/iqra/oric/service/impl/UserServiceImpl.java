package pk.edu.iqra.oric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.CampusUser;
import pk.edu.iqra.oric.domain.Role;
import pk.edu.iqra.oric.domain.University;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.UserDTO;
import pk.edu.iqra.oric.repository.CampusRepository;
import pk.edu.iqra.oric.repository.CampusUserRepository;
import pk.edu.iqra.oric.repository.UserRepository;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;
    private CampusRepository campusRepository;
    private CampusUserRepository campusUserRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CampusRepository campusRepository, CampusUserRepository campusUserRepository) {
        this.userRepository = userRepository;
        this.campusRepository = campusRepository;
        this.campusUserRepository = campusUserRepository;
    }



    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Role> findUserRolesById(Integer id) {
        return userRepository.findUserRolesById(id);
    }

    @Override
    public List<UserDTO> getUsers(Integer administratorId) throws Exception{
        User administrator = userRepository.findById(administratorId).get();
        if(administrator == null)
            throw new Exception("Invalid Request");

        List<UserDTO> userDTOList = new ArrayList<>();
        University university = administrator.getUniversity();

        for (User user : userRepository.findAllUsersOfAdministratorUniversity(university.getId())) {
            userDTOList.add(new UserDTO(user));
        }

        return userDTOList;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public UserDTO saveUser(UserDTO userDTO, Integer administratorId) {
        User user = null;
        if(userDTO.getId() == null || userDTO.getId().equals(0)){
            user = new User();
            user.setUniversity(userRepository.findUniversityOfAdministrator(administratorId));
            BCryptPasswordEncoder bCryptPasswordEncoder =
                    new BCryptPasswordEncoder(10, new SecureRandom());
            user.setPassword("{bcrypt}"+bCryptPasswordEncoder.encode("password"));
        }
        else {
            user = userRepository.findById(userDTO.getId()).get();
        }

        UserUtility.putDTODataToEntity(userDTO,user);

        user.setStatus(true);
        user.setIsDeleted(false);

        userRepository.save(user);

        userDTO.setId(user.getId());
        userDTO.setName(UserUtility.getNameFromUser(user));

        return userDTO;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteUser(Integer userId) {
        User user = null;
        if(userId == null){
           return;
        }

            user = userRepository.findById(userId).get();

        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsersOfList(List<Integer> users) {
        return userRepository.findUsersInList(users);
    }

    @Override
    public User getUserByUserId(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Integer []  getUniversityAndCampusIdOfUser(Integer userId) {

        Object  i = userRepository.getCampusAndUniversityIdOfUser(userId);
        Integer [] ids = new Integer[2];
        if( i != null){
            Object [] o = (Object[])i;
            ids[0] = (Integer) o[0];
            ids[1] = (Integer) o[1];
            return ids;
        }

        return ids;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void saveUserCampus(Integer campusId, Integer userId) {

        CampusUser campusUser = campusUserRepository.findCampusUser(campusId,userId);
        if(campusUser != null)
            return;
        campusUser = new CampusUser();
        campusUser.setUser(userRepository.findById(userId).get());
        campusUser.setCampus(campusRepository.findById(campusId).get());
        campusUserRepository.save(campusUser);
    }

    @Override
    public List<UserDTO> getUsersOfCampus(Integer campusId) throws Exception {
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userRepository.findAllUsersOfCampus(campusId)) {
            userDTOList.add(new UserDTO(user));
        }

        return userDTOList;
    }
}
