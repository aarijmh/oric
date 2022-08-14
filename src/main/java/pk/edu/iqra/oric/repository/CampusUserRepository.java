package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.CampusUser;

@Repository
public interface CampusUserRepository extends CrudRepository<CampusUser,Integer> {

    @Query("from CampusUser  cu where cu.campus.id = ?1 and cu.user.id = ?2")
    CampusUser findCampusUser(Integer campusId, Integer userId);
}
