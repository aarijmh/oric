package pk.edu.iqra.oric.config;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { SecurityConfig.class };
   }
 
   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] {WebConfigurer.class };
   }
 
   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }

   @Override
   public void onStartup(ServletContext sc) {

       AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
       root.register(SecurityConfig.class);

       sc.addListener(new ContextLoaderListener(root));

       sc.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
         .addMappingForUrlPatterns(null, false, "/*");
   }
}