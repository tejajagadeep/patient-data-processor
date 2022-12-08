package com.cts.patientdataprocessordoctor.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.patientdataprocessordoctor.model.Doctor;
import com.cts.patientdataprocessordoctor.service.DoctorService;

@SpringBootTest
class DoctorControllerTest {
	
	@InjectMocks
	DoctorController doctorController;
	
	@Mock
	DoctorService doctorService;
	
	@Test
	void testRetrieveAllDoctorDetails() {
		
		Doctor doctor = new Doctor();
		doctor.setEmailId("thunder@gmail.com");
		doctor.setPassword("password");
		doctor.setContactNumber(7982516852L);
		doctor.setFirstName("first");
		doctor.setLastName("last");
		Date date = new Date();
		doctor.setDateOfBirth(date);
		doctor.setGender("male");
		doctor.setAddress("address");
		
		List<Doctor> doctorList = new ArrayList<>();
		doctorList.add(doctor);
		when(doctorService.retrieveAllDoctorDetails()).thenReturn(doctorList);
		assertEquals(1, doctorController.retrieveAllDoctorDetails().getBody().size());
		ResponseEntity<List<Doctor>> response = doctorController.retrieveAllDoctorDetails();
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testRetrieveDoctorDetailsById() {
		Doctor doctor = new Doctor();
		doctor.setEmailId("thunder@gmail.com");
		doctor.setPassword("password");
		doctor.setContactNumber(7982516852L);
		doctor.setFirstName("first");
		doctor.setLastName("last");
		Date date = new Date();
		doctor.setDateOfBirth(date);
		doctor.setGender("male");
		doctor.setAddress("address");
		when(doctorService.retrieveDoctorDetailsById("thunder@gmail.com")).thenReturn(doctor);
		ResponseEntity<Doctor> response = doctorController.retrieveDoctorDetailsById("thunder@gmail.com");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testDoctorRegistration() {
		Doctor doctor = new Doctor();
		doctor.setEmailId("thunder@gmail.com");
		doctor.setPassword("password");
		doctor.setContactNumber(7982516852L);
		doctor.setFirstName("first");
		doctor.setLastName("last");
		Date date = new Date();
		doctor.setDateOfBirth(date);
		doctor.setGender("male");
		doctor.setAddress("address");
		when(doctorService.doctorRegistration(doctor)).thenReturn(doctor);
		ResponseEntity<Doctor> response = doctorController.doctorRegistration(doctor);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

}
