package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.JointResearch;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointResearchRepository extends CrudRepository<JointResearch,Integer> {

    @Query("from JointResearch rl where rl.oricSession.id = ?1")
    List<JointResearch> findOfOricSession(Integer oricSessionId);
}
