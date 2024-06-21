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

import salesmanager.app.entities.Fournisseur;
import salesmanager.app.entities.Produit;
import salesmanager.app.repositories.FournisseurRepository;
import salesmanager.app.repositories.ProduitRepository;
import salesmanager.app.services.FournisseurService;
import salesmanager.app.services.ProduitService;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "http://localhost:4200")

public class ProduitController {

	@Autowired
	private ProduitService produitService;
    
    @Autowired
    private FournisseurService fournisseurService;


	
	@GetMapping
	List<Produit>getAllProduits(){
		return produitService.getAllProduits();
	}
	 
     @GetMapping("/{idProd}")
	    public Produit getProduitById(@PathVariable Long idProd) {
	        return produitService.getProduitById(idProd);
	    }
     
	

     @PostMapping("/produit")

     public Produit createProduit(@RequestBody Produit produit) {
    	    if (produit.getFournisseur() == null || produit.getFournisseur().getId_Four() == null) {
    	        throw new IllegalArgumentException("Fournisseur information is missing");
    	    }

    	    Fournisseur fournisseur = fournisseurService.getFournisseurById_Four(produit.getFournisseur().getId_Four());
    	    if (fournisseur == null) {
    	        throw new IllegalArgumentException("Fournisseur not found");
    	    }

    	    produit.setFournisseur(fournisseur);
    	    return produitService.createProduit(produit);
    	}

	
	@PutMapping("/produit/{id}")
	public  Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit){
		return produitService.updateProduit(id, produit);}
	
	
	@DeleteMapping("/produit/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
	
	  @GetMapping("/fournisseur/{idFour}")
	    public List<Produit> getProduitsByFournisseurId(@PathVariable Long idFour) {
	        return produitService.getProduitsByFournisseurId(idFour);
	    }
}
