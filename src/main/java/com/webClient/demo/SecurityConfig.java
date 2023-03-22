package com.webClient.demo;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

	
	
	@Autowired
	DataSource ds;
	
	@Autowired
    UserRepository repo;
	
	@Autowired
	MyUserDetailsService serv;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.formLogin(form -> form.loginPage("/login")

		).authorizeHttpRequests().requestMatchers("/login").permitAll();
		http.authorizeHttpRequests().requestMatchers("/").permitAll();
		http.authorizeHttpRequests().requestMatchers("/home").authenticated();
		http.authenticationProvider(provider());
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
	}

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
	    JdbcUserDetailsManager mgr = new JdbcUserDetailsManager();
	    mgr.setDataSource(dataSource); // (1)
	    User u = new User(5,"Maddy",encoder().encode("567"));
     	repo.save(u);
	   
	    return mgr;
	}

	@Bean
	AuthenticationManager auth(AuthenticationConfiguration conf) throws Exception {
		
		return conf.getAuthenticationManager();
		
	}
	
	@Bean
	DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(serv);
		provider.setPasswordEncoder(encoder());
		return provider;
	}

	
	

}
