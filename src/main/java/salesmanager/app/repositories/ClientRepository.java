package salesmanager.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import salesmanager.app.entities.Client;
import salesmanager.app.entities.Commande;
@Repository

public interface ClientRepository extends JpaRepository<Client, Long>{
	List<Commande> findByIdClient(Long idClient);
    List<Client> findByNomContainingOrPrenomContaining(String nom, String prenom);


}
