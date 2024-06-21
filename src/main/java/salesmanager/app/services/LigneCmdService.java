package salesmanager.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import salesmanager.app.controller.LigneCmdRequest;
import salesmanager.app.entities.Commande;
import salesmanager.app.entities.LigneCmd;
import salesmanager.app.entities.Produit;
import salesmanager.app.repositories.LigneCmdRepository;

@Service

public class LigneCmdService {
	
	@Autowired
	LigneCmdRepository ligneCmdRepository;
	
	@Autowired
	private CommandeService commandeService;
	
	@Autowired
	private ProduitService produitService;
	@JsonIgnore
	
	
	public  List<LigneCmd> getAllLigneCmds(){
		return ligneCmdRepository.findAll();
	}
	
	
	public LigneCmd createLigneCmd(LigneCmdRequest ligneCmdRequest) {
        Commande commande = commandeService.getCommandeByIdCmd(ligneCmdRequest.getCommandeId());
        Produit produit = produitService.getProduitById(ligneCmdRequest.getProduitId());

        if (commande == null) {
            throw new RuntimeException("Commande indispo avec cette id: " + ligneCmdRequest.getCommandeId());
        }

        if (produit == null) {
            throw new RuntimeException("Produit indispo avec cette  id: " + ligneCmdRequest.getProduitId());
        }

        LigneCmd ligneCmd = new LigneCmd();
        ligneCmd.setQuantity(ligneCmdRequest.getQuantity());
        ligneCmd.setCommande(commande);
        ligneCmd.setProduit(produit);

        return ligneCmdRepository.save(ligneCmd);
    }
	
	public void deleteLigneCmd(Long idLigneCmd) {
        if (!ligneCmdRepository.existsById(idLigneCmd)) {
            throw new RuntimeException("LigneCmd indispo avec cette id " + idLigneCmd);
        }
        ligneCmdRepository.deleteById(idLigneCmd);
    }



	

	
	public List<LigneCmd> getLigneCmdByCommandeId(Long idCmd){
		return ligneCmdRepository.findByCommande_IdCmd(idCmd);
	}
	
	public LigneCmd updateLigneCmd(Long idLigneCmd, LigneCmd ligneCmd) {
		LigneCmd existingLigneCmd = ligneCmdRepository.findById(idLigneCmd).orElse(null);
		
	if(existingLigneCmd != null) {
			existingLigneCmd.setQuantity(ligneCmd.getQuantity());
			existingLigneCmd.setCommande(ligneCmd.getCommande());
            existingLigneCmd.setProduit(ligneCmd.getProduit());
		    return ligneCmdRepository.save(existingLigneCmd);	
	} else { 
        throw new RuntimeException("LigneCmd indisponible");

	}
  }
}

