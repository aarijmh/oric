package pk.edu.iqra.oric.service;

import org.springframework.data.util.Pair;
import pk.edu.iqra.oric.domain.Role;
import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    List<Role> findUserRolesById(Integer id);

    List<UserDTO> getUsers(Integer administratorId) throws Exception;

    UserDTO saveUser(UserDTO userDTO, Integer administratorId);

    void deleteUser(Integer userId);

    List<User> getAllUsersOfList(List<Integer> users);

    User getUserByUserId(Integer id);

    Integer[] getUniversityAndCampusIdOfUser(Integer userId);

    void saveUserCampus(Integer campusId, Integer userId);

    List<UserDTO> getUsersOfCampus(Integer administratorId) throws Exception;
}
