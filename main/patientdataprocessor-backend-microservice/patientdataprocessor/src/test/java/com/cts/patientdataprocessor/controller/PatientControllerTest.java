package com.cts.patientdataprocessor.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.cts.patientdataprocessor.model.Patient;
import com.cts.patientdataprocessor.repository.PatientRepository;
import com.cts.patientdataprocessor.servcie.PatientService;

@SpringBootTest
class PatientControllerTest {

	@InjectMocks
	PatientController patientController;

	@Mock
	PatientService patientService;
	

	@Mock
	PatientRepository patientRepository;

	private String datedob = "1999/05/28";
	private Date dob = new Date(datedob);

	private String datevisited = "1999/05/28";
	private Date visited = new Date(datevisited);

	private String datetreatmentstart = "1999/05/28";
	private Date treatmentstart = new Date(datevisited);

	private String datetreatmentend = "1999/05/28";
	private Date treatmentend = new Date(datevisited);

	@Test
	void testGetAllPatients() {
		Patient patient = new Patient();
		patient.setContactNumber(7894561230L);
		patient.setAddress("hyderabad");
		patient.setFirstName("Rakel");
		patient.setLastName("Ramesh");
		patient.setGender("Male");
		patient.setDateOfBirth(dob);
		patient.setMaritalStatus("single");
		patient.setEmergencyContactNumber(7894561231L);
		patient.setEmail("ramesh@gmail.com");
		patient.setBloodGroup("O+");
		patient.setDisease("High BP");
		patient.setDiagnosis("");
		patient.setPreviousDiagnosis("");
		patient.setDateVisited(visited);
		patient.setTreatmentStartDate(treatmentstart);
		patient.setTreatmentEndDate(treatmentend);
		patient.setPrescription("Diuretics");
		patient.setHeight("170cms");
		patient.setWeight("75kgs");

		List<Patient> patientresult = new ArrayList<>();

		patientresult.add(patient);
		when(patientService.getAllPatients()).thenReturn(patientresult);

		ResponseEntity<List<Patient>> response = patientController.getAllPatients();

		assertEquals(HttpStatus.OK, response.getStatusCode());

//		assertEquals(1,  patientService.getAllPatients().size() );
	}

	@Test
	void testGetByContactNumber() {
		Patient patient = new Patient();
		patient.setContactNumber(7894561230L);
		patient.setAddress("hyderabad");
		patient.setFirstName("Rakel");
		patient.setLastName("Ramesh");
		patient.setGender("Male");
		patient.setDateOfBirth(dob);
		patient.setMaritalStatus("single");
		patient.setEmergencyContactNumber(7894561231L);
		patient.setEmail("ramesh@gmail.com");
		patient.setBloodGroup("O+");
		patient.setDisease("High BP");
		patient.setDiagnosis("");
		patient.setPreviousDiagnosis("");
		patient.setDateVisited(visited);
		patient.setTreatmentStartDate(treatmentstart);
		patient.setTreatmentEndDate(treatmentend);
		patient.setPrescription("Diuretics");
		patient.setHeight("170cms");
		patient.setWeight("75kgs");

		when(patientService.getByContactNumber(7894561230L)).thenReturn(patient);

		ResponseEntity<Patient> response = patientController.getByContactNumber(7894561230L);

		assertEquals(HttpStatus.OK, response.getStatusCode());

//		assertEquals(7894561230L, patientService.getByContactNumber(7894561230L).getContactNumber());
	}

	@Test
	void testRegisterPatient() {
		Patient patient = new Patient();
		patient.setContactNumber(7894561230L);
		patient.setAddress("hyderabad");
		patient.setFirstName("Rakel");
		patient.setLastName("Ramesh");
		patient.setGender("Male");
		patient.setDateOfBirth(dob);
		patient.setMaritalStatus("single");
		patient.setEmergencyContactNumber(7894561231L);
		patient.setEmail("ramesh@gmail.com");
		patient.setBloodGroup("O+");
		patient.setDisease("High BP");
		patient.setDiagnosis("");
		patient.setPreviousDiagnosis("");
		patient.setDateVisited(visited);
		patient.setTreatmentStartDate(treatmentstart);
		patient.setTreatmentEndDate(treatmentend);
		patient.setPrescription("Diuretics");
		patient.setHeight("170cms");
		patient.setWeight("75kgs");

		when(patientService.registerPatient(patient)).thenReturn(patient);

		ResponseEntity<Patient> response = patientController.registerPatient(patient);

		assertEquals(HttpStatus.OK, response.getStatusCode());

//		assertEquals(patient, patientService.registerPatient(patient));

	}

	@Test
	void testUpdatePatientDetails() {
		
		Patient patient = new Patient();
		patient.setContactNumber(7894561230L);
		patient.setAddress("hyderabad");
		patient.setFirstName("Rakel");
		patient.setLastName("Ramesh");
		patient.setGender("Male");
		patient.setDateOfBirth(dob);
		patient.setMaritalStatus("single");
		patient.setEmergencyContactNumber(7894561231L);
		patient.setEmail("ramesh@gmail.com");
		patient.setBloodGroup("O+");
		patient.setDisease("High BP");
		patient.setDiagnosis("");
		patient.setPreviousDiagnosis("");
		patient.setDateVisited(visited);
		patient.setTreatmentStartDate(treatmentstart);
		patient.setTreatmentEndDate(treatmentend);
		patient.setPrescription("Diuretics");
		patient.setHeight("170cms");
		patient.setWeight("75kgs");

		when(patientService.updatePatientDetails(7894561230L,patient )).thenReturn(patient);
		when(patientRepository.save(patient)).thenReturn(patient);
		ResponseEntity<Patient> response = patientController.updatePatientDetails(7894561230L,patient);
		assertEquals(HttpStatus.OK, response.getStatusCode());

//		assertEquals(patient, patientController.updatePatientDetails(7894561230L,patient));
	}

	@Test
	void testDeletePatient() {
		Patient patient = new Patient();
		patient.setContactNumber(7894561230L);
		patient.setAddress("hyderabad");
		patient.setFirstName("Rakel");
		patient.setLastName("Ramesh");
		patient.setGender("Male");
		patient.setDateOfBirth(dob);
		patient.setMaritalStatus("single");
		patient.setEmergencyContactNumber(7894561231L);
		patient.setEmail("ramesh@gmail.com");
		patient.setBloodGroup("O+");
		patient.setDisease("High BP");
		patient.setDiagnosis("");
		patient.setPreviousDiagnosis("");
		patient.setDateVisited(visited);
		patient.setTreatmentStartDate(treatmentstart);
		patient.setTreatmentEndDate(treatmentend);
		patient.setPrescription("Diuretics");
		patient.setHeight("170cms");
		patient.setWeight("75kgs");

		List<Patient> patientresult = new ArrayList<>();

		patientresult.add(patient);

		when(patientService.deletePatient(7894561230L)).thenReturn(patientresult);
		
		ResponseEntity<List<Patient>> response = patientController.deletePatient(7894561230L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		
//		patientService.deletePatient(7894561230L);
//		verify(patientService, times(1)).deleteById(7894561230L);
	}

}
