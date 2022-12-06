package com.cts.authenticationmicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResultsTest {
	
	@InjectMocks
	Results results;

	private String dateString = "1999/07/28";
	private Locale date = new Locale(dateString);
	
	@Test
	void testGetterSetterId() {
		results.setId(1);
		assertEquals(1, results.getId());
	}

	@Test
	void testGetterSetterContactNumber() {
	}

	@Test
	void testGetterSetterDate() {
		results.setDate(date);
		assertEquals(date, results.getDate());
	}

	@Test
	void testGetterSetterWhiteBloodCells() {
		results.setWhiteBloodCells(0.0);
		assertEquals(0.0, results.getWhiteBloodCells());
	}

	@Test
	void testGetterSetterRedBloodCells() {
		results.setRedBloodCells(0.0);
		assertEquals(0.0, results.getRedBloodCells());
	}

	@Test
	void testGetterSetterHemoglobin() {
		results.setHemoglobin(0.0);
		assertEquals(0.0,results.getHemoglobin());
	}

	@Test
	void testGetterSetterHemotocrit() {
		results.setHemotocrit(0.0);
		assertEquals(0.0,results.getHemotocrit());
	}

	@Test
	void testGetterSetterMeanCellVolume() {
		results.setMeanCellVolume(0.0);
		assertEquals(0.0,results.getMeanCellVolume());
	}

	@Test
	void testGetterSetterMeanCellHemoglobin() {
		results.setMeanCellHemoglobin(0.0);
		assertEquals(0.0,results.getMeanCellHemoglobin());
	}

	@Test
	void testGetterSetterPlatelets() {
		results.setPlatelets(0);
		assertEquals(0,results.getPlatelets());
	}

	@Test
	void testGetterSetterReticulocyte() {
		results.setReticulocyte(0.00);
		assertEquals(0.00,results.getReticulocyte());
	}

}
