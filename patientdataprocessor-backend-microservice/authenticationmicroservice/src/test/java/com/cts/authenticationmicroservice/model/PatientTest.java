package com.cts.authenticationmicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientTest {

	
	@InjectMocks
	Patient patient ;
	
	private String datedob = "1999/05/28";
	private Date dob = new Date(datedob);

	private String datevisited = "1999/05/28";
	private Date visited = new Date(datevisited);

	private String datetreatmentstart = "1999/05/28";
	private Date treatmentstart = new Date(datevisited);

	private String datetreatmentend = "1999/05/28";
	private Date treatmentend = new Date(datevisited);

	




	
	@Test
	void testGetterSetterContactNumber() {
		 
		 patient.setContactNumber(7894561230L);
		assertEquals(7894561230L, patient.getContactNumber());
	}

	@Test
	void testGetterSetterAddress() {
		patient.setAddress("hyderabad");
		assertEquals("hyderabad", patient.getAddress());
	}

	@Test
	void testGetterSetterFirstName() {

		patient.setFirstName("Rakel");
		assertEquals("Rakel", patient.getFirstName());
		
	}

	@Test
	void testGetterSetterLastName() {
		patient.setLastName("Ramesh");
		assertEquals("Ramesh", patient.getLastName());
		
	}

	@Test
	void testGetterSetterGender() {
		patient.setGender("Male");
		assertEquals("Male", patient.getGender());
		
	}

	@Test
	void testGetterSetterDateOfBirth() {
		patient.setDateOfBirth(dob);
		assertEquals(dob, patient.getDateOfBirth());
	}

	@Test
	void testGetterSetterMaritalStatus() {

		patient.setMaritalStatus("single");
		assertEquals("single", patient.getMaritalStatus());
	}

	@Test
	void testGetterSetterEmergencyContactNumber() {

		patient.setEmergencyContactNumber(7894561231L);
		assertEquals(7894561231L, patient.getEmergencyContactNumber());
		
	}

	@Test
	void testGetterSetterEmail() {
		patient.setEmail("ramesh@gmail.com");
		assertEquals("ramesh@gmail.com", patient.getEmail());
	}

	@Test
	void testGetterSetterBloodGroup() {

		patient.setBloodGroup("O+");
		assertEquals("O+", patient.getBloodGroup());
	}

	@Test
	void testGetterSetterDisease() {

		patient.setDisease("High BP");
		assertEquals("High BP", patient.getDisease());
	}

	@Test
	void testGetterSetterDiagnosis() {
		
		patient.setDiagnosis("");
		assertEquals("", patient.getDiagnosis());
		
	}

	@Test
	void testGetterSetterPreviousDiagnosis() {

		patient.setPreviousDiagnosis("");
		assertEquals("", patient.getPreviousDiagnosis());
		
	}

	@Test
	void testGetterSetterDateVisited() {

		patient.setDateVisited(visited);
		assertEquals(visited, patient.getDateVisited());
	}

	@Test
	void testGetterSetterTreatmentStartDate() {
		patient.setTreatmentStartDate(treatmentstart);
		assertEquals(treatmentstart, patient.getTreatmentStartDate());
		
	}

	@Test
	void testGetterSetterTreatmentEndDate() {

		patient.setTreatmentEndDate(treatmentend);
		assertEquals(treatmentend, patient.getTreatmentEndDate());
		
	}

	@Test
	void testGetterSetterPrescription() {
		
		patient.setPrescription("Diuretics");
		assertEquals("Diuretics", patient.getPrescription());
		
	}

	@Test
	void testGetterSetterHeight() {

		patient.setHeight("170cms");
		assertEquals("170cms", patient.getHeight());
		
	}

	@Test
	void testGetterSetterWeight() {
	
		patient.setWeight("75kgs");
		assertEquals("75kgs", patient.getWeight());
		
	}

}
