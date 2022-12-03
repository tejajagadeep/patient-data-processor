package com.cts.patientdataprocessorreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.patientdataprocessorreport.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

	List<Report> findByContactNumber(Long contactNumber);
	
}
