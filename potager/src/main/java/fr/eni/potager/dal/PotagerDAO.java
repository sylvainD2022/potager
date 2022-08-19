package fr.eni.potager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.potager.bo.Potager;

public interface PotagerDAO extends CrudRepository<Potager,Integer>{

}
