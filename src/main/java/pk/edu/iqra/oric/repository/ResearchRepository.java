package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pk.edu.iqra.oric.domain.ConsultancyContract;
import pk.edu.iqra.oric.domain.Research;

import java.util.List;

public interface ResearchRepository extends CrudRepository<Research,Integer> {
    @Query("from Research rl where rl.oricSession.id = ?1")
    List<Research> findOfOricSession(Integer oricSessionId);

    @Query("from Research rl where rl.faculty.campus.id = ?1")
    List<Research> findOfCampus(Integer campusId);
}
