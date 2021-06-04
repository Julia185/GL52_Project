package fr.utbm.gl52.proj.controller;

import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.service.ClientService;

public class ClientController {
	
	private ClientService service = new ClientService();

	public ClientController() {
		
	}

	public void insertNewClient(Client client) {
		System.out.println(client.toString());
	}

	public void modifyClient(Client client) {
	}

	public void eraseClient(String num) {
	}

}
