package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

	List<Property> findByPropertyID(int clientID);

}
