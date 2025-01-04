package com.learning.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ApplicationSecurityConfig {

	/**
	 * Providing a UserDetailService having adding a Single User(UserName with associated password and authorities for this User)
	 * <li>This PasswordEncoder is provided for legacy and testing purposes only and is not considered secure.A password encoder that does nothing. Useful for testing where working with plain textpasswords may be preferred.</li>
	 * @return
	 */
	@Bean
	UserDetailsService usrDetailSrvc(){
		var user = User.withUsername("admin").password("password").authorities("read").build();
		return new InMemoryUserDetailsManager(user);
	}
	
	/**
	 * Providing a Password Encoder
	 * <li>This PasswordEncoder is provided for legacy and testing purposes only and isnot considered secure.A password encoder that does nothing. Useful for testing where working with plain textpasswords may be preferred.</li>
	 * @return
	 */
	@Bean
	PasswordEncoder pwdEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
}
