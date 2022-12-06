package com.cts.authenticationmicroservice.jwt;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.authenticationmicroservice.AuthenticationmicroserviceApplication;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String username;
	private String password;

	Logger log = LoggerFactory.getLogger(AuthenticationmicroserviceApplication.class);

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JwtRequest(String username, String password, Logger log) {
		super();
		this.username = username;
		this.password = password;
		this.log = log;
	}

}
