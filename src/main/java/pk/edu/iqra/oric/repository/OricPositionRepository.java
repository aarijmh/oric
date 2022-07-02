package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.OricPosition;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OricPositionRepository extends CrudRepository<OricPosition,Integer> {

    @Query("from OricPosition rl where rl.oricSession.id = ?1")
    List<OricPosition> findOfOricSession(Integer oricSessionId);
}
