package pk.edu.iqra.oric.utility;

import java.util.HashMap;
import java.util.Map;

public class NavigationUtility {
    private NavigationUtility(){

    }

    public static final Map<String,NavigationStore> navigationMap = new HashMap<>(){
        {
            put("policy",new NavigationStore(ServiceConstants.POLICY_CASE,"/oricAdmin/policy"));
            put("researchlink",new NavigationStore(ServiceConstants.RESEARCH_LINK,"/oricAdmin/researchLinks"));
            put("researchcontract",new NavigationStore(ServiceConstants.RESEARCH_CONTRACT,"/oricAdmin/researchContracts"));
            put("consultancycontract",new NavigationStore(ServiceConstants.CONSULTANCY_CONTRACT,"/oricAdmin/consultancyContracts"));
            put("oricreport",new NavigationStore(ServiceConstants.ORIC_REPORT,"/oricAdmin/oricreports"));
            put("nonhec",new NavigationStore(ServiceConstants.RESEARCH_NON_HEC,"/oricAdmin/nonhecs"));
            put("jointresearch",new NavigationStore(ServiceConstants.JOINT_RESEARCH,"/oricAdmin/jointresearches"));
            put("research",new NavigationStore(ServiceConstants.JOINT_RESEARCH,"/oricAdmin/research"));
            put("intellectualproperty",new NavigationStore(ServiceConstants.INTELLECTUAL_PROPERTY,"/oricAdmin/intellectualProperty"));
            put("license",new NavigationStore(ServiceConstants.LICENSE,"/oricAdmin/license"));
            put("creativeproduct",new NavigationStore(ServiceConstants.CREATIVE_PRODUCT,"/oricAdmin/creativeProducts"));
            put("award",new NavigationStore(ServiceConstants.AWARD,"/oricAdmin/awards"));
            put("agreementcollab",new NavigationStore(ServiceConstants.AGGREMENT_COLLABORATION,"/oricAdmin/agreement"));
            put("visitrepresentative",new NavigationStore(ServiceConstants.VISIT_REPRESENTATIVE,"/oricAdmin/visitrepresentative"));
            put("trainings",new NavigationStore(ServiceConstants.TRAININGS,"/oricAdmin/trainings"));
            put("positions",new NavigationStore(ServiceConstants.POSITIONS,"/oricAdmin/positions"));
            put("announcements",new NavigationStore(ServiceConstants.ANNOUNCEMENTS,"/oricAdmin/announcements"));
        }
    };
}
