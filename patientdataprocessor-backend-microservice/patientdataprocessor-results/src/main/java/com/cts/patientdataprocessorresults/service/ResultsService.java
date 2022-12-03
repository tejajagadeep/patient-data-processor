package com.cts.patientdataprocessorresults.service;

import java.util.List;

import com.cts.patientdataprocessorresults.model.Results;

public interface ResultsService {

	List<Results> getByContactNumber(Long contactNumber);
	
	Results saveResults(Results results);
	
	List<Results> delete(int id);

	List<Results> deleteAllByContactNumber(Long contactNumber);
}

