package fr.utbm.gl52.proj.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.utbm.gl52.proj.model.Client;


public class ClientService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("GL52");
	EntityManager em = null;
	
	public ClientService() {
		
	}
	
	public Integer getNextValId() {
		em = emf.createEntityManager();
		List<Client> nextId = new ArrayList<Client>();
		nextId = em.createNamedQuery("Client.getNextValId", Client.class).getResultList();
		return (int) (nextId.get(0).getNumCli()+1);
	}
	
	public List<Client> getAllClient() {
		em = emf.createEntityManager();
		List<Client> clientList = new ArrayList<Client>();
		clientList = em.createNamedQuery("Client.getAll", Client.class).getResultList();
		return clientList;
	}

}
