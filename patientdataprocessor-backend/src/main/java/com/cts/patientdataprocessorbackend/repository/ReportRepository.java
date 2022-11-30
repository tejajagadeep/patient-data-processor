package com.cts.patientdataprocessorbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.patientdataprocessorbackend.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

}
