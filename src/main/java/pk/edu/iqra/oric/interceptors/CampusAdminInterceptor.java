package pk.edu.iqra.oric.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import pk.edu.iqra.oric.exception.RequestDeniedException;
import pk.edu.iqra.oric.service.OricService;
import pk.edu.iqra.oric.service.UserService;
import pk.edu.iqra.oric.utility.CustomUserDetails;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public class CampusAdminInterceptor implements HandlerInterceptor {


    @Autowired
    private UserService userService;

    @Autowired
    public CampusAdminInterceptor(){
    }


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {


        CustomUserDetails principal =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer universityId = (Integer)request.getSession().getAttribute("university_id");
        Integer campusId = (Integer)request.getSession().getAttribute("campus_id");
        if(campusId == null || universityId == null){
            Integer id =principal.getId();
            Integer [] ids =  userService.getUniversityAndCampusIdOfUser(id);
            campusId = ids[0];
            universityId = ids[1];

            request.getSession().setAttribute("university_id",universityId);
            request.getSession().setAttribute("campus_id",campusId);
        }


        return true;
    }
}
