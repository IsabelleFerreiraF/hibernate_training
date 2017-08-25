package com.rockers.api.model;
import java.util.HashSet;
import java.util.Set;



import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Team extends BaseEntity{
	
	@Column(name="name", nullable = false)
	private String name;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private  Contract contract;
	
	@OneToMany(mappedBy = "team")
	private Set<Employee> wiproTeam = new HashSet<Employee>();
}
