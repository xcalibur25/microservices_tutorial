package com.yash.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
//timestamp
//message
// detail

	private Date timepstamp;
	private String message;
	private String detail;

	public ExceptionResponse(Date timepstamp, String message, String detail) {
		super();
		this.timepstamp = timepstamp;
		this.message = message;
		this.detail = detail;
	}

	public Date getTimepstamp() {
		return timepstamp;
	}

	public void setTimepstamp(Date timepstamp) {
		this.timepstamp = timepstamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
