package fr.eni.potager.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Potager {
	@Id
	@GeneratedValue
	private Integer idPotager;
	
	private String localisation;
	private String nom;
	private Integer surface;
	private String ville;
	
	@OneToMany(mappedBy = "potager")
	@ToString.Exclude
	private Set<Carre> lstCarres = new HashSet<>();
	
	public Potager(String localisation, String nom, Integer surface, String ville) {
		super();
		this.localisation = localisation;
		this.nom = nom;
		this.surface = surface;
		this.ville = ville;
	}
	
	public void doDependency(Carre carre) {
		carre.setPotager(this);
		lstCarres.add(carre);
	}
}