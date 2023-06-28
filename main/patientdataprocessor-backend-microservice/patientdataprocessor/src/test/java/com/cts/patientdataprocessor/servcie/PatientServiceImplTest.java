package com.cts.patientdataprocessor.servcie;

import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.patientdataprocessor.exception.IdAlredyExistsException;
import com.cts.patientdataprocessor.model.Patient;
import com.cts.patientdataprocessor.repository.PatientRepository;

@SpringBootTest
class PatientServiceImplTest {

	@InjectMocks
	PatientServiceImpl patientServiceimpl;

	@Mock
	PatientRepository patientRepository;

	@Mock
	Patient patient;

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

		when(patientServiceimpl.getAllPatients()).thenReturn(patientresult);

		assertEquals(1, patientRepository.findAll().size());

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

		when(patientRepository.findByContactNumber(7894561230L)).thenReturn(patient);

		assertEquals(7894561230L, patientServiceimpl.getByContactNumber(7894561230L).getContactNumber());

	}

	@Test
	void testGetByContactNumberThrowsexception() {
		
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
		
		when(patientRepository.findByContactNumber(7894561230L)).thenReturn(null);

//		assertThrows(NoSuchElementException.class, ()-> patientServiceimpl.getByContactNumber(7894561230L));
		assertThrows(NoSuchElementException.class, ()->patientServiceimpl.updatePatientDetails(7894561230L,patient));
		assertThrows(NoSuchElementException.class, ()->patientServiceimpl.deletePatient(7894561230L));
		
		
//		assertThrows(IdAlredyExistsException.class, ()->patientServiceimpl.registerPatient(patient));
	}
	
	
	@Test
	void testregisterPatientThrowsexception()
	{
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
		
		when(patientRepository.findByContactNumber(7894561230L)).thenReturn(patient);

		assertThrows(IdAlredyExistsException.class, ()->patientServiceimpl.registerPatient(patient));
	}
	
	@Test
	void testregisterPatientThrowsexception2()
	{
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
		
		when(patientRepository.findByContactNumber(7894561230L)).thenReturn(null);
		when(patientRepository.findByEmail("ramesh@gmail.com")).thenReturn(patient);
		assertThrows(IdAlredyExistsException.class, ()->patientServiceimpl.registerPatient(patient));
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

		when(patientRepository.save(patient)).thenReturn(patient);

		assertEquals(patient, patientServiceimpl.registerPatient(patient));
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

		when(patientRepository.findByContactNumber(7894561230L)).thenReturn(patient);
		when(patientRepository.save(patient)).thenReturn(patient);

		assertEquals(patient, patientServiceimpl.updatePatientDetails(7894561230L,patient));
	
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

		when(patientRepository.findByContactNumber(7894561230L)).thenReturn(patient);
		patientServiceimpl.deletePatient(7894561230L);
		verify(patientRepository, times(1)).deleteById(7894561230L);

	}

}
