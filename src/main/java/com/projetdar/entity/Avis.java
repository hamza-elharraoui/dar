package com.projetdar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cette classe represente un avis concernant un des musee de Paris
 * 
 *
 */
@Entity
@Table(name = "avis")
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AVIS")
	private Long idAvis;
	@Column(name = "NOM",nullable=false)
	private String nom;
	@Column(name = "DESCRIPTION",nullable=false)
	private String description;
	@ManyToOne
	@JoinColumn(name = "ID_MUSEE")
	private Musee musee;

	public Avis() {
	}

	public Avis(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public Long getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(Long idAvis) {
		this.idAvis = idAvis;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Musee getMusee() {
		return musee;
	}

	public void setMusee(Musee musee) {
		this.musee = musee;
	}
}
