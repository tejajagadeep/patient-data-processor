package com.cts.authenticationmicroservice.jwt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtResponseTest {
	
	@InjectMocks
	JwtResponse jwtResponse;

	@Test
	void testGetToken() {
	}

}
