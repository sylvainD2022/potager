package fr.eni.potager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.potager.bo.Action;

public interface ActionDAO extends CrudRepository<Action, Integer>{

}
