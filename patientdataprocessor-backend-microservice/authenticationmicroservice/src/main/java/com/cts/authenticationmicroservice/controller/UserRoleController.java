package com.cts.authenticationmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.model.UserRole;
import com.cts.authenticationmicroservice.service.UserRoleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/userrole")
public class UserRoleController {

	@Autowired
	UserRoleService userService;

//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
//	@GetMapping("/getAllUsers")
//	public ResponseEntity<List<UserRole>> getAllUsers() {
//
//		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
//	}

	@Operation(summary = "Retrieve ROLE", description = "Retrieve ROLE for access.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getUserByEmailId/{userName}")
	public ResponseEntity<UserRole> getUserByUserName(@PathVariable String userName) {

		return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);
	}
}
