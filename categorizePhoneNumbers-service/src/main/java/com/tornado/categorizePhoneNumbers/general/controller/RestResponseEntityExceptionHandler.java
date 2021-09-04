package com.tornado.categorizePhoneNumbers.general.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tornado.categorizePhoneNumbers.general.exception.BusinessException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	@ExceptionHandler(value = BusinessException.class)
	protected ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
		LOG.error(" There is a Business Exception");
		LOG.error(ex.getMessage(), ex);
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
		LOG.error(" There is a General Exception");
		String errorMessage = "General system error occurred.";
		LOG.error(errorMessage, ex);
		return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
