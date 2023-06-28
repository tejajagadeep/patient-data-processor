package com.cts.authenticationmicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRoleTest {
	
	@InjectMocks
	UserRole userRole;

	@Test
	void testGetUserName() {
		userRole.setUserName("thunder");
		assertEquals("thunder",userRole.getUserName());
	}

	@Test
	void testGetPassword() {
		userRole.setPassword("thunder");
		assertEquals("thunder",userRole.getPassword());
	}

	@Test
	void testGetRole() {
		userRole.setRole("DOCTOR");
		assertEquals("DOCTOR",userRole.getRole());
	}

}
