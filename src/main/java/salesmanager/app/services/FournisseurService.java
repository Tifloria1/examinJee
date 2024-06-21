package salesmanager.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesmanager.app.entities.Fournisseur;
import salesmanager.app.repositories.FournisseurRepository;

@Service

public class FournisseurService {
	@Autowired FournisseurRepository fournisseurRepository;
	
	public Fournisseur saveFournisseur(Fournisseur fournisseur) {
		
		return fournisseurRepository.save(fournisseur);
	}
	public List<Fournisseur> getAllFournisseur(){
		
		return fournisseurRepository.findAll();
	}
	public Fournisseur getFournisseurById_Four(Long id_Four) {
		
		return fournisseurRepository.findById(id_Four).orElse(null);
	}
	
	 public Fournisseur updateFournisseur(Fournisseur fournisseur) {

		 return fournisseurRepository.save(fournisseur); 
	    }

	    public void deleteFournisseur(Long id_Four) {

	    	fournisseurRepository.deleteById(id_Four);
	    }
	
	    public boolean existsById(Long id_Four) {
	        return fournisseurRepository.existsById(id_Four);
	    }

}
