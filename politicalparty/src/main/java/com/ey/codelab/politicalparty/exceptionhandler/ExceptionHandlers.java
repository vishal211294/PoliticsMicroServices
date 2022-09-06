package com.ey.codelab.politicalparty.exceptionhandler;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ey.codelab.politicalparty.model.InvalidArgumentDTO;

@ControllerAdvice
public class ExceptionHandlers {
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<InvalidArgumentDTO> invalidRequestArguments(MethodArgumentNotValidException e){
		java.util.List<String>  error = e.getAllErrors().stream().map(i->i.getDefaultMessage()).collect(Collectors.toList());
		InvalidArgumentDTO invalidArguments = new InvalidArgumentDTO();
		invalidArguments.setReasons(error);
		return new ResponseEntity<>(invalidArguments,HttpStatus.BAD_REQUEST);
	}
}
