package fr.eni.potager.bll;

import java.util.List;

import fr.eni.potager.bo.Action;

public interface ActionManager {
	public void addAction(Action acte);
	public List<Action> getAllActions();
	public void deleteAction(Action acte);
}
