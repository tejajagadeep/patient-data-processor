package com.cts.authenticationmicroservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cts.authenticationmicroservice.jwt.JwtRequest;
import com.cts.authenticationmicroservice.jwt.JwtResponse;
import com.cts.authenticationmicroservice.jwt.JwtTokenUtil;
import com.cts.authenticationmicroservice.security.UserDetailsServiceImpl;

@SpringBootTest
class JwtAuthenticationControllerTest {
	
	@InjectMocks
	JwtAuthenticationController jwtAuthenticationController;

	@Mock
	AuthenticationManager authenticationManager;
	
	@Mock
	JwtTokenUtil jwtTokenUtil;
	
	@Mock
	UserDetailsServiceImpl  userDetailsServiceImpl;
	
	@Mock
	UserDetails userDetails;
	
	@Test
	void testCreateAuthenticationToken() throws Exception {
		
		JwtRequest authenticationRequest = new JwtRequest();
		
		authenticationRequest.setUsername("thunder");
		authenticationRequest.setPassword("thunder");
		
		UserDetails user = null;
		
		JwtRequest jwtRequest = new JwtRequest("thunder","thunder");
				
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("thunder", "thunder"))).thenReturn(null);
		
		when(userDetailsServiceImpl.loadUserByUsername(authenticationRequest.getUsername())).thenReturn(userDetails);
		
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE2NzAzMjg4MjcsImlhdCI6MTY3MDMxMDgyN30.UOfVU9cd6FFqdWpMsMpPveprzEVWcxqF4q6oMosJ-sX762cB9On2ohkqMHIGFbdLFP7DmlULue3CDM00XVQFFA");
		
		ResponseEntity<?> resposne = jwtAuthenticationController.createAuthenticationToken(jwtRequest);
		
		assertEquals(HttpStatus.OK, resposne.getStatusCode());
	}
	
	@Test
	void testCreateAuthenticationTokenException() throws Exception {
		
		JwtRequest authenticationRequest = new JwtRequest();
		
		authenticationRequest.setUsername("thunder");
		authenticationRequest.setPassword("thunder");
		
		UserDetails user = null;
		
		JwtRequest jwtRequest = new JwtRequest("thunder","thun1der");
				
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("thunder", "thun1der"))).thenReturn(null);
		
		when(userDetailsServiceImpl.loadUserByUsername(authenticationRequest.getUsername())).thenReturn(userDetails);
		
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE2NzAzMjg4MjcsImlhdCI6MTY3MDMxMDgyN30.UOfVU9cd6FFqdWpMsMpPveprzEVWcxqF4q6oMosJ-sX762cB9On2ohkqMHIGFbdLFP7DmlULue3CDM00XVQFFA");
		
		ResponseEntity<?> resposne = jwtAuthenticationController.createAuthenticationToken(jwtRequest);
		
		assertEquals(HttpStatus.OK, resposne.getStatusCode());
	}
//	void authenticateTest(String username, String password) {
//		
//		authenticationManager.authenticate(authentication)
//		
//	}

}
