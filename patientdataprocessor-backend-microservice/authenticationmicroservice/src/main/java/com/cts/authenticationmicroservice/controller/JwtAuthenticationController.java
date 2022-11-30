package com.cts.authenticationmicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.AuthenticationmicroserviceApplication;
import com.cts.authenticationmicroservice.jwt.JwtRequest;
import com.cts.authenticationmicroservice.jwt.JwtResponse;
import com.cts.authenticationmicroservice.jwt.JwtTokenUtil;
import com.cts.authenticationmicroservice.security.UserDetailsServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	Logger log = LoggerFactory.getLogger(AuthenticationmicroserviceApplication.class);

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		log.info("inside createAuthenticationToken of JwtAuthenticationController class");

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			log.info("inside authenticate of JwtAuthenticationController class");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			log.info("inside authenticate DisabledException of JwtAuthenticationController class");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			log.info("inside authenticate  DisabledException of JwtAuthenticationController class");
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
