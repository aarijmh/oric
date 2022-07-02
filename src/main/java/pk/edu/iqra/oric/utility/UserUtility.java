package pk.edu.iqra.oric.utility;

import pk.edu.iqra.oric.domain.User;
import pk.edu.iqra.oric.dto.UserDTO;

public class UserUtility {
    public static void putDTODataToEntity(UserDTO userDTO, User user){
        user.setCnic(userDTO.getCnic());
        user.setEmail(userDTO.getEmail());
        user.setFieldOfStudy(userDTO.getFieldOfStudy());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setQualificationLevel(userDTO.getQualificationLevel());
        user.setQualificationTitle(userDTO.getQualificationTitle());
        user.setSalutation(userDTO.getSalutation());
        user.setMobile(userDTO.getMobile());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        user.setDob(UtilityFunctions.stringToLocalDate(userDTO.getDob()));
        user.setJoinningDate(UtilityFunctions.stringToLocalDate(userDTO.getJoinningDate()));

    }

    public static String getNameFromUser(User user){
        StringBuffer buffer = new StringBuffer();
        if(user.getFirstName() != null)
            buffer.append(user.getFirstName()).append(" ");
        if(user.getMiddleName() != null)
            buffer.append(user.getMiddleName()).append(" ");
        if(user.getLastName() != null)
            buffer.append(user.getLastName());
        return buffer.toString();
    }
}
