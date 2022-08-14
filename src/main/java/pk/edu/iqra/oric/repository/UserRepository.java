package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.Role;
import pk.edu.iqra.oric.domain.University;
import pk.edu.iqra.oric.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("from User u where lower(u.email) = ?1")
    User findByUsername(String email);

    @Query("select u.role from UserRole u where u.user.id = ?1")
    List<Role> findUserRolesById(Integer id);

    @Query("from User u where u.university.id = ?1 and u.isDeleted = false ")
    List<User> findAllUsersOfAdministratorUniversity(Integer administratorId);

    @Query("select u.university from User u where u.id = ?1")
    University findUniversityOfAdministrator(Integer id);

    @Query("from User u where u.id in ?1")
    List<User> findUsersInList(List<Integer> ids);

    @Query("select c.id, c.director.university.id from Campus c where c.director.id = ?1")
    Object getCampusAndUniversityIdOfUser(Integer id);

    @Query("select cu.user from CampusUser cu where cu.campus.id = ?1 and cu.user.isDeleted = false ")
    List<User> findAllUsersOfCampus(Integer campusId);
}
