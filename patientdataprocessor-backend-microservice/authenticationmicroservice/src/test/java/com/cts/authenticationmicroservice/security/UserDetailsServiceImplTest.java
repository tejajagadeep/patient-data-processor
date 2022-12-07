package com.cts.authenticationmicroservice.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cts.authenticationmicroservice.model.UserRole;
import com.cts.authenticationmicroservice.repository.UserRoleRepository;

@SpringBootTest
class UserDetailsServiceImplTest {
	
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Mock
	private UserRoleRepository userRoleRepository;

	@Test
	void testLoadUserByUsername() {
		UserRole role = new UserRole();
		
		role.setUserName("thunder");
		role.setPassword("thunder");
		role.setRole("DOCTOR");
		
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(role);
		UserDetailsImpl userDetails = new UserDetailsImpl(role);
		UserDetails user = new UserDetailsImpl(role);
		assertEquals(userDetails.getUsername(), userDetailsServiceImpl.loadUserByUsername("thunder").getUsername());
	}
	
	@Test
	void testLoadUserByUsernameException() {
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(null);
		assertThrows(UsernameNotFoundException.class, ()->userDetailsServiceImpl.loadUserByUsername("thunder"));
	}

}
