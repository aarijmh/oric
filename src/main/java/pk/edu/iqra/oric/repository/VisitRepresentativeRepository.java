package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.VisitRepresentative;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepresentativeRepository extends CrudRepository<VisitRepresentative,Integer> {

    @Query("from VisitRepresentative rl where rl.oricSession.id = ?1")
    List<VisitRepresentative> findOfOricSession(Integer oricSessionId);
}
