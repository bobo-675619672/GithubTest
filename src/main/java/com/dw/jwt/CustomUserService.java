package com.dw.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dw.model.dao.SysUserRepository;
import com.dw.model.entity.SysUser;

public class CustomUserService implements UserDetailsService {

	@Autowired
	SysUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		System.out.println("username:" + username);
		System.out.println("username:" + user.getUsername() + ";password:" + user.getPassword());
		System.out.println("size:" + user.getRoles().size());
		System.out.println("role:" + user.getRoles().get(0).getName());
		return user;
	}

}
