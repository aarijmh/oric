package pk.edu.iqra.oric.service;

import pk.edu.iqra.oric.domain.AnnouncementType;
import pk.edu.iqra.oric.domain.OricPosition;
import pk.edu.iqra.oric.domain.OricPositionsTitle;
import pk.edu.iqra.oric.domain.ProposalType;
import pk.edu.iqra.oric.dto.FacultyDTO;

import java.util.List;

public interface DataService {
    List<FacultyDTO> getFacultyDTOForSelect(Integer userId);
    List<ProposalType> getProposalTypes();
    ProposalType getProposalType(Integer proposalId);

    List<OricPositionsTitle> getOricPositionsTitles();

    List<AnnouncementType> getAnnouncementTypes();

    String getAnnouncementTypeName(Integer typeId);
}
