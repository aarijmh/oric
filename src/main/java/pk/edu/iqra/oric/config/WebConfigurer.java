package pk.edu.iqra.oric.config;

import org.springframework.context.annotation.*;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import pk.edu.iqra.oric.interceptors.CampusAdminInterceptor;
import pk.edu.iqra.oric.interceptors.OricInterceptor;
import pk.edu.iqra.oric.interceptors.RoleInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "pk.edu.iqra.oric" })
@PropertySource("classpath:application.properties")
@EnableSpringDataWebSupport
@EnableWebSecurity
public class WebConfigurer implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/static");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("/webjars/");
	}

    
	@Bean
	public SpringResourceTemplateResolver thymeleafTemplateResolver() {
		SpringResourceTemplateResolver templateResolver
				= new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		templateResolver.setCacheable(false);
		return templateResolver;
	}
	
    @Bean
    public SpringTemplateEngine templateEngine() {

        var templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        templateEngine.addDialect(new SpringSecurityDialect()); 
        return templateEngine;
    }

    @Bean
    public ViewResolver viewResolver() {

        var viewResolver = new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }

	@Bean
	public OricInterceptor oricInterceptor() {
		return new OricInterceptor();
	}

	@Bean
	public CampusAdminInterceptor campusAdminInterceptor() {
		return new CampusAdminInterceptor();
	}

	@Bean
	public RoleInterceptor roleInterceptor() {
		return new RoleInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(oricInterceptor()).addPathPatterns("/oricAdmin/**");
		registry.addInterceptor(campusAdminInterceptor()).addPathPatterns("/campusAdmin/**");
		registry.addInterceptor(roleInterceptor()).addPathPatterns("/universityAdmin/**","/campusAdmin/**","/oricAdmin/**");
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(104857600);// 5MB

		// You may also set other available properties.

		return resolver;
	}

}