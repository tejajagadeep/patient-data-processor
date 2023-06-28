package com.cts.patientdataprocessordoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessordoctor.model.Doctor;

@Repository
public interface DoctorRespository extends JpaRepository<Doctor, String>{

	public Doctor findByEmailId(String emailId);
	
	public Doctor findByContactNumber(Long contactNumber);
	
}
