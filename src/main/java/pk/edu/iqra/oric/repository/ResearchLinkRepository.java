package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pk.edu.iqra.oric.domain.ResearchLink;

import java.util.List;

public interface ResearchLinkRepository extends CrudRepository<ResearchLink,Integer> {

    @Query("from ResearchLink rl where rl.oricSession.id = ?1")
    List<ResearchLink> findOfOricSession(Integer oricSessionId);

    @Query("from ResearchLink rl where rl.faculty.campus.id = ?1")
    List<ResearchLink> findOfCampus(Integer campusId);
}
