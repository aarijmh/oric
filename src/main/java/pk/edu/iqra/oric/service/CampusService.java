package pk.edu.iqra.oric.service;

import pk.edu.iqra.oric.domain.Campus;
import pk.edu.iqra.oric.dto.CampusDTO;

public interface CampusService {
    Campus getById(Integer campusId);
}
