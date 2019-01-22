package com.dw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.enums.ExceptionCode;
import com.dw.exception.CoolException;
import com.dw.jwt.JwtTokenUtil;
import com.dw.model.dao.SysUserRepository;
import com.dw.model.entity.SysUser;
import com.dw.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserRepository userRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	public String login(String username, String password) {
		SysUser user = userRepository.findByUsername(username);
		if (null == user) { // 用户存在
			throw new CoolException(ExceptionCode.USER_NOT_EXIST.getCode(), ExceptionCode.USER_NOT_EXIST.getMessage());
		}
		if (!user.getPassword().equalsIgnoreCase(password)) { // 密码错误
			throw new CoolException(ExceptionCode.PASSWORD_ERROR.getCode(), ExceptionCode.PASSWORD_ERROR.getMessage());
		}
		return jwtTokenUtil.generateToken(user);
	}

}
