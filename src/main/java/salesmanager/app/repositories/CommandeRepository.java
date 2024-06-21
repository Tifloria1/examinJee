package salesmanager.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import salesmanager.app.entities.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

	List<Commande>findByClient_IdClient(Long clientId);
    @Query("SELECT c FROM Commande c WHERE c.client.idClient = :idClient")
    List<Commande> findByClientId(@Param("idClient") Long idClient);
}
