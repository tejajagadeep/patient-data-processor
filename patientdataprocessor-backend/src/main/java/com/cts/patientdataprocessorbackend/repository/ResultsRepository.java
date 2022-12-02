package com.cts.patientdataprocessorbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessorbackend.model.Results;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long>{

	public Results findByContactNumber(Long contactNumber);
}
