package pk.edu.iqra.oric.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
     CustomSuccessHandler customSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        DelegatingPasswordEncoder delPasswordEncoder=  (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();
        BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();
    delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
    return delPasswordEncoder; 
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

/*    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//    	 auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }*/


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> {
                            try {
                                authz

                                        .mvcMatchers("/universityAdmin/**").hasAnyRole("UNIVERSITY_ADMIN")
                                        .mvcMatchers("/oricAdmin/**").hasAnyRole("UNIVERSITY_ADMIN")
                                        .mvcMatchers("/campusAdmin/**").hasAnyRole("UNIVERSITY_ADMIN","CAMPUS_ADMIN")
                                        .mvcMatchers("/data/**").hasAnyRole("UNIVERSITY_ADMIN","CAMPUS_ADMIN")
                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                        .antMatchers("/**").permitAll()
                                        .anyRequest().authenticated().
                                        and().exceptionHandling().accessDeniedPage("/accessDenied");
//                                        .and()
//                                        .formLogin().loginPage("/login").successHandler(customSuccessHandler)
//                                        .usernameParameter("username").passwordParameter("password")
//                                        .and()
//                                        .exceptionHandling().accessDeniedPage("/access_denied");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
    http.csrf().disable();
    http.cors().disable();
    http.formLogin().loginPage("/login").successHandler(customSuccessHandler).usernameParameter("username").passwordParameter("password");
    http.exceptionHandling().accessDeniedPage("/access_denied");
        return http.build();
    }

/*    @Override
    protected void configure(final HttpSecurity http) throws Exception {
      http.csrf().disable().authorizeRequests()
		.mvcMatchers("/sisgen/**").hasAnyRole("BLACKBOARD_ADMIN","ACCOUNTS")		
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .antMatchers("/**").permitAll()
        .and()
        .formLogin().loginPage("/login").successHandler(customSuccessHandler)
        .usernameParameter("username").passwordParameter("password")
        .and()
        .exceptionHandling().accessDeniedPage("/access_denied");
    }*/
    
//    @Configuration
//    @Order(1)                                                        
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            http.csrf().disable().authorizeRequests()
//            		.mvcMatchers("/sisgen/**").hasRole("BLACKBOARD_ADMIN")
//                    .mvcMatchers("/sales/**").hasRole("SALES_MANAGER")
//                    .mvcMatchers("/buyer/**").hasRole("SALES_MANAGER")
//                    .mvcMatchers("/bank/**").hasRole("SALES_MANAGER")
//                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                    .and()
//                    .formLogin().loginPage("/login122").successHandler(customSuccessHandler)
//                    .usernameParameter("username").passwordParameter("password")
//                    .and()
//                    .exceptionHandling().accessDeniedPage("/access_denied");
//        }
//    }

/*    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**");
    }*/
/*    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }*/
}
