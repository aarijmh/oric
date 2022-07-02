package pk.edu.iqra.oric.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pk.edu.iqra.oric.dto.DtoInterface;
import pk.edu.iqra.oric.dto.PolicyCaseDTO;

public class Tester {
    public static void main(String [] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DtoInterface di = new PolicyCaseDTO();
        System.out.println(mapper.writeValueAsString(di));
    }
}
