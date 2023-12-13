package com.sitedeviagem.controller;

import java.util.List;

import com.sitedeviagem.models.Client;
import com.sitedeviagem.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository cr;

	@GetMapping("/allclients")
	public ResponseEntity<List<Client>> getAllClients() {

		return ResponseEntity.ok(cr.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		Client client = cr.findById(id).orElse(null);
		if (client != null) {

			return ResponseEntity.ok(client);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/saveclient")
	public ResponseEntity<Client> saveClient(@RequestBody Client client) {
		Client clientCreated = cr.save(client);

		return new ResponseEntity<>(clientCreated, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientUpdated) {
		Client client = cr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));

		client.setName(clientUpdated.getName());
		client.setVooDate(clientUpdated.getVooDate());

		return ResponseEntity.ok(client);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id) {
		Client client = cr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));
		cr.delete(client);
		
		return new ResponseEntity<>(client + "Deleted", HttpStatus.ACCEPTED);

	}

}
