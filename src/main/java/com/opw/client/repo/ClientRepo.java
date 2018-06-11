package com.opw.client.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opw.client.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {
	List<Client> findAll();
	Client findByClientID(int clientID);

}
