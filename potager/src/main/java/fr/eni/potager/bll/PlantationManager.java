package fr.eni.potager.bll;

import java.util.List;

import fr.eni.potager.bo.Plantation;

public interface PlantationManager {
	public void addPlantation(Plantation plant)throws PlantationException;
	public List<Plantation> getAllPlantations();
	public List<Plantation> getVuePotager(String potager);
	public void deletePlantation(Plantation plant);
}
