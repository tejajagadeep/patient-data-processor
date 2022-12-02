package com.cts.patientdataprocessorbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessorbackend.model.Results;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Integer>{

	public List<Results> findByContactNumber(Long contactNumber);
}
