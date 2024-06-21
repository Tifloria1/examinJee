package salesmanager.app.entities;



import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor  @Data @Entity
public class Commande {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

	Long idCmd;
	Date dateCmd;
	
	@JsonIgnore
	@ManyToOne 
	@JoinColumn(name = "client_idClient", nullable = false) 
	private Client client; 
	
	@JsonIgnore
	@OneToMany (mappedBy = "commande")
	private List<LigneCmd> ligneCmd; 
	
	
}

