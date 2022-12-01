package com.cts.patientdataprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessor.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	public Patient findByContactNumber(Long contactNumber);
	
}
