package com.cts.patientdataprocessorbackend.service;

import java.util.List;

import com.cts.patientdataprocessorbackend.model.Patient;


public interface PatientService {
	
	List<Patient> getAllPatients();

	Patient getByContactNumber(Long contactNumber);

	Patient registerPatient(Patient patient);

	Patient updatePatientDetails(Long contactNumber, Patient patient);

	List<Patient> deletePatient(Long contactNumber);

}
