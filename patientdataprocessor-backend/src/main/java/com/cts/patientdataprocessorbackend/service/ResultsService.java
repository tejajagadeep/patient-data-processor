package com.cts.patientdataprocessorbackend.service;

import java.util.List;

import com.cts.patientdataprocessorbackend.model.Results;

public interface ResultsService {

	List<Results> getByContactNumber(Long contactNumber);
	
	Results saveResults(Results results);
	
	List<Results> delete(int id);
}
