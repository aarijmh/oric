package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.IntellectualProperty;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntellectualPropertyRepository extends CrudRepository<IntellectualProperty,Integer> {

    @Query("from IntellectualProperty rl where rl.oricSession.id = ?1")
    List<IntellectualProperty> findOfOricSession(Integer oricSessionId);


    @Query("from IntellectualProperty rl where rl.faculty.campus.id = ?1")
    List<IntellectualProperty> findOfCampus(Integer campusId);
}
