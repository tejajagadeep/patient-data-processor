package com.cts.patientdataprocessordoctor.service;

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

import com.cts.patientdataprocessordoctor.exception.IdAlredyExistsException;
import com.cts.patientdataprocessordoctor.model.Doctor;
import com.cts.patientdataprocessordoctor.repository.DoctorRespository;

@SpringBootTest
class DoctorServiceImplTest {
	
	@InjectMocks
	DoctorServiceImpl doctorServiceImpl;

	@Mock
	DoctorRespository doctorRespository;
	
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
		when(doctorRespository.findAll()).thenReturn(doctorList);
		assertEquals(1, doctorServiceImpl.retrieveAllDoctorDetails().size());
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
		
		when(doctorRespository.findByEmailId("thunder@gmail.com")).thenReturn(doctor);
		assertEquals(doctor, doctorServiceImpl.retrieveDoctorDetailsById("thunder@gmail.com"));
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
		
		when(doctorRespository.save(doctor)).thenReturn(doctor);
		assertEquals(doctor, doctorServiceImpl.doctorRegistration(doctor));
	}
	
	@Test
	void testDoctorRegistrationmailExcepton() {
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
		
		when(doctorRespository.findByEmailId("thunder@gmail.com")).thenReturn(doctor);
		assertThrows(IdAlredyExistsException.class, ()-> doctorServiceImpl.doctorRegistration(doctor));
	}
	
//	@Test
//	void testDoctorRegistrationNumberException() {
//		Doctor doctor = new Doctor();
//		doctor.setEmailId("thunder@gmail.com");
//		doctor.setPassword("password");
//		doctor.setContactNumber(7982516852L);
//		doctor.setFirstName("first");
//		doctor.setLastName("last");
//		Date date = new Date();
//		doctor.setDateOfBirth(date);
//		doctor.setGender("male");
//		doctor.setAddress("address");
//		
//		
//		when(doctorRespository.findByEmailId("thunder@gmail.com")).thenReturn(null);
//		when(doctorRespository.findByContactNumber(7982516852L)).thenReturn(doctor);
//		assertThrows(IdAlredyExistsException.class, ()-> doctorServiceImpl.doctorRegistration(doctor));
//	}

}
