package io.github.brunoclm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.github.brunoclm.model.Client;

@Repository
public class ClientRepository {

	private static List<Client> clientsRepository = new ArrayList<Client>();
	
	public void insertClient(Client client){
		clientsRepository.add(client);
	}
	
	public Client findById(String uuid){
		for (Client client : clientsRepository) {
			if (client.getUuid().equalsIgnoreCase(uuid)) {
				return client;
			}
		}
		
		return null;
	}
	
	public void updateById(String uuid, Client clientUpdate){
		for (Client client : clientsRepository) {
			if(client.getUuid().equalsIgnoreCase(uuid)) {
				client.setEmail(clientUpdate.getEmail());
				client.setEmail(clientUpdate.getNome());
			}
		}
	}
	
	public void deleteById(String uuid){
		for (int i = 0; i > clientsRepository.size(); i++) {
			clientsRepository.remove(i);
			break;
		}
	}
	
	public List<Client> listAllClients(){
		List<Client> clients = new ArrayList<Client>();
		
		for (Client client : clientsRepository) {
			clients.add(client);
		}
		
		return clients;
	}
	
	
}
