package fr.eni.potager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.potager.bo.Carre;


public interface CarreDAO extends CrudRepository<Carre, Integer>{
	
	@Query("FROM Carre c WHERE c.potager.nom= :potager")
	List<Carre> findByPotager(@Param("potager") String potager);
}
