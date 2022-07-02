package pk.edu.iqra.oric.service.impl;
import pk.edu.iqra.oric.domain.OricReport;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.utility.UtilityFunctions;
import pk.edu.iqra.oric.utility.UserUtility;


public class OricReportDTO extends DtoInterface {


private Integer id;
private Integer approvedById;
private String approvedByName;
private String title;
private String dateApproval;
private String refNo;
private Integer type;
private String remarks;
private Integer oricSessionId;
private Integer facultyId;
private String facultyName;
private Integer createdById;
private String createdByName;
private Integer modifiedById;
private String modifiedByName;
private String createdOn;
private String modifiedOn;

public OricReportDTO (){}


public OricReportDTO (OricReport oricReport){
copyFromObject(this,oricReport);
}


public static void copyFromObject(OricReportDTO oricReportDTO, OricReport classObject) {

oricReportDTO.id = classObject.getId();
if(classObject.getApprovedBy() != null ) {
oricReportDTO.approvedById = classObject.getApprovedBy().getId();
oricReportDTO.approvedByName = UserUtility.getNameFromUser(classObject.getApprovedBy());
}
oricReportDTO.title = classObject.getTitle();
oricReportDTO.dateApproval = UtilityFunctions.localDateToString(classObject.getDateApproval());
oricReportDTO.refNo = classObject.getRefNo();
oricReportDTO.type = classObject.getType();
oricReportDTO.remarks = classObject.getRemarks();
if(classObject.getOricSession() != null ) {
oricReportDTO.oricSessionId = classObject.getOricSession().getId();
}

if(classObject.getCreatedBy() != null ) {
oricReportDTO.createdById = classObject.getCreatedBy().getId();
oricReportDTO.createdByName = UserUtility.getNameFromUser(classObject.getCreatedBy());
}
if(classObject.getModifiedBy() != null ) {
oricReportDTO.modifiedById = classObject.getModifiedBy().getId();
oricReportDTO.modifiedByName = UserUtility.getNameFromUser(classObject.getModifiedBy());
}
oricReportDTO.createdOn = UtilityFunctions.localDateToString(classObject.getCreatedOn());
oricReportDTO.modifiedOn = UtilityFunctions.localDateToString(classObject.getModifiedOn());
}



public static void copyFromDto(OricReportDTO oricReportDTO, OricReport classObject) {
classObject.setId(oricReportDTO.id);
classObject.setTitle(oricReportDTO.title);
classObject.setDateApproval(UtilityFunctions.stringToInstantDate(oricReportDTO.dateApproval));
classObject.setRefNo(oricReportDTO.refNo);
classObject.setType(oricReportDTO.type);
classObject.setRemarks(oricReportDTO.remarks);
classObject.setCreatedOn(UtilityFunctions.stringToInstantDate(oricReportDTO.createdOn));
classObject.setModifiedOn(UtilityFunctions.stringToInstantDate(oricReportDTO.modifiedOn));
}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


}
