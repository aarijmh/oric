package pk.edu.iqra.oric.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.ResearchDTO;
import pk.edu.iqra.oric.service.FileService;
import pk.edu.iqra.oric.service.GenericResourceService;
import pk.edu.iqra.oric.utility.ServiceConstants;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<String> uploadFiles(Path directory, List<MultipartFile> files) throws IOException {
        List<String> returnList = new ArrayList<>();
        boolean dirExists = Files.exists(directory);
        if (!dirExists) {
            try {
                Files.createDirectories(directory);
            } catch (IOException ioExceptionObj) {
                throw new IOException("Problem Occured While Creating The Directory Structure= " + ioExceptionObj.getMessage());
            }
        }

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            returnList.add(fileName);
            Path copyLocation = Paths.get(directory + File.separator + StringUtils.cleanPath(fileName));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        }

        return returnList;
    }

    @Override
    public List<String> uploadFileAtDirectoryWithName(Path directory, String name, MultipartFile file) throws IOException {
        List<String> returnList = new ArrayList<String>();
        boolean dirExists = Files.exists(directory);
        if (!dirExists) {
            try {
                Files.createDirectories(directory);
            } catch (IOException ioExceptionObj) {
                throw new IOException("Problem Occured While Creating The Directory Structure= " + ioExceptionObj.getMessage());
            }
        }

        returnList.add(name);
        Path copyLocation = Paths.get(directory + File.separator + StringUtils.cleanPath(name));
        Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

        return returnList;

    }

    @Override
    public List<String> getNamesOfAllFilesInDirectory(Path directory) throws IOException {
        if (!directory.toFile().exists())
            return new ArrayList<>();
        return Files.list(directory).map(Path::getFileName).map(x -> x.toString()).collect(Collectors.toList());

    }

    @Override
    public File getFileFromDirectory(Path directory, String fileName) throws IOException {
        if (!directory.toFile().exists())
            return null;
        for (File ff : directory.toFile().listFiles()) {
            if (ff.getName().toLowerCase().equals(fileName.toLowerCase())) {
                return ff;
            }
        }
        return null;
    }

    @Override
    public void deleteFileFromDirectory(Path directory, String fileName) throws IOException {
        if (!directory.toFile().exists())
            return;
        for (File ff : directory.toFile().listFiles()) {
            if (ff.getName().toLowerCase().equals(fileName.toLowerCase())) {
                ff.delete();
                return;
            }
        }
    }

    @Override
    public DtoInterface uploadFiles(Integer oricSessionId, Integer userId, Integer typeId, String researchDTO, List<MultipartFile> files, GenericResourceService genericResourceService) throws Exception {

        DtoInterface dtoInterface = null;

        dtoInterface = genericResourceService.saveResource(oricSessionId,userId,researchDTO);

        uploadFiles(Path.of(UtilityFunctions.getURLForDocumentUpload(oricSessionId,dtoInterface.getId(),typeId)),files);

        return dtoInterface;
    }
}
