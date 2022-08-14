package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.PolicyCase;

import java.util.List;

@Repository
public interface PolicyCaseRepository extends CrudRepository<PolicyCase,Integer> {

    @Query("from PolicyCase pc where pc.oricSession.id = ?1")
    List<PolicyCase> findOfOricSession(Integer oricsessionId);

    @Query("from PolicyCase rl where rl.faculty.campus.id = ?1")
    List<PolicyCase> findOfCampus(Integer campusId);
}
