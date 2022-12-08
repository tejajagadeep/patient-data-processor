package com.cts.authenticationmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.authenticationmicroservice.exception.IdAlredyExistsException;
import com.cts.authenticationmicroservice.model.UserRole;
import com.cts.authenticationmicroservice.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleRepository userRepository;

//	@Override
//	public List<UserRole> getAllUser() {
//		return userRepository.findAll();
//	}
	
	@Override
	public UserRole save(UserRole userRole) {
		UserRole u = userRepository.findByUserName(userRole.getUserName());
		if (u!= null) {
			throw new IdAlredyExistsException("Email Id Already Exist");
		}
		
		return userRepository.save(userRole);
	}

	@Override
	public UserRole getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
