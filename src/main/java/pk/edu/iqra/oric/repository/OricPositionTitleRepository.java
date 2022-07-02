package pk.edu.iqra.oric.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.OricPositionsTitle;

@Repository
public interface OricPositionTitleRepository extends CrudRepository<OricPositionsTitle,Integer> {
}
