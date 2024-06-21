package salesmanager.app.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data @Entity
public class Produit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	Long idProd;
	String nomProd;
	int quantityStock;
	float prix;
	
	
	

	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Four", nullable = false)
	@JsonIgnore
    private Fournisseur fournisseur;
	
	@JsonIgnore
	@OneToMany (mappedBy = "produit")
	private List<LigneCmd> ligneCmd; 
	
}

