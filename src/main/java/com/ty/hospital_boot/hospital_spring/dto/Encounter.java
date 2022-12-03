package com.ty.hospital_boot.hospital_spring.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String causeofadmit;
	private String admitdate;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branch;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Medorder> medorder ;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCauseofadmit() {
		return causeofadmit;
	}


	public void setCauseofadmit(String causeofadmit) {
		this.causeofadmit = causeofadmit;
	}


	public String getAdmitdate() {
		return admitdate;
	}


	public void setAdmitdate(String admitdate) {
		this.admitdate = admitdate;
	}


	public List<Branch> getBranch() {
		return branch;
	}


	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}


	public List<Medorder> getMedorder() {
		return medorder;
	}


	public void setMedorder(List<Medorder> medorder) {
		this.medorder = medorder;
	}


	@Override
	public String toString() {
		return "Encounter [id=" + id + ", causeofadmit=" + causeofadmit + ", admitdate=" + admitdate + ", branch="
				+ branch + ", medorder=" + medorder + "]";
	}
	
	
	
}
