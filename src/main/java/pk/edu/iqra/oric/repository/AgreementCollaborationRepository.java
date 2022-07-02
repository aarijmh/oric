package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.AggrementCollaboration;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementCollaborationRepository extends CrudRepository<AggrementCollaboration,Integer> {

    @Query("from AggrementCollaboration rl where rl.oricSession.id = ?1")
    List<AggrementCollaboration> findOfOricSession(Integer oricSessionId);
}
