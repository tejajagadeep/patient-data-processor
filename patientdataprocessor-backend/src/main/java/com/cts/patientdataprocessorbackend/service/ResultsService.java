package com.cts.patientdataprocessorbackend.service;

import com.cts.patientdataprocessorbackend.model.Results;

public interface ResultsService {

	Results getByContactNumber(Long contactNumber);
	
	Results saveResults(Results results);
	
}
