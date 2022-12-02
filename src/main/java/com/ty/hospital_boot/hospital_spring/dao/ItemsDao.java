package com.ty.hospital_boot.hospital_spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_boot.hospital_spring.dto.Items;
import com.ty.hospital_boot.hospital_spring.repository.ItemsRepository;

@Repository
public class ItemsDao {

	@Autowired
	ItemsRepository itemsRepository;
	
	public Items getItemsById(int id) {
		Optional<Items> optional=itemsRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return  null;
		}
	}
	
	public Items updateItems(Items items,int id) {
		Optional<Items> optional=itemsRepository.findById(id);
		Items items2;
		if(optional.isPresent()) {
			items2= optional.get();
		}else {
			items2= null;
		}
		
		if(items2!=null) {
			items.setId(id);
			itemsRepository.save(items);
			return items;
		}else {
			return null;
		}
		
	}
}
