package com.cts.patientdataprocessorreport.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.patientdataprocessorreport.model.Report;
import com.cts.patientdataprocessorreport.service.ReportService;



@SpringBootTest
class ReportControllerTest {

	@InjectMocks
	ReportController reportController;
	
	@Mock 
	ReportService reportService;
	
	private String dateString = "2000/12/14";
	private Date date = new Date(dateString);
	
	@Test
	void testGetAllByContactNumber() {
		Report report=new Report();
		report.setId(1);
		report.setContactNumber(9876543219L);
		report.setDate(date);
		report.setSystolic(150);
		report.setDiastolic(150);
		report.setSugarlevel(150);
		report.setSugarlevel2(150);
		
		Report report1=new Report();
		report1.setId(1);
		report1.setContactNumber(9876543219L);
		report1.setDate(date);
		report1.setSystolic(150);
		report1.setDiastolic(150);
		report1.setSugarlevel(150);
		report1.setSugarlevel2(150);
		
		List<Report> resultsList = new ArrayList<>();
		
		resultsList.add(report);
		resultsList.add(report1);
		
		when(reportService.getAllByContactNumber(9876543219L)).thenReturn(resultsList);
		
		ResponseEntity<List<Report>> response = reportController.getAllByContactNumber(9876543219L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, response.getBody().size());
	}
	
	@Test
	void testSaveReport()
	{
		Report report=new Report();
		report.setId(1);
		report.setContactNumber(9876543219L);
		report.setDate(date);
		report.setSystolic(150);
		report.setDiastolic(150);
		report.setSugarlevel(150);
		report.setSugarlevel2(150);
		
		when(reportService.saveReport(report)).thenReturn(report);
		ResponseEntity<Report> response = reportController.saveReport(report);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testDelete()
	{
		Report report=new Report();
		report.setId(1);
		report.setContactNumber(9876543219L);
		report.setDate(date);
		report.setSystolic(150);
		report.setDiastolic(150);
		report.setSugarlevel(150);
		report.setSugarlevel2(150);
		
		Report report1=new Report();
		report1.setId(1);
		report1.setContactNumber(9876543219L);
		report1.setDate(date);
		report1.setSystolic(150);
		report1.setDiastolic(150);
		report1.setSugarlevel(150);
		report1.setSugarlevel2(150);
		
		List<Report> resultsList = new ArrayList<>();
		
		resultsList.add(report);
		resultsList.add(report1);
		
		when(reportService.delete(1)).thenReturn(resultsList);

		ResponseEntity<List<Report>> response = reportController.delete(1);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testDeleteAllByContactNumber() {
		Report report=new Report();
		report.setId(1);
		report.setContactNumber(9876543219L);
		report.setDate(date);
		report.setSystolic(150);
		report.setDiastolic(150);
		report.setSugarlevel(150);
		report.setSugarlevel2(150);
		
		Report report1=new Report();
		report1.setId(1);
		report1.setContactNumber(9876543219L);
		report1.setDate(date);
		report1.setSystolic(150);
		report1.setDiastolic(150);
		report1.setSugarlevel(150);
		report1.setSugarlevel2(150);
		
		List<Report> resultsList = new ArrayList<>();

		resultsList.add(report);
		resultsList.add(report1);

		when(reportService.deleteAllByContactNumber(9876543219L)).thenReturn(resultsList);

		ResponseEntity<List<Report>> response = reportController.deleteAllByContactNumber(9876543219L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
