package com.rockers.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Employee extends BaseEntity{

	@Column(name="name", nullable = false)
	private String nome;
	
	@Column(name="wipro_Id", nullable = false, unique = true)
	private String wiproId;
	
	@Column(name="mc_Id")
	private String clientId;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Team team;
}
