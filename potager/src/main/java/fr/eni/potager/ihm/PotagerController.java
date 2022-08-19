package fr.eni.potager.ihm;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.potager.bll.CarreException;
import fr.eni.potager.bll.CarreManager;
import fr.eni.potager.bll.PlanteManager;
import fr.eni.potager.bll.PotagerManager;
import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.TypeExposition;
import fr.eni.potager.bo.Plante;
import fr.eni.potager.bo.PlanteCateg;
import fr.eni.potager.bo.Potager;

@Controller
@RequestMapping("/potagerApp")
public class PotagerController {
	
	@Autowired
	PotagerManager potmanager;
	@Autowired
	PlanteManager plantemanager;
	@Autowired
	CarreManager carremanager;
	
	@GetMapping("")
	public String index(Model model){
		model.addAttribute("list",potmanager.getAllPotagers());
		return "menu";
	
	}
	
	//mapping potager
	@GetMapping("potager")
	public String indexPotager(Model model){
		model.addAttribute("list",potmanager.getAllPotagers());
		return "indexPotager";
		
	}
	
	@GetMapping("potager/add")
	public String initAddFormPotager(Potager potager ,Model model) {
		return "addPotager";
	}
	
	@PostMapping("potager/add")
	public String validAddFormPotager(@Valid Potager potager , BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "addPotager";
		}
		potmanager.addPotager(potager);
		
		return "redirect:/potagerApp/potager";
	}
	@GetMapping("potager/del/{id}")
	public String delPotager(@PathVariable("id") Integer id ,Model model) {
		potmanager.delPotagerById(id);
		return "redirect:/potagerApp/potager";
		
	}
	
	@GetMapping("potager/update/{id}")
	public String updatePotager(@PathVariable("id") Integer id ,Model model) {
		Potager potager =potmanager.getPotagerById(id);
		model.addAttribute("potager",potager);
		return "updatePotager";
	}
	
	@PostMapping("potager/update/{id}")
	public String UpdateValidPotager(@PathVariable("id") Integer id,@Valid Potager potager , BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "updatePotager";
		}
			potager.setIdPotager(id);
			potmanager.addPotager(potager);
		
		return "redirect:/potagerApp/potager";
	}
	
	//mapping plante
	@GetMapping("plante")
	public String indexPlante(Model model){
		model.addAttribute("list",plantemanager.getAllPlantes());
		return "indexPlante";
		
	}
	
	@GetMapping("plante/addPlante")
	public String initAddFormPlante(Plante plante, Model model) {
		PlanteCateg[] categorie = PlanteCateg.values();
		model.addAttribute("categorie", categorie);
		return "addPlante";
	}
	
	@PostMapping("plante/addPlante")
	public String validAddFormPlante(@Valid Plante plante , BindingResult errors, Model model) {
		PlanteCateg[] categorie = PlanteCateg.values();
		model.addAttribute("categorie", categorie);
		if(errors.hasErrors()) {
			return "addPlante";
		}
		plantemanager.addPlante(plante);
		
		return "redirect:/potagerApp/plante";
	}
	
	@GetMapping("plante/del/{id}")
	public String delPlante(@PathVariable("id") Integer id ,Model model) {
		plantemanager.delPlanteById(id);
		return "redirect:/potagerApp/plante";
		
	}
	
	@GetMapping("plante/update/{id}")
	public String updatePlante(@PathVariable("id") Integer id ,Model model) {
		Plante plante =plantemanager.getPlanteById(id);
		model.addAttribute("plante",plante);
		return "updatePlante";
	}
	
	@PostMapping("plante/update/{id}")
	public String UpdateValidPlante(@PathVariable("id") Integer id,@Valid Plante plante , BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "updatePlante";
		}
			plante.setIdPlante(id);
			plantemanager.addPlante(plante);
		
		return "redirect:/potagerApp/plante";
	}
	//mapping carré
		@GetMapping("carre")
		public String indexCarre(Model model){
			
			model.addAttribute("list",carremanager.getAllCarres());
			return "indexCarre";
			
		}
		//TODO addCarre init et valid non fonctionnels
		/*
		@GetMapping("carre/addCarre")
		public String initAddFormCarre(Carre carre, Model model) {
			List<Potager> potager = potmanager.getAllPotagers();
			TypeExposition[] typeExposition = TypeExposition.values();
			model.addAttribute("exposition", typeExposition);
			return "addCarre";
		}
		
		@PostMapping("carre/addCarre")
		public String validAddFormCarre(@Valid Carre carre , BindingResult errors, Model model) throws CarreException {
			TypeExposition[] exposition = TypeExposition.values();
			model.addAttribute("exposition", exposition);
			if(errors.hasErrors()) {
				return "addCarre";
			}
			carremanager.addCarre(carre);
			
			return "redirect:/potagerApp/carre";
		}*/
}
