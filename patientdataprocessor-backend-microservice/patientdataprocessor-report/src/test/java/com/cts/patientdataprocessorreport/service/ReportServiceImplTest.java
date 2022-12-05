package com.cts.patientdataprocessorreport.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.patientdataprocessorreport.model.Report;
import com.cts.patientdataprocessorreport.repository.ReportRepository;


@SpringBootTest
class ReportServiceImplTest {

	@InjectMocks
	ReportServiceImpl reportServiceImpl;
	
	@Mock 
	ReportRepository reportRepository;
	
	@Mock
	Report report;
	
	private String dateString = "2000/12/14";
	private Date date = new Date(dateString);
	
	@Test
	void testGetAllReports() {
		
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
		
		when(reportRepository.findAll()).thenReturn(resultsList);
		reportServiceImpl.getAllReports();
        verify(reportRepository).findAll();
	}
	
	@Test
	void testSaveReport() {
		
		Report report=new Report();
		report.setId(1);
		report.setContactNumber(9876543219L);
		report.setDate(date);
		report.setSystolic(150);
		report.setDiastolic(150);
		report.setSugarlevel(150);
		report.setSugarlevel2(150);
		
		when(reportRepository.save(report)).thenReturn(report);
		
		assertEquals(report, reportServiceImpl.saveReport(report));
	}
	
	@Test
	void testDelete() {
		Report report=new Report();
		report.setId(1);
		report.setContactNumber(9876543219L);
		report.setDate(date);
		report.setSystolic(150);
		report.setDiastolic(150);
		report.setSugarlevel(150);
		report.setSugarlevel2(150);
		
		when(reportRepository.findById(1)).thenReturn(report);
		reportServiceImpl.delete(1);
		verify(reportRepository,times(1)).deleteById(1);
		

		when(reportRepository.findById(1)).thenReturn(null);
		
		assertThrows(NoSuchElementException.class, ()-> reportServiceImpl.delete(1));
	}
	
	
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
		
		when(reportRepository.findByContactNumber(987654321L)).thenReturn(resultsList);
		reportServiceImpl.getAllByContactNumber(987654321L);
        //verify(reportRepository).findAll();
		
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
		
		when(reportRepository.findByContactNumber(9876543219L)).thenReturn(resultsList);
		reportServiceImpl.deleteAllByContactNumber(9876543219L);
        //verify(reportRepository).deleteAll();
	}

}
