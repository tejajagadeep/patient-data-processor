package com.cts.authenticationservice.model;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class MessageResponse {
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss ")
	private Date timeStamp;
	private String message;
	private HttpStatus status;
	
	public MessageResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public MessageResponse(Date timeStamp, String message, HttpStatus status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.status = status;
	}

	public MessageResponse() {
		super();
	}
	
	
	
}
