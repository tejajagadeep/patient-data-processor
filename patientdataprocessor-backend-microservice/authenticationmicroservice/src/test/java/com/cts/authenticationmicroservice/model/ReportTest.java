package com.cts.authenticationmicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReportTest {

	@InjectMocks
	Report report;
	
	private String dateString = "2000/12/14";
	private Locale date = new Locale(dateString);
	
	@Test
	void testGetterSetterId() {
		report.setId(1);
		assertEquals(1,report.getId());
	}
	
	@Test
	void testGetterSetterContactNumber() {
		report.setContactNumber(9876543219L);
		assertEquals(9876543219L,report.getContactNumber());
	}
	
	@Test
	void testGetterSetterDate() {
		report.setDate(date);
		assertEquals(date,report.getDate());
	}
	
	@Test
	void testGetterSetterSystolic() {
		report.setSystolic(150);
		assertEquals(150,report.getSystolic());
	}
	
	@Test
	void testGetterSetterDiastolic() {
		report.setDiastolic(150);
		assertEquals(150,report.getDiastolic());
	}
	
	@Test
	void testGetterSetterSugarlevel() {
		report.setSugarlevel(150);
		assertEquals(150,report.getSugarlevel());
	}
	
	@Test
	void testGetterSetterSugarlevel2() {
		report.setSugarlevel2(150);
		assertEquals(150,report.getSugarlevel2());
	}

}
