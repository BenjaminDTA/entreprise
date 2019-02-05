package fr.dta.modele;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import fr.dta.repository.IoEntity;

@Entity
public class Employee implements IoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;

	@Column
	private String prenom;

	@Column
	private String nom;

	@Column
	private String numeroSecu;

	@Column
	private BigDecimal salaire;

	@Column
	private LocalDate dateEmbauche;

	@ManyToOne
	private Entreprise entreprise;

	public Employee(String p, String n, String num, BigDecimal s, LocalDate d) {
		prenom = p;
		nom = n;
		numeroSecu = num;
		salaire = s;
		dateEmbauche = d;
	}
	
	public Employee() {};

	public String toString() {
		return id + " " + prenom + " " + nom + " " + numeroSecu + " " + salaire + " " + dateEmbauche;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal selaire) {
		this.salaire = selaire;
	}

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
