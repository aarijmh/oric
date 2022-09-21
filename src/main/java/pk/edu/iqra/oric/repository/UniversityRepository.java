package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.Oric;
import pk.edu.iqra.oric.domain.University;

@Repository
public interface UniversityRepository extends CrudRepository<University,Integer> {

    @Query(" from University  univ" +
            " left join fetch univ.vc vc" +
            " left join fetch univ.vcPa vcpa" +
            " left join fetch univ.registrar vcreg" +
            " left join fetch univ.registrarPa vcregpa" +
            " where univ.id = (select u.university.id from User u where u.id = ?1)")
    University findUniversityOfAdministrator(Integer administratorId);


    @Query("from University u where u.encryptedId like ?1")
    University findUniversityByEncryptedId(String encryptedId);

    @Query("from Oric o where o.university.encryptedId like ?1")
    Oric findOricOfUniversity(String encryptedId);
}
