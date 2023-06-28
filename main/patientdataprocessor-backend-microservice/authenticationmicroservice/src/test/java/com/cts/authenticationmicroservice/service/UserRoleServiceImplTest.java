package com.cts.authenticationmicroservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.authenticationmicroservice.exception.IdAlredyExistsException;
import com.cts.authenticationmicroservice.model.UserRole;
import com.cts.authenticationmicroservice.repository.UserRoleRepository;

@SpringBootTest
class UserRoleServiceImplTest {
	
	@InjectMocks
	UserRoleServiceImpl userRoleServiceImpl;
	
	@Mock
	UserRoleRepository userRoleRepository;
	
	
	
	@Test
	void testGetUserByUserNameexists() {
		UserRole userRole = new UserRole();
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("ADMIN");
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(null);
		
		when(userRoleRepository.save(userRole)).thenReturn(userRole);
		assertEquals(userRole, userRoleServiceImpl.save(userRole));
	}
	
	@Test
	void testGetUserByUserNameexistsExcep() {
		UserRole userRole = new UserRole();
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("ADMIN");
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(userRole);
		
		assertThrows(IdAlredyExistsException.class,()-> userRoleServiceImpl.save(userRole));
	}

	@Test
	void testGetUserByUserName() {
		UserRole userRole = new UserRole();
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("ADMIN");
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(userRole);
		
		assertEquals(userRole, userRoleServiceImpl.getUserByUserName("thunder"));
	}

}
