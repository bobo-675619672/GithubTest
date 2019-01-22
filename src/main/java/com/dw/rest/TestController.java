package com.dw.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.common.ResponseMsg;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

	@GetMapping("/none")
	public ResponseMsg<String> test() {
		return success("访问成功!");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public ResponseMsg<String> testAdmin() {
		return success("ADMIN访问成功!");
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user")
	public ResponseMsg<String> testUser() {
		return success("USER访问成功!");
	}
	
}
