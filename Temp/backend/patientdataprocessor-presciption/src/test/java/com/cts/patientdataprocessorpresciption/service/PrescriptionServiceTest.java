package com.cts.patientdataprocessorpresciption.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.patientdataprocessorpresciption.repository.PrescriptionRepository;

@SpringBootTest
class PrescriptionServiceTest {
	
	@InjectMocks
	PrescriptionService presc;
	
	@Mock
	PrescriptionRepository prescriptionRepository;
	

	@Test
	void testGetterSetterPrescription() {
		
		presc.setPrescription("Fever");
		assertEquals("Fever", presc.getPrescription(null));
		
		
		
	}

	@Test
	void testGetterSetterAllConditions() {
		presc.setAllConditions("Cough");
		assertEquals("Cough",presc.getAllConditions());
	}

}

}
