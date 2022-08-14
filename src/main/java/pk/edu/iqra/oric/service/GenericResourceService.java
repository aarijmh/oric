package pk.edu.iqra.oric.service;


import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.utility.Constants;

import java.util.List;

public interface GenericResourceService<Cl,Dt> {

     List<Cl> getResource(Integer oricSessionId);



     List<Dt> getResourceDTO(Integer oricSessionId);

    default  List<Dt> getResourceDTO(List<Cl> classObjectList){
         return null;
     }
    default List<Cl> getResourceForRole(Integer oricSessionId, Integer campusId, String role){
        return null;
    }

    DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception;

    default List<Dt> getResourceDTOForRole(Integer oricSessionId, Integer campusId, String role){

        return getResourceDTO(getResourceForRole(oricSessionId,campusId,role));
    }


}
