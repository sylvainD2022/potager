package fr.eni.potager.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Plante {
	@Id
	@GeneratedValue
	private Integer idPlante;
	
	private String nom;
	private PlanteCateg type;
	private String variete;
	private Integer surfaceOccupe;
	
	@OneToMany(mappedBy = "plante")
	@ToString.Exclude
	private Set<Plantation> lstPlantations = new HashSet<>();
	
	public Plante(String nom, PlanteCateg racine, String variete, Integer surfaceOccupe) {
		super();
		this.nom = nom;
		this.type = racine;
		this.variete = variete;
		this.surfaceOccupe = surfaceOccupe;
	}

	public void doDependency(Plantation plantation) {
		plantation.setPlante(this);
		lstPlantations.add(plantation);
	}
}
