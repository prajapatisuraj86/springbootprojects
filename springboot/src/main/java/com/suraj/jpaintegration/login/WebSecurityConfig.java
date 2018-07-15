package com.suraj.jpaintegration.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests().anyRequest().authenticated().and().csrf().disable();
	}
	
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.ldapAuthentication()
        .contextSource().url("ldap://localhost:10389/dc=example,dc=com")
        .managerDn("uid=admin,ou=system").managerPassword("secret")
        .and()
        .userSearchBase("ou=users")
        .userSearchFilter("(cn={0})");
	}

}
