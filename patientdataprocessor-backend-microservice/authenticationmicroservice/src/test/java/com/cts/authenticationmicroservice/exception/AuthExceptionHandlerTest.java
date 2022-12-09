package com.cts.authenticationmicroservice.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import feign.FeignException;

@SpringBootTest
class AuthExceptionHandlerTest {
	
	@InjectMocks
	AuthExceptionHandler authExceptionHandler;
	
	@Mock
	FeignException feignException;
	
	@Test
	void testHandleFeignException() {
		assertEquals(400, authExceptionHandler.handleFeignException(feignException).getStatusCodeValue());
	}

	@Test
	void testHandleIdAlreadyExistException() {
		assertEquals(400, authExceptionHandler.handleIdAlreadyExistException(new IdAlredyExistsException(null)).getStatusCodeValue());
	}

}
