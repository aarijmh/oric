package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.AgreementCollaboration;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementCollaborationRepository extends CrudRepository<AgreementCollaboration,Integer> {

    @Query("from AgreementCollaboration rl where rl.oricSession.id = ?1")
    List<AgreementCollaboration> findOfOricSession(Integer oricSessionId);


    @Query("from AgreementCollaboration rl where rl.faculty.campus.id = ?1")
    List<AgreementCollaboration> findOfCampus(Integer campusId);
}
