package com.cts.patientdataprocessorreport.service;

import java.util.List;

import com.cts.patientdataprocessorreport.model.Report;

public interface ReportService {
	
	List<Report> getAllReports();
	
	Report saveReport(Report report);

	List<Report> delete(int id);

	List<Report> getAllByContactNumber(Long contactNumber);

	List<Report> deleteAllByContactNumber(Long contactNumber);
	
}
