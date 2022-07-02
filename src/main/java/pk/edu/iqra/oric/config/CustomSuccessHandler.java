package pk.edu.iqra.oric.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
     
    @Override
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
  
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
  
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
     
    protected String determineTargetUrl(Authentication authentication) {
        String url="";
         
        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
         
        List<String> roles = new ArrayList<String>();
 
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }

        if (isUniversityAdmin(roles)) {
            url = "/universityAdmin/";
        }
        else if (isORICAdmin(roles)) {
            url = "/oricAdmin";
        } else {
            url="/accessDenied";
        }
 
        return url;
    }
  
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
     
    
    private boolean isORICAdmin(List<String> roles) {
        if (roles.contains("ROLE_UNIVERSITY_ADMIN")) {
            return true;
        }
        return false;
    }

    private boolean isUniversityAdmin(List<String> roles) {
        if (roles.contains("ROLE_UNIVERSITY_ADMIN")) {
            return true;
        }
        return false;
    }
 
}