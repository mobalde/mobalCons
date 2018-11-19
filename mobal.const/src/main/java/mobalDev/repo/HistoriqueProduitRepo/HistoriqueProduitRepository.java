/**
 * 
 */
package mobalDev.repo.HistoriqueProduitRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import mobalDev.model.HistoriqueProduitEntity;

/**
 * @author mbalde
 *
 */
public interface HistoriqueProduitRepository extends JpaRepository<HistoriqueProduitEntity, Long>{

}
