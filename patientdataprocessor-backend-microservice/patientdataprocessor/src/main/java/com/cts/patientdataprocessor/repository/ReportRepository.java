package com.cts.patientdataprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessor.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

}
