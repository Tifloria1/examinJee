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
import org.springframework.web.bind.annotation.RestController;

import salesmanager.app.entities.Fournisseur;
import salesmanager.app.services.FournisseurService;

@RestController
@RequestMapping ("/api/fournisseurs")
@CrossOrigin(origins = "http://localhost:4200")

public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurService;
	
	@GetMapping
	public List<Fournisseur> getAllFournisseurs(){
		return fournisseurService.getAllFournisseur();
	}
	
	@PostMapping("/fournisseur")	
	public Fournisseur saveFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.saveFournisseur(fournisseur);
	}
	
	@GetMapping("/{id_Four}")
	public Fournisseur getFournisseurById(@PathVariable Long id_Four) {
		return fournisseurService.getFournisseurById_Four(id_Four);
	}
	
	@PutMapping("/{id_Four}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id_Four, @RequestBody Fournisseur fournisseurDetails) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById_Four(id_Four);
        if (fournisseur == null) {
            return ResponseEntity.notFound().build();
        }
        fournisseur.setNom(fournisseurDetails.getNom());
        fournisseur.setPrenom(fournisseurDetails.getPrenom());
        Fournisseur updatedFournisseur = fournisseurService.saveFournisseur(fournisseur);
        return ResponseEntity.ok(updatedFournisseur);
    }

    @DeleteMapping("/{id_Four}")
    public void deleteFournisseur(@PathVariable Long id_Four) {
        fournisseurService.deleteFournisseur(id_Four);
     
    
    
    }}
	

