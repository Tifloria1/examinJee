package salesmanager.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Fournisseur {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id_Four;
	String nom;
	String prenom;
	
    @OneToMany(mappedBy = "fournisseur")
    private List<Produit> produits;  
	

    
}
