package pk.edu.iqra.oric.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import pk.edu.iqra.oric.domain.Oric;
import pk.edu.iqra.oric.domain.OricSession;
import pk.edu.iqra.oric.exception.RequestDeniedException;
import pk.edu.iqra.oric.service.OricService;
import pk.edu.iqra.oric.utility.UtilityFunctions;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public class OricInterceptor implements HandlerInterceptor {

    @Autowired
    private OricService oricService;

    public OricInterceptor(){

    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {



       if(request.getParameterMap().containsKey("oricSessionId"))
       {
           Principal principal =  request.getUserPrincipal();
           Integer id = UtilityFunctions.getIdFromPrincipal(principal);
           var sId = request.getParameter("oricSessionId");

           if(!oricService.verifySessionRequestForUser(id,Integer.valueOf(sId))){
               throw new RequestDeniedException("You are not authorized to handle this ORIC Session");
           }
       }


        return true;
    }
}
