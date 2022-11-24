package com.cts.patientdataprocessorbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessorbackend.model.User;
import com.cts.patientdataprocessorbackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	
	
}
