package fr.eni.potager.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Carre {
	@Id
	@GeneratedValue
	private Integer idCarre;
	
	@ManyToOne
	private Potager potager;
	private Integer surface;
	private String typeSol;
	private TypeExposition typeExposition;
	
	@OneToMany(mappedBy = "carre")
	@ToString.Exclude
	private Set<Plantation> lstPlantations = new HashSet<>();
	
	public Carre(Potager potager, Integer surface, String typeSol, TypeExposition typeExposition) {
		super();
		this.potager = potager;
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExposition = typeExposition;
		potager.doDependency(this);
	}
	
	public void doDependency(Plantation plantation) {
		plantation.setCarre(this);
		lstPlantations.add(plantation);
	}
	
}
