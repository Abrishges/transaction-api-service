/**
 * 
 */
package com.capitalOne.transaction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.capitalOne.transaction.dto.ErrorResponse;


/*
 * Global error code response
 * 
 * @author Abereham Wodajie
 *
 *         Aug 10, 2016
 */
@ControllerAdvice
public class ExceptionHandlerController {

	private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse requestHandlingNoHandlerFound(HttpServletRequest req, HttpServletResponse response,
			NoHandlerFoundException e) {

		log.debug("request url 1: " + req.getRequestURI());
		log.debug("request method " + req.getMethod());
		log.debug("status code " + response.getStatus());

		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),
				"The URL you have reached is not in service at this time", req.getRequestURL(), req.getMethod(),
				"none");
	}

	// handles number format exceptions
	@ExceptionHandler(value = NumberFormatException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse nfeHandler(HttpServletRequest req, HttpServletResponse response, NumberFormatException e) {

		log.debug("request url 3: " + req.getRequestURI());
		log.debug("request method " + req.getMethod());
		log.debug("status code " + response.getStatus());

		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Required Number parameter is not proper",
				req.getRequestURL(), req.getMethod(), "none");
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseBody
	public ErrorResponse BusinessExceptionHandler(HttpServletRequest req, HttpServletResponse response,
			IllegalArgumentException e) {

		log.debug("request url 2: " + req.getRequestURI());
		log.debug("request method " + req.getMethod());
		log.debug("status code " + response.getStatus());

		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), req.getRequestURL(), req.getMethod(),
				"none");
	}
}
