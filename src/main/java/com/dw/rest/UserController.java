package com.dw.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.common.ResponseMsg;
import com.dw.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseMsg<String> login(String username, String password) {
		String token = userService.login(username, password);
		return success(token);
	}
	
}
