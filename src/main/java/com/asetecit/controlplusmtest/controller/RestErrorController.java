package com.asetecit.controlplusmtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.asetecit.controlplusmtest.core.BusinessException;
import com.asetecit.controlplusmtest.dto.ErrorMessageDto;

@ControllerAdvice
public class RestErrorController {

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessageDto processBusinessException(BusinessException ex) {
		return new ErrorMessageDto(ex.getMessage() == null ? "Solicitud incorrecta." : ex.getMessage());
	}
}
