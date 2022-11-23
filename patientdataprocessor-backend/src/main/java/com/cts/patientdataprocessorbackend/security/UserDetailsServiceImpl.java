package com.cts.patientdataprocessorbackend.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessorbackend.PatientdataprocessorBackendApplication;
import com.cts.patientdataprocessorbackend.model.User;
import com.cts.patientdataprocessorbackend.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRoleRepository;
//	private RoleRepository userRoleRepository;
	
	Logger log = LoggerFactory.getLogger(PatientdataprocessorBackendApplication.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		log.info("inside loadUserByUserName UserDetails of UserDetailsServiceImpl" + username);
		User user = userRoleRepository.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(username + " not found");
		} 
		
		return new UserDetailsImpl(user);
		
		
	}

}
