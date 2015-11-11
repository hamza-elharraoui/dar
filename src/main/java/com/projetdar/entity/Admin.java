package com.projetdar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cette classe repr�sente un admin de l'application
 * 
 *
 */
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADMIN")
	private Long idAdmin;
	@Column(name = "NOM", nullable = false)
	private String nom;
	@Column(name = "LOGIN", unique = true, nullable = false)
	private String login;
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	public Admin() {
	}

	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Admin(String nom, String login, String email, String password) {
		super();
		this.nom = nom;
		this.login = login;
		this.email = email;
		this.password = password;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
