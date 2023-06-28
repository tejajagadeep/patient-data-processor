package com.cts.authenticationmicroservice.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.authenticationmicroservice.model.UserRole;
import com.cts.authenticationmicroservice.service.UserRoleService;

@SpringBootTest
class UserRoleControllerTest {
	
	@InjectMocks
	UserRoleController userRoleController;
	
	@Mock
	UserRoleService userRoleService;
	
	@Mock
	UserRole userRole;

	@Test
	void testGetUserByUserName() {
		
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("ADMIN");
		
		when(userRoleService.getUserByUserName("thunder")).thenReturn(userRole);
		ResponseEntity<UserRole> response = userRoleController.getUserByUserName("thunder");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
