package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.CreativeProduct;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreativeProductRepository extends CrudRepository<CreativeProduct,Integer> {

    @Query("from CreativeProduct rl where rl.oricSession.id = ?1")
    List<CreativeProduct> findOfOricSession(Integer oricSessionId);

    @Query("from CreativeProduct rl where rl.faculty.campus.id = ?1")
    List<CreativeProduct> findOfCampus(Integer campusId);
}
