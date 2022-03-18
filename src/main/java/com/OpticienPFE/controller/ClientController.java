package com.OpticienPFE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpticienPFE.model.Client;
import com.OpticienPFE.service.ClientService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/client/")
public class ClientController {
	
	private final ClientService clientService;
	
    @Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
    
    @GetMapping("get")
    public List<Client> findAll(){
    	return clientService.getAllClient();
    }
    
    @GetMapping("get/{nomPrenom}")
    public List<Client> findAllByNomPrenom(@PathVariable(value = "nomPrenom") String nomPrenom){
    	return clientService.getClientByNomPrenom(nomPrenom);
    }
    
    
    @PostMapping
	public void save(@RequestBody Client client) {
		clientService.addClient(client);
	}

	@PutMapping("put/{id}")
	public void put(@RequestBody Client client, @PathVariable(value = "id") Long id) {
		clientService.updateClient(client, id);
	}

	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable(value = "id") Long id) {
		clientService.deleteClient(id);
	}
	

}
