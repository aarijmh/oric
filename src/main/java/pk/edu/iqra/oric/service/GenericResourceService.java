package pk.edu.iqra.oric.service;



import pk.edu.iqra.oric.dto.DtoInterface;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericResourceService<Cl,Dt> {

    public List<Cl> getResource(Integer oricSessionId);

    public List<Dt> getResourceDTO(Integer oricSessionId);

    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception;
}
