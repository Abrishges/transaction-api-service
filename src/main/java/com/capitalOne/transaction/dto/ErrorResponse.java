/**
 * 
 */
package com.capitalOne.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aberehamwodajie
 *
 *         Oct 29, 2016
 */
public class ErrorResponse {

	@JsonProperty("error-code")
	private int errorCode;
	@JsonProperty("error-message")
	private String errorMessage;
	private StringBuffer url;
	private String method;
	private String informationCode;

	public ErrorResponse(int errorCode, String errorMessage, StringBuffer url, String method, String informationCode) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.url = url;
		this.method = method;
		this.informationCode = informationCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public StringBuffer getUrl() {
		return url;
	}

	public void setUrl(StringBuffer url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getInformationCode() {
		return informationCode;
	}

	public void setInformationCode(String informationCode) {
		this.informationCode = informationCode;
	}
}
