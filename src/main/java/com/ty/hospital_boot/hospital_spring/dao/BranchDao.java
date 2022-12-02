package com.ty.hospital_boot.hospital_spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_boot.hospital_spring.dto.Branch;
import com.ty.hospital_boot.hospital_spring.repository.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	BranchRepository branchRepository;
	
	public Branch getBranchById(int id) {
		Optional<Branch> optional=branchRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return  null;
		}
	}
	
	public Branch updateBranch(Branch branch,int id) {
		Optional<Branch> optional=branchRepository.findById(id);
		Branch branch2;
		if(optional.isPresent()) {
			branch2= optional.get();
		}else {
			branch2= null;
		}
		
		if( branch2!=null) {
			branch.setId(id);
			 branchRepository.save( branch);
			return  branch;
		}else {
			return null;
		}
		
	}
}
