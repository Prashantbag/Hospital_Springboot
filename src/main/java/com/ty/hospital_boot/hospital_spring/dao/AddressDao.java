package com.ty.hospital_boot.hospital_spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_boot.hospital_spring.dto.Address;
import com.ty.hospital_boot.hospital_spring.repository.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	AddressRepository addressRepository;
	
	public Address getAddressById(int id) {
		Optional<Address> optional=addressRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return  null;
		}
	}
	
	public Address updateAddress(Address address,int id) {
		Optional<Address> optional=addressRepository.findById(id);
		Address address2;
		if(optional.isPresent()) {
			address2= optional.get();
		}else {
			address2= null;
		}
		
		if( address2!=null) {
			address.setId(id);
			addressRepository.save( address);
			return  address;
		}else {
			return null;
		}
		
	}
}


