package pk.edu.iqra.oric.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.Role;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.UserDTO;
import pk.edu.iqra.oric.repository.UserRepository;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.UserUtility;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
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

        for (User user : userRepository.findAllUsersOfAdministratorUniversity(administrator.getId())) {
            userDTOList.add(new UserDTO(user));
        }

        return userDTOList;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public UserDTO saveUser(UserDTO userDTO, Integer administratorId) {
        User user = null;
        if(userDTO.getId() == null){
            user = new User();
            user.setUniversity(userRepository.findUniversityOfAdministrator(administratorId));
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
}
