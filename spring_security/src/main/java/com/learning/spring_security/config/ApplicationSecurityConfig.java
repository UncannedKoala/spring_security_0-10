package com.learning.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {

	/**
	 * Providing a UserDetailService having adding a Single User(UserName with
	 * associated password and authorities for this User)
	 * 
	 * @return
	 */
	@Bean
	UserDetailsService usrDetailSrvc() {
		var user = User.withUsername("admin").password("password").authorities("read").build();
		return new InMemoryUserDetailsManager(user);
	}

	/**
	 * Providing a Password Encoder
	 * <li>This PasswordEncoder is provided for legacy and testing purposes only and
	 * is not considered secure.A password encoder that does nothing. Useful for
	 * testing where working with plain text passwords may be preferred.</li>
	 * 
	 * @return
	 */
	@Bean
	PasswordEncoder pwdEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/**
	 * We are using {@code AbstractRequestMatcherRegistry.anyRequest()} to indicate that we
	 * want to apply this restriction/rule to any of the incoming HTTP requests,
	 * since we have not provided any URLPattern, it will take all the incoming
	 * HTTPRequests into consideration.
	 * 
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.httpBasic(Customizer.withDefaults());
		httpSecurity.authorizeHttpRequests(c -> c.anyRequest().authenticated());

		return httpSecurity.build();
	}
}
