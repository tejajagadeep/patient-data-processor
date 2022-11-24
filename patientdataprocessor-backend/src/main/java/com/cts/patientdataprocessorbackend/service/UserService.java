package com.cts.patientdataprocessorbackend.service;

import java.util.List;

import com.cts.patientdataprocessorbackend.model.User;

public interface UserService  {

	public List<User> getAllUser();

	public User getUserByUserName(String userName);

}
