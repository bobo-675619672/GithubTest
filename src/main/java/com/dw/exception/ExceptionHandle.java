package com.dw.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dw.common.ResponseHead;
import com.dw.common.ResponseMsg;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseMsg<String> handle(Exception e) {
		log.error(e.getMessage());
		// 判断异常是否是我们自定义的异常
		if (e instanceof CoolException) {
			CoolException exception = (CoolException) e;
			new ResponseMsg<String>(new ResponseHead("-1", String.valueOf(exception.getCode()), exception.getMessage()),
					null);
		}
		return new ResponseMsg<String>(new ResponseHead("-1", "-1", e.getMessage()), null);
	}

}
