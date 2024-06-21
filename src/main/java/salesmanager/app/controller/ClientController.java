package salesmanager.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import salesmanager.app.entities.Client;
import salesmanager.app.entities.Commande;
import salesmanager.app.entities.Produit;
import salesmanager.app.services.ClientService;

@RestController 
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")

public class ClientController {
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping
	public List<Client> getAllClients(){
		return clientService.getAllClient();
	}
	
	@PostMapping   
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);  
    }
	
	
	@GetMapping("{idClient}/commandes")
    public List<Commande> getAllCommandesByClientId(@PathVariable Long idClient) {
        return clientService.getAllCommandesByClientId(idClient);
    }
	
	 @PutMapping("/{idClient}")
	    public Client updateClient(@PathVariable Long idClient, @RequestBody Client clientDetails) {
	        return clientService.updateClient(idClient, clientDetails);
	    }
	
	
	  @DeleteMapping("/{idClient}")
	    public void deleteClient(@PathVariable Long idClient) {
	        clientService.deleteClient(idClient);
	    }
	  
	  
	  @GetMapping("/search")
	  public List<Client> searchClients(@RequestParam String term) {
	      return clientService.searchClients(term);
	  }
}

	

