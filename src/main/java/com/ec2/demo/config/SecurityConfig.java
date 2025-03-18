package com.ec2.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disable CSRF protection for stateless APIs
				.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated() // Require authentication for
																							// any request
				).httpBasic() // Use HTTP Basic authentication
				.and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use
																													// stateless
																													// session
																													// management
				);

		return http.build(); // Build the SecurityFilterChain
	}

//	@Bean
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("dinesh").password("{noop}dinesh").roles("USER").and()
//				.withUser("admin").password("{noop}admin").credentialsExpired(true).accountExpired(true)
//				.accountLocked(true).authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES").roles("ADMIN");
//	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder().username("dinesh").password("dinesh").roles("USER")
				.build();
		UserDetails userDetails2 = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(userDetails,userDetails2);
	}

}
