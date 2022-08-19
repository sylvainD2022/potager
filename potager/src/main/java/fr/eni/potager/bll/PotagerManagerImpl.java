package fr.eni.potager.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.potager.bo.Potager;
import fr.eni.potager.dal.PotagerDAO;

@Service
public class PotagerManagerImpl implements PotagerManager {
	@Autowired
	PotagerDAO dao;
	
	@Override
	@Transactional
	public void addPotager(Potager... lstPotager) {
		for (Potager potager : lstPotager) {
			addOrModPotager(potager);
		}
	}

	@Override
	public List<Potager> getAllPotagers() {
		
		return (List<Potager>) dao.findAll();
	}

	@Override
	public void deletePotager(Potager pot) {
		dao.delete(pot);

	}

	@Override
	public void delPotagerById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public Potager getPotagerById(Integer id) {
	
		return dao.findById(id).orElse(null);
	}

	@Override
	public void modPotager(Potager potager) {
		this.addOrModPotager(potager);
		
	}

	private void addOrModPotager(Potager potager) {
		dao.save(potager);
		
	}

}
