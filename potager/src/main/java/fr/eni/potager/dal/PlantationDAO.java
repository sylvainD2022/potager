package fr.eni.potager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.potager.bo.Plantation;

public interface PlantationDAO extends CrudRepository<Plantation, Integer>{

	@Query("FROM Plantation plant WHERE plant.carre.potager.nom= :potager")
	List<Plantation> findByPotager(@Param("potager") String potager);
}
