package com.cts.patientdataprocessorreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.patientdataprocessorreport.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

}
