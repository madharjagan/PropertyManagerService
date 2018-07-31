package com.opw.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opw.client.dao.ClientDao;
import com.opw.client.model.Client;
import com.opw.client.vo.ClientVo;
import com.opw.response.Response;
import com.opw.vendor.model.VendorTypes;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
	
	@Autowired
	ClientDao clientDao;
	
	@GetMapping(value = "/getClientDetails/{clientID}", produces = "application/json")
	public String getClientDetails(@PathVariable(value = "clientID", required = true) int clientID) {

		return "";
	}
	
	@GetMapping(value = "/getClientDetails", produces = "application/json")
	public String getAllClientDetails() {
		List<Client> listOfClient = clientDao.findAll();
		Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		return objGson.toJson(listOfClient);
	}
	
	@PostMapping(value = "/addClient")
	public Client addProperty(@RequestBody Client client) {
		System.out.println("**************"+client.getClientname());
		System.out.println("**************"+client.getPhone());
		System.out.println("**************"+client.getEmail());
		return clientDao.save(client);
	}
	
	@GetMapping(value = "/getClientNames", produces = "application/json")
	public List<Response> getAllClientNames() {
		List<String> listOfClient = clientDao.findClientName();
		List<Response> clientRes = new ArrayList<>();
		for(String temp: listOfClient){
			Response res = new Response();
			res.setText(temp);
			res.setValue(temp);
			clientRes.add(res);
		}
		return clientRes;
	}
	
	@GetMapping(value = "/getClientSites", produces = "application/json")
	public Map<String, List<ClientVo>> getClientSiteDetails(@RequestParam(value = "clientName", required = true)String clientName) {
		List<ClientVo> listOfProperty = clientDao.findClientSites(clientName);
		Map<String, List<ClientVo>> resMap = new HashMap<>(); 
		resMap.put("siteDetails", listOfProperty);
		return resMap;
	}

}
