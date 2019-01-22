package com.dw.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.dw.common.ResponseHead;
import com.dw.common.ResponseMsg;

import net.sf.json.JSONObject;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	public void commence(HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
		httpServletResponse.setContentType("application/json;charset=UTF-8");
		httpServletResponse.getWriter().write(JSONObject.fromObject(getResponseMsg("-1", "-1", "401!!!")).toString());
		httpServletResponse.setStatus(401);
	}
	
	private ResponseMsg getResponseMsg(String message, String code, String desc) {
		ResponseHead responseHead = new ResponseHead();
		ResponseMsg responseMsg = new ResponseMsg();
		responseHead.setRespStatus(message);
		responseHead.setRespCode(code);
		responseHead.setRespDesc(desc);
		responseMsg.setData(null);
		responseMsg.setHead(responseHead);
		return responseMsg;
	}
}
