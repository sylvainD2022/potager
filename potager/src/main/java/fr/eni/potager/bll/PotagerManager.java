package fr.eni.potager.bll;

import java.util.List;

import fr.eni.potager.bo.Potager;

public interface PotagerManager {
	public void addPotager(Potager... lstPotagers);
	public List<Potager> getAllPotagers();
	public void deletePotager(Potager pot);
	public void delPotagerById(Integer id);
	public Potager getPotagerById(Integer id);
	public void modPotager(Potager potager);
}
