package pk.edu.iqra.oric.repository;

import pk.edu.iqra.oric.domain.Announcement;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.edu.iqra.oric.domain.OricSession;

@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement,Integer> {

    @Query("from Announcement rl where rl.oricSession.id = ?1")
    List<Announcement> findOfOricSession(Integer oricSessionId);

    @Query("from Announcement rl where rl.faculty.campus.id = ?1")
    List<Announcement> findOfCampus(Integer campusId);

    @Query("from Announcement rl where rl.oricSession.university.id = ?1 and rl.oricSession.isClosed = false and rl.announcementType.id = ?2 and rl.expiryDate <= ?3 order by rl.createdOn desc")
    List<Announcement> findAnnouncementsOfUniversity(Integer universityId, Integer typeId, LocalDate limit);

    @Query("from Announcement rl where rl.id = ?2 and rl.oricSession.university.encryptedId = ?1")
    Announcement findAnnouncementOfUniversity(String universityId, Integer adId);

    @Query("select rl.oricSession from Announcement rl where rl.id = ?2 and rl.oricSession.university.encryptedId = ?1")
    OricSession findOricSessionOfAnnouncement(String universityId, Integer adId);
}
