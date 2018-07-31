package com.opw.client.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opw.client.model.Client;


public interface ClientRepo extends JpaRepository<Client, Integer> {
	
	List<Client> findAll();
	
	Client findByClientID(int clientID);
	
	@Query("select CONCAT(firstname, ' ', lastname) AS FIRSTNAME from Client")
	List<String> findClientName();
	
	
	@Query(value="select distinct c from Client c ,Property p  where c.clientID= p.client.clientID and CONCAT(c.firstname, ' ', c.lastname)=?1")
	List<Client> findClientSites(@Param("clientName")String  clientName);
}
