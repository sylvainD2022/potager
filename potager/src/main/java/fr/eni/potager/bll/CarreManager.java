package fr.eni.potager.bll;

import java.util.List;

import fr.eni.potager.bo.Carre;

public interface CarreManager {
	public void addCarre(Carre c) throws CarreException;
	public List<Carre> getAllCarres();
	public List<Carre> getAllCarreOf(String potager);
	public void deleteCarre(Carre c);
}
