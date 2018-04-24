package com.payit.security.config;

import com.payit.security.MyAuthenticationSuccessHandler;
import com.payit.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("com.payit.security")
@EnableJpaRepositories(basePackages = "com.payit.security.repository")
@EntityScan(basePackages = "com.payit.security.model")
@Import(EncoderConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

    private final RestAuthenticationEntryPoint authenticationEntryPoint;
    private final MyAuthenticationSuccessHandler authenticationSuccessHandler;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    @Autowired
    public SecurityConfig(RestAuthenticationEntryPoint authenticationEntryPoint,
                          MyAuthenticationSuccessHandler authenticationSuccessHandler,
                          @Qualifier("appUserDetailsService") UserDetailsService userDetailsService,
                          PasswordEncoder encoder) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                    .antMatchers("/api", "/api/**").authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .loginProcessingUrl("/login")
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                    .and()
                .logout()
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
                .authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
