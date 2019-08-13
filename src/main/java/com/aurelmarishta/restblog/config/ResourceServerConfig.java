package com.aurelmarishta.restblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //-- define URL patterns to enable OAuth2 security
        http
                .authorizeRequests()
                .antMatchers("/api").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/oauth/token").permitAll()
                .antMatchers("/api/swagger-ui.html").permitAll()
//                .and()
//                .requestMatchers().antMatchers("/api/**")
//                .and().authorizeRequests()
//                .antMatchers("/api/**").access("hasRole('ADMIN') or hasRole('USER')")
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
        ;
    }

}
