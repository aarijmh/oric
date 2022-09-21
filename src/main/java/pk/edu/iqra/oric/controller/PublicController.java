package pk.edu.iqra.oric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pk.edu.iqra.oric.publicdto.PublicAnnouncementDTO;
import pk.edu.iqra.oric.publicdto.PublicOricDTO;
import pk.edu.iqra.oric.service.AnnouncementService;
import pk.edu.iqra.oric.service.UniversityService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/public")
public class PublicController {

    private AnnouncementService announcementService;
    private UniversityService universityService;

    @Autowired
    public PublicController(AnnouncementService announcementService, UniversityService universityService){
        this.announcementService = announcementService;
        this.universityService = universityService;
    }

    @GetMapping("/getPublicAnnouncement/university/{university}/type/{type}")
    @ResponseBody
    public List<PublicAnnouncementDTO> getPublicAnnouncements(@PathVariable("university")  String universityId,
                                                              @PathVariable("type")  Integer typeId,
                                                              HttpServletRequest request){
        return announcementService.getPublicAnnouncements(universityId,typeId);
    }

    @GetMapping("/getPublicORIC/university/{university}")
    @ResponseBody
    public PublicOricDTO getPublicORIC(@PathVariable("university")  String universityId,
                                                HttpServletRequest request){
        return universityService.getPublicInfoAboutORIC(universityId);
    }

    @GetMapping("/getPuclicAd/university/{university}/adId/{adId}")
    @ResponseBody
    public PublicAnnouncementDTO getPuclicAd(@PathVariable("university")  String universityId,
                                       @PathVariable("adId") Integer adId,
                                       HttpServletRequest request){
        return announcementService.getPublicAd(universityId,adId);
    }

    @GetMapping("/getPublicFiles/university/{univId}/adId/{adId}")
    @ResponseBody
    public List<String> getPublicFiles(@PathVariable("univId") String universityId,
                                 @PathVariable("adId") Integer adId) throws Exception {

        return announcementService.getPublicAdFiles(universityId,adId);
    }

    @GetMapping("/openFile/univ/{univId}/adId/{adId}/fileName/{fileName}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> showUploadFile(@PathVariable("univId") String univId,
                                                              @PathVariable("adId") Integer adId,
                                                              @PathVariable("fileName") String fileName) throws IOException
    {
        File file = announcementService.getFileOfAd(univId,adId,fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName().replace(" ", "%20"))
                .contentLength(file.length()).body(resource);
    }
}
