package com.cts.patientdataprocessor.service;

import java.util.List;

import com.cts.patientdataprocessor.model.Patient;

public interface PatientService {

	List<Patient> getAllPatients();

	Patient getByContactNumber(Long contactNumber);

	Patient registerPatient(Patient patient);

}
