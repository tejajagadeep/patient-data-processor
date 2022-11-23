package com.cts.patientdataprocessorbackend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.cts.patientdataprocessorbackend.PatientdataprocessorBackendApplication;
import com.cts.patientdataprocessorbackend.repository.UserRepository;


@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	UserRepository userRoleRepository;
	
	static Logger logg = LoggerFactory.getLogger(PatientdataprocessorBackendApplication.class);
	
	public boolean hasUserName(Authentication authentication, String username) {
		
		String userName = userRoleRepository.findByUserName(authentication.getName()).getUserName();
		logg.info("inside hasUsername: "+username+" of UserSecurity. userId: "+userName+". Authication: "+authentication + " repo authentication.getName()).getUserName() : "+userName);
		
		if(username == userName) {
			return true;
		}
		
		return false;
		
	}

//	public boolean hasUserId(Authentication authentication, Integer userId) {
//		
//		int userID = userRoleRepository.findByUserName(authentication.getName()).getUserId();
//		logg.info("inside hasUserId of UserSecurity. userId: "+userId+". Authication: "+authentication);
//		
//		if(userID == userId) {
//			return true;
//		}
//		
//		return false;
//		
//	}
	

}