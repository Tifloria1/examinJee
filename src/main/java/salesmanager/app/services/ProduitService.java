package salesmanager.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesmanager.app.entities.Fournisseur;
import salesmanager.app.entities.Produit;
import salesmanager.app.repositories.FournisseurRepository;
import salesmanager.app.repositories.ProduitRepository;



@Service
public class ProduitService {
	
@Autowired ProduitRepository produitRepository;	
@Autowired FournisseurRepository fournisseurRepository;
	
public List<Produit>getAllProduits(){
	return produitRepository.findAll();
	
}
public List<Produit> getProduitsByFournisseurId(Long idFour) {
    return produitRepository.findByFournisseurIdFour(idFour);
}

public Produit createProduit(Produit produit) {
    if (produit.getFournisseur() == null || produit.getFournisseur().getId_Four() == null) {
        throw new RuntimeException("Fournisseur information missing");
    }
    return produitRepository.save(produit);
}



public Produit getProduitById(Long idProd) {
	return produitRepository.findById(idProd).orElse(null);
}

public Produit updateProduit(Long id, Produit produit) {
    Produit existingProduit = produitRepository.findById(id).orElse(null);
    if (existingProduit != null) {
        existingProduit.setNomProd(produit.getNomProd());
        existingProduit.setQuantityStock(produit.getQuantityStock());
        existingProduit.setPrix(produit.getPrix());
        existingProduit.setFournisseur(produit.getFournisseur()); 
        return produitRepository.save(existingProduit);
    } else {

    	return null;
    }
}
public void deleteProduit(Long id) {
	produitRepository.deleteById(id);
	
}

public List<Produit> getProduitsByNom(String nomProduit){
	return produitRepository.findByNomProd(nomProduit);
}

public List<Produit> getProduitsByFournisseur(Long id_Four) {
    return produitRepository.findByFournisseurIdFour(id_Four);
}
}
