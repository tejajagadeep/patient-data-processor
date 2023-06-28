package com.cts.patientdataprocessor.servcie;

import java.util.List;
import java.util.Set;

import com.cts.patientdataprocessor.dto.PatientDto;
import com.cts.patientdataprocessor.model.Patient;
//import com.cts.patientdataprocessor.model.Report;

public interface PatientService {

	List<Patient> getAllPatients();

	Patient getByContactNumber(Long contactNumber);

	PatientDto registerPatient(PatientDto patient);

	Patient updatePatientDetails(Long contactNumber, Patient patient);

	List<Patient> deletePatient(Long contactNumber);

//	Set<Report> getBypatientReports(Long contactNumber);
	
}
