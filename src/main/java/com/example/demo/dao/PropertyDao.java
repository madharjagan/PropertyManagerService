package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Property;
import com.example.demo.repo.PropertyRepo;

@Repository
public class PropertyDao {
	
	@Autowired
	PropertyRepo propertyRepo;
	
	public Property findByPropertyID(int clientID) {
		return propertyRepo.findByPropertyID(clientID);		
	}
	
	public List<Property> findAll() {
		return propertyRepo.findAll();		
	}

	public Property save(Property property) {
		return propertyRepo.save(property);		
	}

}
