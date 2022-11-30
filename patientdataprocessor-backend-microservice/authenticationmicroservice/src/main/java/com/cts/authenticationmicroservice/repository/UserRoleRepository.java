package com.cts.authenticationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.authenticationmicroservice.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

	public UserRole findByUserName(String userName);
}
