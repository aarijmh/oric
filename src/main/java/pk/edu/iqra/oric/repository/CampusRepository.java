package pk.edu.iqra.oric.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.Campus;

@Repository
public interface CampusRepository extends CrudRepository<Campus,Integer> {
}
