package com.cts.patientdataprocessorbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessorbackend.model.Doctor;

@Repository
public interface DoctorRespository extends JpaRepository<Doctor, String>{

	public Doctor findByEmailId(String emailId);
	
}
