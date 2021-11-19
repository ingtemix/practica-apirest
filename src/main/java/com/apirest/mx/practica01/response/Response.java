package com.apirest.mx.practica01.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {

	private int httpStatus;
	private String status;
	private String message;
	private String messageDetail;
	
	public Response() {
		
	}
	
	public Response(int httpStatus, String status, String message, String messageDetail) {
		super();
		this.httpStatus = httpStatus;
		this.status = status;
		this.message = message;
		this.messageDetail = messageDetail;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDetail() {
		return messageDetail;
	}

	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}
}
