package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.domain.Research;

import java.util.List;

@Repository
public interface OricSessionRepository extends CrudRepository<OricSession,Integer> {

    @Query("from OricSession os where os.university.id = ?1")
    List<OricSession> findOricSessionsOfUniversity(Integer university);

    @Query("from Research rph " +
            " left join fetch rph.coInvestigator1 ci1 " +
            " left join fetch rph.coInvestigator2 ci2 " +
            " left join fetch rph.faculty faculty " +
            " left join fetch rph.principalInvestigator pi " +
            " left join fetch faculty.campus campus " +
            "where rph.oricSession.id = ?1 and rph.proposalType.id = ?2")
    List<Research> findResearchTypeOfOricSession(Integer oricSessionId, Integer typeId);
}
