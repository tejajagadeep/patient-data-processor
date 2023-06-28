package com.cts.authenticationmicroservice.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.authenticationmicroservice.AuthenticationmicroserviceApplication;
import com.cts.authenticationmicroservice.model.UserRole;
import com.cts.authenticationmicroservice.repository.UserRoleRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRoleRepository userRoleRepository;
//	private RoleRepository userRoleRepository;

	Logger log = LoggerFactory.getLogger(AuthenticationmicroserviceApplication.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("inside loadUserByUserName UserDetails of UserDetailsServiceImpl" + username);
		UserRole user = userRoleRepository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException(username + " not found");
		}

		return new UserDetailsImpl(user);

	}

}
