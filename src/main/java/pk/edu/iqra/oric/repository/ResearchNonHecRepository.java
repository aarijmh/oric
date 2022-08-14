package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.ResearchNonHec;

import java.util.List;

@Repository
public interface ResearchNonHecRepository extends CrudRepository<ResearchNonHec,Integer> {

    @Query("from ResearchNonHec rl where rl.oricSession.id = ?1")
    List<ResearchNonHec> findOfOricSession(Integer oricSessionId);

    @Query("from ResearchNonHec rl where rl.faculty.campus.id = ?1")
    List<ResearchNonHec> findOfCampus(Integer campusId);
}
