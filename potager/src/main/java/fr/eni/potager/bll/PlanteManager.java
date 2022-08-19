package fr.eni.potager.bll;

import java.util.List;

import fr.eni.potager.bo.Plante;
import fr.eni.potager.bo.Potager;

public interface PlanteManager {
	public void addPlante(Plante... lstPlantes);
	public List<Plante> getAllPlantes();
	public void deletePlante(Plante p);
	public void delPlanteById(Integer id);
	public Plante getPlanteById(Integer id);
	public void modPlante(Plante plante);
}
