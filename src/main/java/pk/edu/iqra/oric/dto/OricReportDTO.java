package pk.edu.iqra.oric.dto;

import pk.edu.iqra.oric.domain.OricReport;
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

    public OricReportDTO() {
    }


    public OricReportDTO(OricReport oricReport) {
        copyFromObject(this, oricReport);
    }


    public static void copyFromObject(OricReportDTO oricReportDTO, OricReport classObject) {

        oricReportDTO.id = classObject.getId();
        if (classObject.getApprovedBy() != null) {
            oricReportDTO.approvedById = classObject.getApprovedBy().getId();
            oricReportDTO.approvedByName = UserUtility.getNameFromUser(classObject.getApprovedBy());
        }
        oricReportDTO.title = classObject.getTitle();
        oricReportDTO.dateApproval = UtilityFunctions.localDateToString(classObject.getDateApproval());
        oricReportDTO.refNo = classObject.getRefNo();
        oricReportDTO.type = classObject.getType();
        oricReportDTO.remarks = classObject.getRemarks();
        if (classObject.getOricSession() != null) {
            oricReportDTO.oricSessionId = classObject.getOricSession().getId();
        }


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

    public Integer getApprovedById() {
        return approvedById;
    }

    public void setApprovedById(Integer approvedById) {
        this.approvedById = approvedById;
    }

    public String getApprovedByName() {
        return approvedByName;
    }

    public void setApprovedByName(String approvedByName) {
        this.approvedByName = approvedByName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateApproval() {
        return dateApproval;
    }

    public void setDateApproval(String dateApproval) {
        this.dateApproval = dateApproval;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getOricSessionId() {
        return oricSessionId;
    }

    public void setOricSessionId(Integer oricSessionId) {
        this.oricSessionId = oricSessionId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public Integer getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Integer modifiedById) {
        this.modifiedById = modifiedById;
    }

    public String getModifiedByName() {
        return modifiedByName;
    }

    public void setModifiedByName(String modifiedByName) {
        this.modifiedByName = modifiedByName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
