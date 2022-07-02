package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.Oric;
import pk.edu.iqra.oric.domain.OricSession;

@Repository
public interface OricRepository extends CrudRepository<Oric,Integer> {

    @Query("from Oric oric where oric.university.id = ?1")
    Oric findOricOfUniversity(Integer universityId);

    @Query("from Oric oric where oric.university.id = (select u.id from University u where u.id = (select u.id from User u where u.id = ?1))")
    Oric findOricOfAdministrator(Integer administrator);

    @Query("from OricSession os where os.id = ?1 and os.university.id = (select u.university.id from User u where u.id= ?2)")
    OricSession fincOricSessionByOricSessionIdAndUserId(Integer oricSessionId, Integer adminId);
}
