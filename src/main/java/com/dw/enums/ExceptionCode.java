package com.dw.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

	TOKEN_ERROR(10001, "token错误!"),
	TOKEN_NOT_EXIST(10002, "token不存在!"),
	TOKEN_EXPIRED(10003, "token过期!"),
	
	USER_NOT_EXIST(20001, "用户不存在"),
	PASSWORD_ERROR(20002, "用户密码错误"),
	
	NONE(99999, "未知错误!");
	
	private Integer code;
	private String message;
	
}
