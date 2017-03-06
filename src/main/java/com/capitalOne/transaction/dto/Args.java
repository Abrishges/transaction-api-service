/**
 * 
 */
package com.capitalOne.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author aberehamwodajie
 *
 * Mar 5, 2017
 */
public class Args {
	
	@ApiModelProperty(required = true)
	long uid;
	@ApiModelProperty(required = true)
	String  token;
	@JsonProperty("api-token")
	String apiToken;
	@JsonProperty("json-strict-mode")
	boolean  jsonStrictMode;
	
	@JsonProperty("json-verbose-response")
	boolean jsonVerboseResponse;
	
	

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getApiToken() {
		return apiToken;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}

	public boolean isJsonStrictMode() {
		return jsonStrictMode;
	}

	public void setJsonStrictMode(boolean jsonStrictMode) {
		this.jsonStrictMode = jsonStrictMode;
	}

	public boolean isJsonVerboseResponse() {
		return jsonVerboseResponse;
	}

	public void setJsonVerboseResponse(boolean jsonVerboseResponse) {
		this.jsonVerboseResponse = jsonVerboseResponse;
	}

}
