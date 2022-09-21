package pk.edu.iqra.oric.service;


import pk.edu.iqra.oric.domain.Announcement;
import pk.edu.iqra.oric.dto.AnnouncementDTO;
import pk.edu.iqra.oric.publicdto.PublicAnnouncementDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AnnouncementService extends GenericResourceService<Announcement, AnnouncementDTO> {
    List<PublicAnnouncementDTO> getPublicAnnouncements(String universityId, Integer typeId);
    PublicAnnouncementDTO getPublicAd(String universityId, Integer adId);
    List<String> getPublicAdFiles(String universityId, Integer adId) throws IOException;

    File getFileOfAd(String univId, Integer adId, String fileName) throws IOException;
}
