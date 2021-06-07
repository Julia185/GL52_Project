package fr.utbm.gl52.proj.controller;

import java.util.List;

import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.service.ClientService;

public class ClientController {
	
	private ClientService service = new ClientService();

	public ClientController() {
	}
	
	public String getNextValId() {
		return this.service.getNextValId();		
	}
	
	public List<Client> getAllClient() {
		return this.service.getAllClient();
	}

	public void insertNewClient(Client client) {
		this.service.inserClient(client);
	}

	public void modifyClient(Client client) {
		this.service.updateClient(client);
	}


	public void deleteClient(Client client) {
		this.service.deleteClient(client.getNumCli());
		
	}

}
