package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.Award;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends CrudRepository<Award,Integer> {

    @Query("from Award rl where rl.oricSession.id = ?1")
    List<Award> findOfOricSession(Integer oricSessionId);
}
