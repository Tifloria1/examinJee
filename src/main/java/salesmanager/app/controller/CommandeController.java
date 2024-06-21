package salesmanager.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import salesmanager.app.entities.Commande;
import salesmanager.app.services.CommandeService;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin(origins = "http://localhost:4200")

public class CommandeController {
	
	@Autowired
	private CommandeService commandeService;
	
	@GetMapping
	public List<Commande> getAllCommandes() {
		return commandeService.getAllCommandes();
	}

	@PostMapping("/commande/{clientId}")
	public Commande createCommande(@RequestBody Commande commande,@PathVariable  Long clientId) {
		return commandeService.createCommande(commande, clientId);
	}
	
	@GetMapping("/clients/{clientId}")
		public List<Commande>getCommandeByClientId(@PathVariable Long clientId){
			return commandeService.getCommandeByClient(clientId);
	}
	
	 @GetMapping("/{idCmd}")
	    public Commande getCommandeByIdCmd(@PathVariable Long idCmd) {
	        return commandeService.getCommandeByIdCmd(idCmd);
	    }
	
	
	@PutMapping("/{idCmd}")
    public Commande updateCommande(@PathVariable Long idCmd, @RequestBody Commande commande) {
        return commandeService.updateCommande(idCmd, commande);
    }

    @DeleteMapping("/{idCmd}")
    public void deleteCommande(@PathVariable Long idCmd) {
        commandeService.deleteCommande(idCmd);
    }

   
}
	
