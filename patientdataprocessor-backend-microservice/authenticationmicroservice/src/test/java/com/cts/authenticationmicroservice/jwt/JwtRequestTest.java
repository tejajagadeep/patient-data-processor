package com.cts.authenticationmicroservice.jwt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.authenticationmicroservice.AuthenticationmicroserviceApplication;

@SpringBootTest
class JwtRequestTest {
	
	@InjectMocks
	JwtRequest jwtRequest;
	
	Logger log = LoggerFactory.getLogger(AuthenticationmicroserviceApplication.class);
	
	JwtRequest jet = new JwtRequest("","",log);

	@Test
	void testJwtRequest() {
	}

	@Test
	void testGetUsername() {
		jwtRequest.setUsername("thunder");
		assertEquals("thunder", jwtRequest.getUsername());
	}

	@Test
	void testGetPassword() {
		jwtRequest.setPassword("thunder");
		assertEquals("thunder", jwtRequest.getPassword());
	}

	@Test
	void testGetSerialversionuid() {
	}

	@Test
	void testJwtRequestStringStringLogger() {
	}

}
