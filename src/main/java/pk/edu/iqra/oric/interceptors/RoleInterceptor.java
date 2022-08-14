package pk.edu.iqra.oric.interceptors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import pk.edu.iqra.oric.exception.RequestDeniedException;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public class RoleInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {


        String role = (String)request.getSession().getAttribute("role");
        if(role == null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(r -> r.getAuthority().equals("ROLE_UNIVERSITY_ADMIN"));
            boolean isCampusAdmin = authentication.getAuthorities().stream()
                    .anyMatch(r -> r.getAuthority().equals("ROLE_CAMPUS_ADMIN"));
            if(isAdmin)
                request.getSession().setAttribute("role","ROLE_UNIVERSITY_ADMIN");
            else if(isCampusAdmin)
                request.getSession().setAttribute("role","ROLE_CAMPUS_ADMIN");
        }
        return true;
    }
}
