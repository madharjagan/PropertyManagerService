package com.opw.client.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.opw.client.model.Client;


public interface ClientRepo extends JpaRepository<Client, Integer> {
	List<Client> findAll();
	Client findByClientID(int clientID);
	
	@Query("select CONCAT(firstname, ' ', lastname) AS FIRSTNAME from Client")
	List<Client> findClientName();
	
}
