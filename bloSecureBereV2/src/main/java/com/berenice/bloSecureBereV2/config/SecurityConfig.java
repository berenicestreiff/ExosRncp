package com.berenice.bloSecureBereV2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.berenice.bloSecureBereV2.utils.MyPasswordEncoder;

// @Configuration indique a spring que cette classe sert à configurer notre application
@Configuration
@EnableWebSecurity // activer la securité dédiée au web-app
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyPasswordEncoder myPasswordEncoder;


	public MyPasswordEncoder getMyPasswordEncoder() {
		return myPasswordEncoder;
	}

	public void setMyPasswordEncoder(MyPasswordEncoder myPasswordEncoder) {
		this.myPasswordEncoder = myPasswordEncoder;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**")
									.hasRole("ADMIN")
								.antMatchers("/user/**")
									.hasRole("USER")
								.antMatchers("/public/**", "/")
									.permitAll().and()
								.logout().logoutUrl("/logout")
										 .logoutSuccessUrl("/public/")
										 .and()
								.formLogin().and()
								.httpBasic();
	}


}
