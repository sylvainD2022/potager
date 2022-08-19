package fr.eni.potager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.potager.bo.Plante;

public interface PlanteDAO extends CrudRepository<Plante, Integer>{
	
}
