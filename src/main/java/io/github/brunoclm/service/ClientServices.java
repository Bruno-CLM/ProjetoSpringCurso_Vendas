package io.github.brunoclm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.brunoclm.model.Client;
import io.github.brunoclm.repository.ClientRepository;

@Service
public class ClientServices {
	
	private ClientRepository clientRepository;
	
	public ClientServices(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	//Post
	public Boolean cadastrarClient(Client client) {
		if(validarClient(client)) {
			clientRepository.insertClient(client);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	
	//Get
	public List<Client> listarClients() {
		return clientRepository.listAllClients();
	}
	
	//Get
	public Client findById(String uuid) {
		return clientRepository.findById(uuid);
	}
	
	//Put
	public Boolean updateClient(String uuid,Client client) {
		if(validarClient(client)){
			clientRepository.updateById(uuid, client);
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	
	//Delete 
	public Boolean deletarClient(String uuid) {
		try {
			clientRepository.deleteById(uuid);
		   return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return Boolean.FALSE;
	}
	
	private Boolean validarClient(Client client) {
		if (client.getEmail().equals(null) && client.getEmail().equals("")) {
			return Boolean.FALSE;
		} else if(client.getNome().equals(null) && client.getNome().equals("")) {
			return Boolean.FALSE;
		}else {
			return Boolean.TRUE;
		}
	}

}
