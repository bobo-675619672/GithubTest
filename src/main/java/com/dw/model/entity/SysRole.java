package com.dw.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SysRole {

	@Id
    @GeneratedValue
    private Long id;
	
    private String name;
    
}
