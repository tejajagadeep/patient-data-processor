package com.cts.patientdataprocessorbackend.service;

import java.util.List;

import com.cts.patientdataprocessorbackend.model.Doctor;

public interface DoctorService {

	List<Doctor> retrieveAllDoctorDetails();
	
	Doctor doctorRegistration(Doctor doctor);

	Doctor retrieveDoctorDetailsById(String emailId);

}
