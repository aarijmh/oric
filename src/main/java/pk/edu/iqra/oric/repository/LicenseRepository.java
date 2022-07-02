package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.License;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License,Integer> {

    @Query("from License rl where rl.oricSession.id = ?1")
    List<License> findOfOricSession(Integer oricSessionId);
}
