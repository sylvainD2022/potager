package fr.eni.potager.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.potager.bo.Plante;
import fr.eni.potager.bo.Potager;
import fr.eni.potager.dal.PlanteDAO;

@Service
public class PlanteManagerImpl implements PlanteManager {
	@Autowired
	PlanteDAO dao;
	@Override
	public void addPlante(Plante... lstPlantes) {
		for (Plante plante : lstPlantes) {
			addOrModPlante(plante);
		}
		
	}

	@Override
	public List<Plante> getAllPlantes() {
		
		return (List<Plante>) dao.findAll();
	}

	@Override
	public void deletePlante(Plante p) {
		dao.delete(p);

	}

	@Override
	public void delPlanteById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public Plante getPlanteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modPlante(Plante plante) {
		this.addOrModPlante(plante);
		
	}

	private void addOrModPlante(Plante plante) {
		dao.save(plante);
		
	}
}
