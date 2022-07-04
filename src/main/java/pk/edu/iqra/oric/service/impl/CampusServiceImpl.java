package pk.edu.iqra.oric.service.impl;

import org.springframework.stereotype.Service;
import pk.edu.iqra.oric.domain.Campus;
import pk.edu.iqra.oric.dto.CampusDTO;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.repository.CampusRepository;
import pk.edu.iqra.oric.service.CampusService;

import java.util.List;

@Service
public class CampusServiceImpl implements CampusService {

    private CampusRepository campusRepository;

    public CampusServiceImpl(CampusRepository campusRepository){
        this.campusRepository = campusRepository;
    }


    @Override
    public Campus getById(Integer campusId) {
        return campusRepository.findById(campusId).get();
    }
}
