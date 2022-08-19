package fr.eni.potager.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.potager.bo.Carre;
import fr.eni.potager.dal.CarreDAO;

@Service
public class CarreManagerImpl implements CarreManager {
	@Autowired
	CarreDAO dao;
	@Override
	public void addCarre(Carre c) throws CarreException{
		//contrainte de surface du carré par rapport au potager
		//TODO faire la somme des carrés avant de tester
		if(c.getPotager().getSurface()<c.getSurface()) {
			throw new CarreException("Le carré doit être plus petit que le potager!!!!!!");
		}
		dao.save(c);
		
	}

	@Override
	public List<Carre> getAllCarres() {
		return (List<Carre>) dao.findAll();
	}

	@Override
	public void deleteCarre(Carre c) {
		dao.delete(c);
	}

	@Override
	public List<Carre> getAllCarreOf(String potager) {
		return dao.findByPotager(potager);
	}

}
