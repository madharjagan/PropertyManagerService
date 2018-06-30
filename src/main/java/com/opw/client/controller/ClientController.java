package com.opw.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opw.client.model.Client;
import com.opw.vendor.vo.Response;
import com.opw.vendor.vo.VendorResponse;
import com.opw.client.dao.ClientDao;

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
	public String getAllClientNames() {
		List<Client> listOfClient = clientDao.findClientName();
		Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		return objGson.toJson(listOfClient);
	}
	
	@GetMapping(value = "/getClientDetails2", produces = "application/json")
	public Response getAllClientDetails9() {
		Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		List<Client> listOfClient = clientDao.findAll();
		List<VendorResponse> clientResponse = new ArrayList<>();
	
		for(Client temp : listOfClient){
			VendorResponse clientDet = new VendorResponse();
			clientDet.setText(temp.getClientname());
			clientDet.setValue(temp.getClientname());
			clientResponse.add(clientDet);
		}
		//Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		Response res = new Response();
		res.setMessage("Success");
		res.setResult(objGson.toJson(clientResponse));
		return res;
	}

}
