package com.cts.authenticationmicroservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cts.authenticationmicroservice.AuthenticationmicroserviceApplication;
import com.cts.authenticationmicroservice.jwt.JwtAuthenticationEntryPoint;
import com.cts.authenticationmicroservice.jwt.JwtRequestFilter;
import com.cts.authenticationmicroservice.jwt.JwtTokenUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	Logger log = LoggerFactory.getLogger(AuthenticationmicroserviceApplication.class);

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		log.info("inside HttpSecurity configure of WebSecurityConfig");

		auth.inMemoryAuthentication().withUser("Sam").password(passwordEncoder().encode("aaaa")).roles("admin");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("inside HttpSecurity configure of WebSecurityConfig");
		http.authorizeRequests().antMatchers("/authenticate").permitAll().antMatchers(HttpMethod.GET).permitAll()

				.antMatchers(HttpMethod.POST, "/authenticate").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//				.antMatchers("/v3/api-docs/**").permitAll()
//				.antMatchers("/swagger-ui/**").permitAll()
//				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/swagger-ui.html").permitAll()
//				.antMatchers("/webjars/**").permitAll()
		;

		http.cors();
		http.csrf().disable();
//		.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated().and().httpBasic();
//		// dont authenticate this particular request
//		http.authorizeRequests().antMatchers("/authenticate").permitAll()
//		// all other requests need to be authenticated
//				.anyRequest().authenticated().and().
//				// make sure we use stateless session; session won't be used to
//				// store user's state.
		http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		super.configure(http);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("inside PasswordEncoder passwordEncoder of WebSecurityConfig");
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public PasswordEncoder encoder() {
		log.info("inside PasswordEncoder encoder BCryptPasswordEncoder of WebSecurityConfig");
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public DaoAuthenticationProvider authProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}

//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		return new UserDetailsServiceImpl();
//	}

	/*
	 * This is not recommended -- please use permitAll via
	 * HttpSecurity#authorizeHttpRequests instead.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		log.info("inside WebSecurity configure of WebSecurityConfig");
		web.ignoring().antMatchers("/h2-console/**").antMatchers("/swagger");
		web.ignoring().antMatchers("/authapp/login", "/h2-console/**", "/v2/api-docs", "/configuration/ui",
				"/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**",
				"/patient-data-processor/swagger");
	}

}