package com.cts.patientdataprocessorbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.patientdataprocessorbackend.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByUserName(String userName);
}
