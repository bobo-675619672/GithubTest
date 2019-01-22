package com.dw.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.model.entity.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

	SysUser findByUsername(String username);

}