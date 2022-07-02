package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.Announcement;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement,Integer> {

    @Query("from Announcement rl where rl.oricSession.id = ?1")
    List<Announcement> findOfOricSession(Integer oricSessionId);
}
