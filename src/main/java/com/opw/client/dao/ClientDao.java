package com.opw.client.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opw.client.model.Client;
import com.opw.client.repo.ClientRepo;
import com.opw.client.vo.ClientVo;
import com.opw.client.vo.PropertyVo;

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
	
	
	public List<Client> findClientName() {
		return clientRepo.findClientName();		
	}
	
	public List<ClientVo> findClientSites(String clientName) {
		List<Client>   clientSiteList= clientRepo.findClientSites(clientName);
		List<ClientVo>  clientSiteVoList = new ArrayList<>();
		clientSiteList.forEach(clientSiteObj ->{
			List<PropertyVo>  propertyList = new ArrayList<>();
			ClientVo clientVo = new ClientVo();
			clientVo.setClientID(clientSiteObj.getClientID());
			clientVo.setClientname(clientSiteObj.getClientname());
			clientVo.setFirstname(clientSiteObj.getFirstname());
			clientVo.setLastname(clientSiteObj.getLastname());
			clientVo.setEmail(clientSiteObj.getEmail());
			clientVo.setPhone(clientSiteObj.getPhone());
			clientSiteObj.getProperty().forEach(property ->{
				PropertyVo propVo = new PropertyVo();
				propVo.setPropertyID(property.getPropertyID());
				propVo.setPropertytype(property.getPropertytype());
				propVo.setAdministrative_area_level_1(property.getAdministrative_area_level_1());
				propVo.setStreet_number(property.getStreet_number());
				propVo.setRoute(property.getRoute());
				propVo.setLocality(property.getLocality());
				propertyList.add(propVo);
			});
			clientVo.setProperty(propertyList);
			clientSiteVoList.add(clientVo);
		});
		
		return clientSiteVoList;		
	}
}
