package com.cts.patientdataprocessorresults.controller;

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

import com.cts.patientdataprocessorresults.model.Results;
import com.cts.patientdataprocessorresults.service.ResultsService;

@SpringBootTest
class ResultsControllerTest {

	@InjectMocks
	ResultsController resultController;

	@Mock
	ResultsService resultsService;

	private String dateString = "1999/07/28";
	private Date date = new Date(dateString);

	@Test
	void testGetByContactNumber() {
		Results newResults = new Results();
		newResults.setId(1);
		newResults.setDate(date);
		newResults.setWhiteBloodCells(10.0);
		newResults.setRedBloodCells(1.0);
		newResults.setHemoglobin(1.1);
		newResults.setHemotocrit(1.1);
		newResults.setMeanCellVolume(1.1);
		newResults.setMeanCellHemoglobin(1.1);
		newResults.setPlatelets(12);
		newResults.setReticulocyte(0.020);
		newResults.setContactNumber(7894561230L);

		Results newResults2 = new Results();
		newResults2.setId(2);
		newResults2.setDate(date);
		newResults2.setWhiteBloodCells(10.0);
		newResults2.setRedBloodCells(1.0);
		newResults2.setHemoglobin(1.1);
		newResults2.setHemotocrit(1.1);
		newResults2.setMeanCellVolume(1.1);
		newResults2.setMeanCellHemoglobin(1.1);
		newResults2.setPlatelets(12);
		newResults2.setReticulocyte(0.020);
		newResults2.setContactNumber(7894561230L);

		List<Results> resultsList = new ArrayList<>();

		resultsList.add(newResults);
		resultsList.add(newResults2);

		when(resultsService.getByContactNumber(7894561230L)).thenReturn(resultsList);

		ResponseEntity<List<Results>> response = resultController.getByContactNumber(7894561230L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, response.getBody().size());
	}

	@Test
	void testSaveResults() {
		Results newResults = new Results();
		newResults.setId(1);
		newResults.setDate(date);
		newResults.setWhiteBloodCells(10.0);
		newResults.setRedBloodCells(1.0);
		newResults.setHemoglobin(1.1);
		newResults.setHemotocrit(1.1);
		newResults.setMeanCellVolume(1.1);
		newResults.setMeanCellHemoglobin(1.1);
		newResults.setPlatelets(12);
		newResults.setReticulocyte(0.020);
		newResults.setContactNumber(7894561230L);

		when(resultsService.saveResults(newResults)).thenReturn(newResults);
		ResponseEntity<Results> response = resultController.saveResults(newResults);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testDelete() {

		Results newResults = new Results();
		newResults.setId(1);
		newResults.setDate(date);
		newResults.setWhiteBloodCells(10.0);
		newResults.setRedBloodCells(1.0);
		newResults.setHemoglobin(1.1);
		newResults.setHemotocrit(1.1);
		newResults.setMeanCellVolume(1.1);
		newResults.setMeanCellHemoglobin(1.1);
		newResults.setPlatelets(12);
		newResults.setReticulocyte(0.020);
		newResults.setContactNumber(7894561230L);

		Results newResults2 = new Results();
		newResults2.setId(2);
		newResults2.setDate(date);
		newResults2.setWhiteBloodCells(10.0);
		newResults2.setRedBloodCells(1.0);
		newResults2.setHemoglobin(1.1);
		newResults2.setHemotocrit(1.1);
		newResults2.setMeanCellVolume(1.1);
		newResults2.setMeanCellHemoglobin(1.1);
		newResults2.setPlatelets(12);
		newResults2.setReticulocyte(0.020);
		newResults2.setContactNumber(7894561230L);

		List<Results> resultsList = new ArrayList<>();

		resultsList.add(newResults);
		resultsList.add(newResults2);

		when(resultsService.delete(1)).thenReturn(resultsList);

		ResponseEntity<List<Results>> response = resultController.delete(1);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testDeleteAllByContactNumber() {
		
		Results newResults = new Results();
		newResults.setId(1);
		newResults.setDate(date);
		newResults.setWhiteBloodCells(10.0);
		newResults.setRedBloodCells(1.0);
		newResults.setHemoglobin(1.1);
		newResults.setHemotocrit(1.1);
		newResults.setMeanCellVolume(1.1);
		newResults.setMeanCellHemoglobin(1.1);
		newResults.setPlatelets(12);
		newResults.setReticulocyte(0.020);
		newResults.setContactNumber(7894561230L);

		Results newResults2 = new Results();
		newResults2.setId(2);
		newResults2.setDate(date);
		newResults2.setWhiteBloodCells(10.0);
		newResults2.setRedBloodCells(1.0);
		newResults2.setHemoglobin(1.1);
		newResults2.setHemotocrit(1.1);
		newResults2.setMeanCellVolume(1.1);
		newResults2.setMeanCellHemoglobin(1.1);
		newResults2.setPlatelets(12);
		newResults2.setReticulocyte(0.020);
		newResults2.setContactNumber(7894561230L);

		List<Results> resultsList = new ArrayList<>();

		resultsList.add(newResults);
		resultsList.add(newResults2);

		when(resultsService.deleteAllByContactNumber(7894561230L)).thenReturn(resultsList);

		ResponseEntity<List<Results>> response = resultController.deleteAllByContactNumber(7894561230L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}

}
