package com.cts.patientdataprocessorbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.patientdataprocessorbackend.model.Report;
import com.cts.patientdataprocessorbackend.service.ReportService;

@RestController
@RequestMapping("/api/v1.0/report")
@CrossOrigin(origins="*")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/getAllReports")
	public List<Report> getAllReports(){
		return reportService.getAllReports();
	}
	
	@PostMapping("/saveReport/{contactNumber}")
	public Report saveReport(@PathVariable Long contactNumber, @RequestBody Report report){
		return reportService.saveReport(contactNumber, report);
	}
}
