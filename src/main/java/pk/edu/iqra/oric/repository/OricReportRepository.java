package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.OricReport;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.OricReport;

@Repository
public interface OricReportRepository extends CrudRepository<OricReport,Integer> {

    @Query("from OricReport rl where rl.oricSession.id = ?1")
    List<OricReport> findOfOricSession(Integer oricSessionId);
}
