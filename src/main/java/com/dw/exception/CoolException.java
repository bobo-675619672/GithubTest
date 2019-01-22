package com.dw.exception;

public class CoolException extends RuntimeException {

	private Integer code;
	
	public CoolException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
