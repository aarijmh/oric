package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pk.edu.iqra.oric.domain.ResearchLink;

import java.util.List;

public interface ResearchLinkRepository extends CrudRepository<ResearchLink,Integer> {

    @Query("from ResearchLink rl where rl.oricSession.id = ?1")
    List<ResearchLink> findResearchLinksOfOricSession(Integer oricSessionId);
}
