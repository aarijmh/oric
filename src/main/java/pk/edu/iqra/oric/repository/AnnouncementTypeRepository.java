package pk.edu.iqra.oric.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.AnnouncementType;

@Repository
public interface AnnouncementTypeRepository extends CrudRepository<AnnouncementType,Integer> {
}
