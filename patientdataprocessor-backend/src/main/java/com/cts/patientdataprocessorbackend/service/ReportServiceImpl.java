package com.cts.patientdataprocessorbackend.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessorbackend.model.Patient;
import com.cts.patientdataprocessorbackend.model.Report;
import com.cts.patientdataprocessorbackend.repository.PatientRepository;
import com.cts.patientdataprocessorbackend.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Report> getAllReports() {
		return reportRepository.findAll();
	}

	@Override
	public Report saveReport(Long contactNumber,Report report) {

		Patient patient = patientRepository.findByContactNumber(contactNumber);

		if (patient == null) {

//			log.warn("Patient does'nt exist " + contactNumber);
			throw new NoSuchElementException("Patient doesn't exist");

		} 
		report.setDay(new Date());
		patient.addReports(report);

//		patientRepository.save(patient);
		return reportRepository.save(report);
	}

	@Override
	public List<Report> delete(int id) {
		Report patient = reportRepository.findById(id).get();

		if (patient == null) {

//			log.warn("Patient does'nt exist " + contactNumber);
			throw new NoSuchElementException("Patient doesn't exist");

		} 
		
		reportRepository.deleteById(id);
		
		return reportRepository.findAll();
	}

}
