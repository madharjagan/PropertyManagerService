package com.opw.property.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opw.property.model.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {
	Property findByPropertyID(int clientID);
	List<Property> findAll();
}
