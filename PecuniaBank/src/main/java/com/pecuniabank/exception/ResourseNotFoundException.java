package com.pecuniabank.exception;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException  extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourcename;
	
	private String fieldname;
	
	private Object fieldvalue;

	public  ResourseNotFoundException(String resourcename, String fieldname, Object fieldvalue) {
		super();
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
		System.out.println(String.format("%s not found with %s: '%s'"+
		fieldname, getStackTrace(),fieldvalue));
	}

	public String getResourcename() {
		return resourcename;
	}


	public String getFieldname() {
		return fieldname;
	}

	public String getFieldvalue() {
		return (String)fieldvalue;
	}
	

@SuppressWarnings({ "rawtypes", "unchecked" })
public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException e){
	Map<String,String> resp= new HashMap();
	e.getBindingResult().getAllErrors().forEach((error)->{
		String fieldname=((FieldError)error).getField();
		String message=error.getDefaultMessage();
		resp.put(fieldname, message);
		});

	return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	
}
}
