package salesmanager.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import salesmanager.app.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

	List<Produit> findByNomProd(String nomProd);
	


    @Query("SELECT p FROM Produit p WHERE p.fournisseur.id_Four = :idFour")
    List<Produit> findByFournisseurIdFour(@Param("idFour") Long idFour);
}



