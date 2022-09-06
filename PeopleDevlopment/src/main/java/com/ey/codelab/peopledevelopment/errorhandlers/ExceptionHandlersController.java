package com.ey.codelab.peopledevelopment.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ey.codelab.peopledevelopment.model.InvalidArgumentDTO;

@ControllerAdvice
public class ExceptionHandlersController {
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<InvalidArgumentDTO> invalidArgumentHandler(MethodArgumentNotValidException e) {
		InvalidArgumentDTO invalidArgumentDTO = new InvalidArgumentDTO();
		invalidArgumentDTO.setReasons(e.getAllErrors().stream().map(i->i.getDefaultMessage()).toList());
		return new ResponseEntity<InvalidArgumentDTO>(invalidArgumentDTO,HttpStatus.BAD_REQUEST);
	}
}
