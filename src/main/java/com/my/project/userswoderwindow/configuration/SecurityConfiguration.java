package com.my.project.userswoderwindow.configuration;

import com.my.project.userswoderwindow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity config) throws Exception {
        config.authorizeRequests()
                .antMatchers("/api/main").permitAll()
                .antMatchers("/api/main/editor").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/api/main/login").defaultSuccessUrl("/api/main/login").permitAll()
                .and()
                .logout().logoutUrl("/api/main/logout").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("admin").password("password").roles("ADMIN");
    }
}
