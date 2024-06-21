package salesmanager.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesmanager.app.entities.Client;
import salesmanager.app.entities.Commande;
import salesmanager.app.repositories.ClientRepository;
import salesmanager.app.repositories.CommandeRepository;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Commande> getAllCommandes(){
		return commandeRepository.findAll();
	}
	
	public Commande getCommandeByIdCmd(Long idCmd) {
		return commandeRepository.findById(idCmd).orElse(null);
	}
	
	
	
	public Commande createCommande(Commande commande, Long clientId) {
        Client client = clientRepository.findById(clientId)
        	.orElseThrow(() -> new IllegalArgumentException("Client not found"));
		
        commande.setClient(client);
        return commandeRepository.save(commande); 

        
	}

	public Commande updateCommande(Long idCmd, Commande commande) {

		Commande existingCommande = commandeRepository.findById(idCmd).orElse(null);
        if (existingCommande != null) {
            existingCommande.setDateCmd(commande.getDateCmd());

            return commandeRepository.save(existingCommande);
        } else {
            return null;
        }

	}

	public void deleteCommande(Long idCmd) {
		commandeRepository.deleteById(idCmd);
	}
	
	public List<Commande> getCommandeByClient(Long clientId) {
		return commandeRepository.findByClient_IdClient(clientId);
	}
}
