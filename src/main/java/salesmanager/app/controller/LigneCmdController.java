package salesmanager.app.controller;

import java.util.List;

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

import salesmanager.app.entities.Commande;
import salesmanager.app.entities.LigneCmd;
import salesmanager.app.entities.Produit;
import salesmanager.app.repositories.LigneCmdRepository;
import salesmanager.app.services.CommandeService;
import salesmanager.app.services.LigneCmdService;
import salesmanager.app.services.ProduitService;

@RestController 
@RequestMapping("/api/lignecmds")
@CrossOrigin(origins = "http://localhost:4200")

public class LigneCmdController {
	
	@Autowired LigneCmdService ligneCmdService;
	@Autowired CommandeService commandeService;

    @Autowired
    ProduitService produitService;
	
	@GetMapping
	public List<LigneCmd> getAllLigneCmds(){
		return ligneCmdService.getAllLigneCmds();
	}
	
	@GetMapping("/commande/{idCmd}")
	public List<LigneCmd> getLigneCmdByCommandeId(@PathVariable Long idCmd){
		return ligneCmdService.getLigneCmdByCommandeId(idCmd);
	}
	
	
	 @PostMapping("/lignecmd")
	    public LigneCmd createLigneCmd(@RequestBody LigneCmdRequest ligneCmdRequest) {
	        return ligneCmdService.createLigneCmd(ligneCmdRequest);
	    }
	
	
	@PutMapping("/{idLigneCmd}")
    public LigneCmd updateLigneCmd(@PathVariable Long idLigneCmd, @RequestBody LigneCmd ligneCmd) {
        return ligneCmdService.updateLigneCmd(idLigneCmd, ligneCmd);
    }
	

    @DeleteMapping("/{idLigneCmd}")
    public void deleteLigneCmd(@PathVariable Long idLigneCmd) {
        ligneCmdService.deleteLigneCmd(idLigneCmd);
    }
}
