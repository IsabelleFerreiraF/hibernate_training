package com.rockers.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;


@Entity
@Table
@Data
public class User extends BaseEntity{
	

	@Column(name="login",nullable = false)
	private String login;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Employee employee;
}
