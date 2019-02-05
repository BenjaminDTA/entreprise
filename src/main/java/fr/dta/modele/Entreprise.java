package fr.dta.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "entrepriseSeq", allocationSize = 100)
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrepriseSeq")
	@Column
	private Long id;
	
	@Column
	private String nom;
	
	@OneToMany(mappedBy = "entreprise")
	private List<Employee> listeEmp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Employee> getListeEmp() {
		return listeEmp;
	}

	public void setListeEmp(List<Employee> listeEmp) {
		this.listeEmp = listeEmp;
	}

}
