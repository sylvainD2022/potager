package fr.eni.potager.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.potager.bo.Plantation;
import fr.eni.potager.dal.PlantationDAO;

@Service
public class PlantaionManagerImpl implements PlantationManager {
	@Autowired
	PlantationDAO dao;
	@Override
	public void addPlantation(Plantation plant) throws PlantationException{
		//contrainte de surface occupée par la plante
		//TODO faire la somme des plantes avant de tester 
		if(plant.getCarre().getSurface()<plant.getPlante().getSurfaceOccupe()) {
			throw new PlantationException("La plante occupe troooop de place!!!!!!!!!");
			}
		dao.save(plant);
		
	}

	@Override
	public List<Plantation> getAllPlantations() {
		return (List<Plantation>) dao.findAll();
	}

	@Override
	public void deletePlantation(Plantation plant) {
		dao.delete(plant);
	}

	@Override
	public List<Plantation> getVuePotager(String potager) {
		return dao.findByPotager(potager);
	}

}
