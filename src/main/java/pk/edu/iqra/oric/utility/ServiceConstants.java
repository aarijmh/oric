package pk.edu.iqra.oric.utility;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ServiceConstants {
    private ServiceConstants(){

    }
    public static final int RESEARCH_PROPOSALS = 1;
    public static final int POLICY_CASE = 2;
    public static final int RESEARCH_LINK = 3;
    public static final int RESEARCH_CONTRACT = 4;
    public static final int CONSULTANCY_CONTRACT = 5;

    public static final int ORIC_REPORT = 6;
    public static final int RESEARCH_NON_HEC = 7;

    public static final int JOINT_RESEARCH = 8;

    public static final int INTELLECTUAL_PROPERTY = 9;

    public static final int LICENSE = 10;
    public static final int  CREATIVE_PRODUCT = 11;
    public static final int  AWARD = 12;
    public static final int  AGGREMENT_COLLABORATION = 13;
    public static final int  VISIT_REPRESENTATIVE = 14;
    public static final int  TRAININGS = 15;

    public static final int  POSITIONS = 16;

    public static final int  ANNOUNCEMENTS = 17;


    private static final String RESEARCH_FOLDER = "reSeaRCH"+ File.separator;
    private static final String POLICY_FOLDER = "poLICy"+File.separator;
    private static final String RESEARCH_LINK_FOLDER = "reseARCHLINK"+File.separator;
    private static final String RESEARCH_CONTRACT_FOLDER = "reseARCHContrACT"+File.separator;

    private static final String CONSULTANCY_CONTRACT_FOLDER = "cosULTancyContrACT"+File.separator;

    private static final String ORIC_REPORT_FOLDER = "oricReporT"+File.separator;

    private static final String RESEARCH_NON_HEC_FOLDER = "noHECResearcH"+File.separator;

    private static final String JOINT_RESEARCH_FOLDER = "joIntResearcH"+File.separator;

    private static final String INTELLECTUAL_PROPERTY_FOLDER = "intellECtualProperTY"+File.separator;

    private static final String LICENSE_FOLDER = "LicenSE"+File.separator;

    private static final String CREATIVE_PRODUCT_FOLDER = "CreativEPRoduct"+File.separator;
    private static final String AWARD_FOLDER = "AwaRd"+File.separator;
    private static final String AGGREMENT_COLLABORATION_FOLDER = "AggreMEntColl"+File.separator;
    private static final String VISIT_REPRESENTATIVE_FOLDER = "visitRePREsentative"+File.separator;

    private static final String TRAININGS_FOLDER = "trainiNGS"+File.separator;

    private static final String POSITIONS_FOLDER = "PositTions"+File.separator;

    private static final String ANNOUNCEMENTS_FOLDER = "annOunceMEnts"+File.separator;

    public static final Map<Integer,String> DIRECTORY_MAP = new HashMap<>(){
        {
            put(RESEARCH_PROPOSALS,RESEARCH_FOLDER);
            put(POLICY_CASE,POLICY_FOLDER);
            put(RESEARCH_LINK,RESEARCH_LINK_FOLDER);
            put(RESEARCH_CONTRACT,RESEARCH_CONTRACT_FOLDER);
            put(CONSULTANCY_CONTRACT,CONSULTANCY_CONTRACT_FOLDER);
            put(ORIC_REPORT,ORIC_REPORT_FOLDER);
            put(RESEARCH_NON_HEC,RESEARCH_NON_HEC_FOLDER);
            put(JOINT_RESEARCH,JOINT_RESEARCH_FOLDER);
            put(INTELLECTUAL_PROPERTY,INTELLECTUAL_PROPERTY_FOLDER);
            put(LICENSE,LICENSE_FOLDER);
            put(CREATIVE_PRODUCT,CREATIVE_PRODUCT_FOLDER);
            put(AWARD,AWARD_FOLDER);
            put(AGGREMENT_COLLABORATION,AGGREMENT_COLLABORATION_FOLDER);
            put(VISIT_REPRESENTATIVE,VISIT_REPRESENTATIVE_FOLDER);
            put(TRAININGS,TRAININGS_FOLDER);
            put(POSITIONS,POSITIONS_FOLDER);
            put(ANNOUNCEMENTS,ANNOUNCEMENTS_FOLDER);
        }
    };

}
