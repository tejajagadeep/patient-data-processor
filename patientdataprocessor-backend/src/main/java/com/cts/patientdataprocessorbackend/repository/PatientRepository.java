package com.cts.patientdataprocessorbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessorbackend.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	public Patient findByContactNumber(Long contactNumber);
	
}

