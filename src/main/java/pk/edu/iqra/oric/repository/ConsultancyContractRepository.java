package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pk.edu.iqra.oric.domain.ConsultancyContract;


import java.util.List;

public interface ConsultancyContractRepository extends CrudRepository<ConsultancyContract,Integer> {

    @Query("from ConsultancyContract rl where rl.oricSession.id = ?1")
    List<ConsultancyContract> findOfOricSession(Integer oricSessionId);
}
