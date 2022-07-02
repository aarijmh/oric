package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.ResearchContract;


import java.util.List;

@Repository
public interface ResearchContractRepository extends CrudRepository<ResearchContract,Integer> {

    @Query("from ResearchContract rl where rl.oricSession.id = ?1")
    List<ResearchContract> findOfOricSession(Integer oricSessionId);
}
