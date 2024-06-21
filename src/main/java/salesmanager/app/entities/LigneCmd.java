package salesmanager.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class LigneCmd {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	
	long idLigneCmd;
	int quantity; 

	
	@ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "idCmd", referencedColumnName = "idCmd")
	@JsonIgnore
	
	private Commande commande; 
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProd", referencedColumnName = "idProd")
	@JsonIgnore
	private Produit produit;
	

}
