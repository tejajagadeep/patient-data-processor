package com.cts.patientdataprocessorreport.service;

import java.util.List;

import com.cts.patientdataprocessorreport.model.Report;

public interface ReportService {
	
	List<Report> getAllReports();
	
	Report saveReport(Long contactNumber, Report report);

	List<Report> delete(int id);
	
}
