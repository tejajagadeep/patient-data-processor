package com.cts.patientdataprocessordoctor.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DoctorTest {

	@InjectMocks
	Doctor doctor;
	
	@Test
	void testGetEmailId() {
		doctor.setEmailId("thunder@gmail.com");
		assertEquals("thunder@gmail.com", doctor.getEmailId());
	}

	@Test
	void testGetPassword() {
		doctor.setPassword("password");
		assertEquals("password", doctor.getPassword());
	}

	@Test
	void testGetContactNumber() {
		doctor.setContactNumber(7982516852L);
		assertEquals(7982516852L, doctor.getContactNumber());
	}

	@Test
	void testGetFirstName() {
		doctor.setFirstName("first");
		assertEquals("first", doctor.getFirstName());
	}

	@Test
	void testGetLastName() {
		doctor.setLastName("last");
		assertEquals("last", doctor.getLastName());
	}

	@Test
	void testGetDateOfBirth() {
		Date date = new Date();
		doctor.setDateOfBirth(date);
		assertEquals(date, doctor.getDateOfBirth());
	}

	@Test
	void testGetGender() {
		doctor.setGender("male");
		assertEquals("male", doctor.getGender());
	}

	@Test
	void testGetAddress() {
		doctor.setAddress("address");
		assertEquals("address", doctor.getAddress());
	}

}
