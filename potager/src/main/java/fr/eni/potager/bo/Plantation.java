package fr.eni.potager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plantation {
	@Id
	@GeneratedValue
	private Integer idPlantation;
	private Integer nbPlants;
	private LocalDate  dateSemis;
	private LocalDate dateRecolteP;
	
	@ManyToOne
	private Carre carre;
	@ManyToOne
	private Plante plante;
	
	public Plantation(Integer nbPlants, LocalDate dateSemis, LocalDate dateRecolteP, Carre carre, Plante plante) {
		super();
		this.nbPlants = nbPlants;
		this.dateSemis = dateSemis;
		this.dateRecolteP = dateRecolteP;
		this.carre = carre;
		this.plante = plante;
		carre.doDependency(this);
		plante.doDependency(this);
	}

}
