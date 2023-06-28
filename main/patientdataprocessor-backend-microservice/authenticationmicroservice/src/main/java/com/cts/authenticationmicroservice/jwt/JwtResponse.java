package com.cts.authenticationmicroservice.jwt;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.authenticationmicroservice.AuthenticationmicroserviceApplication;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	Logger log = LoggerFactory.getLogger(AuthenticationmicroserviceApplication.class);

	public JwtResponse(String jwttoken) {
		log.info("inside JwtResponse of JwtResponse");
		this.jwttoken = jwttoken;
	}

	public String getToken() {

		log.info("inside getToken of JwtResponse");
		return this.jwttoken;
	}
}