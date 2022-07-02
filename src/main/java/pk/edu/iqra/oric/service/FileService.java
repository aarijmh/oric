package pk.edu.iqra.oric.service;

import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.dto.DtoInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileService {
    public List<String> uploadFiles(Path directory, List<MultipartFile> files) throws IOException;
    public List<String> uploadFileAtDirectoryWithName(Path directory,String name, MultipartFile file) throws IOException;
    List<String> getNamesOfAllFilesInDirectory(Path directory) throws IOException;
    public File getFileFromDirectory(Path directory, String fileName) throws IOException;
    public void deleteFileFromDirectory(Path directory, String fileName) throws IOException;

    public DtoInterface uploadFiles(Integer oricSessionId, Integer userId, Integer typeId, String researchDTO, List<MultipartFile> files, GenericResourceService genericResourceService) throws Exception;
}
