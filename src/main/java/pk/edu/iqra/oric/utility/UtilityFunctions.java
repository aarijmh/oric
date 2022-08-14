package pk.edu.iqra.oric.utility;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.File;
import java.security.Principal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class UtilityFunctions {

    private static DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   private static DateTimeFormatter instantFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault());

    private static final String BASE_DRIVE = System.getProperty("user.home") + File.separator;
    private static final String BASE_FOLDER = BASE_DRIVE+"OricDOcuments"+ File.separator;







    public static String localDateToString(LocalDate date){
        if(date == null)
            return "";
        return date.format(simpleFormat);
    }

    public static LocalDate stringToLocalDate(String date){
        try{
            return LocalDate.parse(date,simpleFormat);
        }catch (Exception e){
            return LocalDate.now();
        }
    }

    public static String localDateToString(Instant date){
        if(date == null)
            return "";
       return instantFormatter.format(date);
    }

    public static Instant stringToInstantDate(String date){
        try{
            return Instant.parse(date);

        }catch (Exception e){
            try {
               return stringToLocalDate(date).atStartOfDay(ZoneId.of("Asia/Karachi")).toInstant();
            }
            catch (Exception e1) {
                return Instant.now();
            }
        }
    }

    public static Integer getIdFromPrincipal(Principal principal){
        return ((CustomUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getId();
    }

    public static String getURLForDocumentUpload(Integer oricSessionId, Integer researchId, Integer type){
        StringBuffer buffer = new StringBuffer();
        buffer.append(BASE_FOLDER).append(ServiceConstants.DIRECTORY_MAP.get(type)).append(oricSessionId).append(File.separator).append(researchId);
        return buffer.toString();
    }
}
