package com.projetdar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Musee est la classe qui repr�sente un mus�e de Paris
 * 
 */
@Entity
@Table(name = "musee")
public class Musee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MUSEE")
	private Long idMusee;
	@Column(name = "NOM", nullable = false)
	private String nom;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "ADRESSE", nullable = false)
	private String adresse;
	@Column(name = "URL", nullable = false)
	private String url;
	// @Column(name = "IMAGE", nullable = false)
	// private String image;
	@Lob
	@Column(name = "IMAGE")
	private byte[] image;
	@Column(name = "NOM_IMAGE", nullable = false)
	private String nomImage;
	@Column(name = "TYPE_IMAGE", nullable = false)
	private String typeImage;
	@OneToMany(mappedBy = "musee", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Avis> avis = new ArrayList<Avis>();

	public Musee() {
	}

	public Musee(String nom, String description, String adresse, String url,
			byte[] image, String nomImage, String typeImage) {
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.url = url;
		this.image = image;
		this.nomImage = nomImage;
		this.typeImage = typeImage;
	}

	public Long getIdMusee() {
		return idMusee;
	}

	public void setIdMusee(Long idMusee) {
		this.idMusee = idMusee;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// public String getImage() {
	// return image;
	// }
	//
	// public void setImage(String image) {
	// this.image = image;
	// }
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getTypeImage() {
		return typeImage;
	}

	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

}
