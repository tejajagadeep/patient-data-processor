package com.cts.patientdataprocessorresults.service;

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

import com.cts.patientdataprocessorresults.model.Results;
import com.cts.patientdataprocessorresults.repository.ResultsRepository;

@SpringBootTest
class ResultsServiceImplTest {
	
	@InjectMocks
	ResultsServiceImpl resultsServiceImpl;
	
	@Mock
	ResultsRepository resultsRepository;
	
	@Mock
	Results results;
	
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
		
		when(resultsRepository.findByContactNumber(7894561230L)).thenReturn(resultsList);
		
		assertEquals(2, resultsServiceImpl.getByContactNumber(7894561230L).size());
		
		
	}
	
	@Test
	void testGetByContactNumberThrowsexception() {
		
		when(resultsRepository.findByContactNumber(7894561230L)).thenReturn(null);
		
		assertThrows(NoSuchElementException.class, ()-> resultsServiceImpl.getByContactNumber(7894561230L));
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
		when(resultsRepository.save(newResults)).thenReturn(newResults);
		
		assertEquals(newResults, resultsServiceImpl.saveResults(newResults));
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
		
		when(resultsRepository.findById(1)).thenReturn(newResults);
		resultsServiceImpl.delete(1);
		verify(resultsRepository,times(1)).deleteById(1);
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
		
		when(resultsRepository.findByContactNumber(7894561230L)).thenReturn(resultsList);
		resultsServiceImpl.deleteAllByContactNumber(7894561230L);
//		verify(resultsRepository,times(1)).deleteAll(resultsRepository.findByContactNumber(7894561230L));
	}

}
