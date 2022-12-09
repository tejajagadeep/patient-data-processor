package com.cts.authenticationmicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class MessageResponseTest {
	
	
	/*
	 * MessageResponse messageResponse = new MessageResponse(); MessageResponse
	 * msgResponse = new MessageResponse(new Date(),"abc",HttpStatus.OK);
	 * MessageResponse msgRes = new MessageResponse(new Date(),
	 * "abc",HttpStatus.OK); 
	 */
	Date date=new Date();
	
	@InjectMocks
	MessageResponse messageResponse;
	
	MessageResponse messageResponse1 = new MessageResponse("abc",HttpStatus.OK);
	
	MessageResponse messageResponse2 = new MessageResponse("abc");
	
	@Test
	void testMessage() {
		messageResponse.setMessage("abc");
		assertEquals("abc",messageResponse.getMessage());
	}
	
	@Test
	void testStatus() {
		messageResponse.setStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK,messageResponse.getStatus());
	}
	
	@Test
	void testTimeStamp() {
		messageResponse.setTimeStamp(date);
		assertEquals(date, messageResponse.getTimeStamp());
	}
	
}
