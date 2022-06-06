package com.citi.sachin.springbootlearning.controladvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.citi.sachin.springbootlearning.exceptions.ElementNoFoundException;
import com.citi.sachin.springbootlearning.exceptions.NoSuchElementFoundException;

@ControllerAdvice
public class MyControllerAdvice {


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ExceptionHandler(value = NoSuchElementFoundException.class)
public Map<String, String> handleException(NoSuchElementFoundException noSuchElementFoundException)
{
	Map<String, String> map= new HashMap<>();
	map.put("error message", noSuchElementFoundException.getMessage());
			
return map;
}


@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
@ExceptionHandler(value = ElementNoFoundException.class)
public Map<String, String> handleBusinessException(ElementNoFoundException elementNoFoundException ){
	
	Map<String, String> map=new HashMap<String, String>();
	map.put("error message", elementNoFoundException.getMessage());
	return map;
}
}