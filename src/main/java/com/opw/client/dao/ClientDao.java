package com.opw.client.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opw.client.Client;
import com.opw.client.repo.ClientRepo;

@Repository
public class ClientDao {
	
	@Autowired
	ClientRepo clientRepo;
	
	public Client findByClientID(int clientID) {
		return clientRepo.findByClientID(clientID);		
	}
	
	public List<Client> findAll() {
		return clientRepo.findAll();		
	}

	public Client save(Client client) {
		return clientRepo.save(client);		
	}

}
