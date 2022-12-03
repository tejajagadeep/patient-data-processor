package com.cts.patientdataprocessorreport.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessorreport.model.Report;
import com.cts.patientdataprocessorreport.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportRepository reportRepository;
	
//	@Autowired
//	private PatientRepository patientRepository;

	@Override
	public List<Report> getAllReports() {
		return reportRepository.findAll();
	}

	@Override
	public Report saveReport(Report report) {

//		Patient patient = patientRepository.findByContactNumber(contactNumber);

//		if (patient == null) {
//
////			log.warn("Patient does'nt exist " + contactNumber);
//			throw new NoSuchElementException("Patient doesn't exist");
//
//		} 
		report.setDate(new Date());
//		patient.addReports(report);

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

	@Override
	public List<Report> getAllByContactNumber(Long contactNumber) {
		return reportRepository.findByContactNumber(contactNumber);
	}

	@Override
	public List<Report> deleteAllByContactNumber(Long contactNumber) {
//		reportRepository.deleteAllByContactNumber(contactNumber);
		reportRepository.findByContactNumber(contactNumber).forEach(reportEach->{
			reportRepository.deleteAll(reportRepository.findByContactNumber(contactNumber));
		});
		return reportRepository.findAll();
	}

}
