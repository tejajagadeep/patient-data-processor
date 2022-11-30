package com.cts.patientdataprocessorbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getAllReports")
	public List<Report> getAllReports(){
		return reportService.getAllReports();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PostMapping("/saveReport/{contactNumber}")
	public Report saveReport(@PathVariable Long contactNumber, @RequestBody Report report){
		return reportService.saveReport(contactNumber, report);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/id/{id}")
	public List<Report> delete(@PathVariable int id){
		return reportService.delete(id);
	}
}
