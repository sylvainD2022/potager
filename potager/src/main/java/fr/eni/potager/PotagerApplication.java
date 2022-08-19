package fr.eni.potager;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.potager.bll.CarreManager;
import fr.eni.potager.bll.PlantationManager;
import fr.eni.potager.bll.PlanteManager;
import fr.eni.potager.bll.PotagerManager;
import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.TypeExposition;
import fr.eni.potager.bo.Plantation;
import fr.eni.potager.bo.Plante;
import fr.eni.potager.bo.PlanteCateg;
import fr.eni.potager.bo.Potager;

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner{
	@Autowired
	PlanteManager planteManager ;
	@Autowired
	PotagerManager potagerManager;
	@Autowired
	CarreManager carreManager;
	@Autowired
	PlantationManager plantationManager;
	public static void main(String[] args) {
		SpringApplication.run(PotagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//plantes
		Plante plante1 = new Plante("choux",PlanteCateg.RACINE,"rouge",7);
		
		planteManager.addPlante(plante1);
		System.out.println(planteManager.getAllPlantes());
		
		
		//potagers
		Potager potager1 = new Potager("0560508066","potager du paradis",170,"Quimper");
		
		potagerManager.addPotager(potager1);
		System.out.println(potagerManager.getAllPotagers());
		
		Potager potager2 = new Potager("7946161","jardin de Phil",39,"Brest");
		
		potagerManager.addPotager(potager2);
		System.out.println(potagerManager.getAllPotagers());
		
		
		//carres
		Carre carre1 = new Carre(potager1,4,"terre",TypeExposition.OMBRE);
		
		carreManager.addCarre(carre1);
		System.out.println(carreManager.getAllCarres());
		
		Carre carre2 = new Carre(potager1,24,"argile",TypeExposition.SOLEIL);
		
		carreManager.addCarre(carre2);
		System.out.println(carreManager.getAllCarres());
		
		Carre carre3 = new Carre(potager2,5,"terre",TypeExposition.SOLEIL);
		
		carreManager.addCarre(carre3);
		System.out.println(carreManager.getAllCarres());
		
		
		//carres d'1 potager
		List<Carre> lst1 = carreManager.getAllCarreOf("potager du paradis");
		lst1.forEach(System.out::println);
		
		List<Carre> lst2 = carreManager.getAllCarreOf("jardin de Phil");
		lst2.forEach(System.out::println);
		//plantation
		
		/*
		Plantation plantation1 = new Plantation(3,LocalDate.now(),LocalDate.now().plusMonths(2),carre2,plante1);
		
		plantationManager.addPlantation(plantation1);
		//System.out.println(plantationManager.getAllPlantations());
		
		//vue d'ensemble du potager
		List<Plantation> lst3 = plantationManager.getVuePotager("potager du paradis");
		lst3.forEach(System.out::println);
		*/
		/*	
		//test de la contrainte de taille pour le carré dans le potager
		Carre geantCarre = new Carre(potager2,51,"rocheux",Exposition.MI_OMBRE);
		try {
			
			carreManager.addCarre(geantCarre);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//test de contrainte de place occupée par une plante dans un carré
		
		Plante geantPlante = new Plante("haricot",PlanteCateg.FEUILLE,"geant de Jack",200);
		planteManager.addPlante(geantPlante);
		Plantation plantation2 = new Plantation(3,LocalDate.now(),LocalDate.now().plusMonths(2),carre2,geantPlante);
		try {
			plantationManager.addPlantation(plantation2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		*/
	}

	
}
