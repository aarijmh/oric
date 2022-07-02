package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.ResearchNonHec;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchNonHecRepository extends CrudRepository<ResearchNonHec,Integer> {

    @Query("from ResearchNonHec rl where rl.oricSession.id = ?1")
    List<ResearchNonHec> findOfOricSession(Integer oricSessionId);
}
