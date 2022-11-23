//package com.cts.patientdataprocessorbackend.getAdminDB;
//package com.cts.patientdataprocessorbackend.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cts.patientdataprocessorbackend.model.User;
//import com.cts.patientdataprocessorbackend.service.UserService;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class UserController {
//
//	@Autowired
//	UserService userService;
//	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
//	@GetMapping("/getAllUsers")
//	public ResponseEntity<List<User>> getAllUsers(){
//		
//		return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
//	}
//}
