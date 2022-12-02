package com.cts.patientdataprocessordoctor.service;

import java.util.List;

import com.cts.patientdataprocessordoctor.model.Doctor;


public interface DoctorService {

	List<Doctor> retrieveAllDoctorDetails();
	
	Doctor doctorRegistration(Doctor doctor);

	Doctor retrieveDoctorDetailsById(String emailId);

}
