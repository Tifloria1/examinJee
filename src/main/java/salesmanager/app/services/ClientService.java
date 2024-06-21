package salesmanager.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Id;
import salesmanager.app.entities.Client;
import salesmanager.app.entities.Commande;
import salesmanager.app.entities.Produit;
import salesmanager.app.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired 
	
	private ClientRepository clientRepository;
	
	public List<Client> getAllClient(){
		return clientRepository.findAll();
		
	}
	
	public Client createClient( Client client) {
		return clientRepository.save(client);
	}
	
	public Client getClientById(Long id) {
		return clientRepository.findById(id).orElse(null);
		
	}
	public List<Commande> getAllCommandesByClientId(Long idClient) {
		return clientRepository.findByIdClient(idClient);
	}
	
	
   public Client updateClient(Long idClient, Client clientDetails) {
        Client client = clientRepository.findById(idClient).orElseThrow();
        
        client.setNom(clientDetails.getNom());
        client.setPrenom(clientDetails.getPrenom());
        return clientRepository.save(client);

    }

	
	
	
	 public void deleteClient(Long idClient) {
	        clientRepository.deleteById(idClient);
	    }
	 
	 
	 
	 public List<Client> searchClients(String term) {
	        return clientRepository.findByNomContainingOrPrenomContaining(term, term);
	    } 

}
