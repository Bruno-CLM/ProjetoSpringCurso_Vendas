package io.github.brunoclm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunoclm.annotations.Gerente;
import io.github.brunoclm.annotations.Operador;
import io.github.brunoclm.model.Client;
import io.github.brunoclm.model.Funcionario;
import io.github.brunoclm.service.ClientServices;

@RestController
@RequestMapping("/cliente")
public class ClientController {
	
	@Autowired
	private ClientServices clientServices;
	
	@Gerente
	private Funcionario gerente;
	
	@Operador
	private Funcionario operador;
	
	@PostMapping("/cadastrarCliente")
	public ResponseEntity<HttpStatus> cadastrarClient(@RequestBody Client client){
		
		Boolean retorno = clientServices.cadastrarClient(client);
		
		return (retorno) ? new ResponseEntity<HttpStatus>(HttpStatus.CREATED) : new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/listarCliente")
	public ResponseEntity<List<Client>> listarClients() {
		
		List<Client> clients = clientServices.listarClients();
		
		return (clients.size() == 0 ) ?  new ResponseEntity<List<Client>>(clients, HttpStatus.NO_CONTENT) :  new ResponseEntity<List<Client>>(clients, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/funcionario")
	public String teste(@RequestParam int codigo) {
		if(codigo == 10) {
			return gerente.tipoDeFuncionario();
		}
		return operador.tipoDeFuncionario();
	}
	
	@GetMapping("/buscarCliente")
	public ResponseEntity<Client> buscaClientId(@RequestParam String uuid) {
		
		Client client = clientServices.findById(uuid);
		
		return (client == null) ?  new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT) :  new ResponseEntity<Client>(client, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletarCliente")
	public ResponseEntity<HttpStatus> deletarClient(@RequestParam String uuid){
		
		Boolean retorno = clientServices.deletarClient(uuid);
		
		return (retorno) ? new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED) : new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updateCliente")
	public ResponseEntity<HttpStatus> updateClient(@RequestParam String uuid, @RequestBody Client client){
		
		Boolean retorno = clientServices.updateClient(uuid, client);
		
		return (retorno) ? new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED) : new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

}
