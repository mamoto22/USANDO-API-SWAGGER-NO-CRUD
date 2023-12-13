package com.sitedeviagem.controller;

import java.util.List;

import com.sitedeviagem.models.Client;
import com.sitedeviagem.models.Viagem;
import com.sitedeviagem.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/viagem")
public class ViagemController {

	@Autowired
	private com.sitedeviagem.repositories.ViagemRepository pr;

	@Autowired
	private ClientRepository cr;

	@GetMapping("/allviagem")
	public List<Viagem> getAllViagems() {

		return pr.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Viagem> getViagemById(@PathVariable Long id) {
		Viagem viagem = pr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));

		return ResponseEntity.ok(viagem);

	}

	@PostMapping("/saveviagem")
	public Viagem saveViagem(@RequestBody Viagem viagem) {
		Client client = cr.findById(viagem.getClient().getId()).orElseThrow(() -> new RuntimeException(viagem.getClient().getId() + "Not Found"));
		viagem.setClient(client);
		
		return pr.save(viagem);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Viagem> updateViagem(@PathVariable Long id, @RequestBody Viagem viagemUpdated) {
		Viagem viagem = pr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));
		Client client = cr.findById(viagemUpdated.getClient().getId()).orElseThrow(() -> new RuntimeException(viagemUpdated.getClient().getId() + "Not Found"));

		viagem.setName(viagemUpdated.getName());
		viagem.setCidade(viagemUpdated.getCidade());
		viagem.setClient(client);

		return ResponseEntity.ok(viagem);

	}

	@DeleteMapping("/{id}")
	public void deleteviagem(@PathVariable Long id) {
		Viagem viagem = pr.findById(id).orElseThrow(() -> new RuntimeException(id + "Not Found"));
		pr.delete(viagem);

	}
	
	
	
}
