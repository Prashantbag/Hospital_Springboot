package com.ty.hospital_boot.hospital_spring.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branch;
	
	

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", branch=" + branch + "]";
	}


	
	
	
	
	
	
	
		
	
	
	
}
