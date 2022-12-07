package com.cts.patientdataprocessorbackend.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cts.patientdataprocessorbackend.model.User;
import com.cts.patientdataprocessorbackend.repository.UserRepository;

@SpringBootTest
class UserDetailsServiceImplTest {
	
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Mock
	private UserRepository userRoleRepository;
	
	@Mock
	User userRole;

	@Test
	void testLoadUserByUsername() {
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("DOCTOR");
		
		User role = new User();
		
		role.setUserName("thunder");
		role.setPassword("thunder");
		role.setRole("DOCTOR");
		
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(role);
		UserDetailsImpl userDetails = new UserDetailsImpl(role);
		UserDetails user = new UserDetailsImpl(role);
		assertEquals(userDetails.getUsername(), userDetailsServiceImpl.loadUserByUsername("thunder").getUsername());
		assertEquals(userDetails.getPassword(), userDetailsServiceImpl.loadUserByUsername("thunder").getPassword());
		assertEquals(userDetails.getAuthorities(), userDetailsServiceImpl.loadUserByUsername("thunder").getAuthorities());
		assertEquals(userDetails.isAccountNonExpired(), userDetailsServiceImpl.loadUserByUsername("thunder").isAccountNonExpired());
		assertEquals(userDetails.isAccountNonLocked(), userDetailsServiceImpl.loadUserByUsername("thunder").isAccountNonLocked());
		assertEquals(userDetails.isCredentialsNonExpired(), userDetailsServiceImpl.loadUserByUsername("thunder").isCredentialsNonExpired());
		assertEquals(userDetails.isEnabled(), userDetailsServiceImpl.loadUserByUsername("thunder").isEnabled());
		assertEquals(userDetails.getUserDetails().getPassword(), userDetailsServiceImpl.loadUserByUsername("thunder").getPassword());
	}
	
	@Test
	void testLoadUserByUsernameException() {
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("DOCTOR");
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(null);
		UserDetailsImpl userDetails = new UserDetailsImpl(userRole);
		assertThrows(UsernameNotFoundException.class, ()->userDetailsServiceImpl.loadUserByUsername("thunder"));
	}

}