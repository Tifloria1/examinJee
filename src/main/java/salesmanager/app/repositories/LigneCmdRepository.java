package salesmanager.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import salesmanager.app.entities.LigneCmd;

@Repository
public interface LigneCmdRepository extends JpaRepository<LigneCmd, Long>{
 List<LigneCmd>findByCommande_IdCmd(Long idCmd);
}
