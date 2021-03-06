package com.projetdar.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetdar.entity.Admin;
import com.projetdar.entity.Avis;
import com.projetdar.entity.Musee;
import com.projetdar.service.AdminManager;
import com.projetdar.service.MuseeAvisManager;

public class EditMuseeAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;

	// Les objets Manager MuseeAvis et Admin, sont injectés par Spring
	private MuseeAvisManager museeAvisManager;
	private AdminManager adminManager;
	private List<Musee> listeMusees = new ArrayList<Musee>();
	private List<Admin> listeAdmins = new ArrayList<Admin>();
	private List<Avis> listeAvis;
	private Avis avis;
	private Musee musee;
	private Long idMusee;
	private Long idAvis;
	private File museeImage;
	private String museeImageContentType;
	private String museeImageFileName;

	// Cette methode s'execute avant la creation l'instantiation de
	// EditMuseeAction et l'invocation de chaque action, et permet
	// d'initialiser les objets envoyee depuis l'interface web avec la valeur
	// null afin d'eviter l'exception NullPointerException
	@Override
	public void prepare() throws Exception {
		musee = null;
		avis = null;
		idMusee = null;
		idAvis = null;
		museeImage = null;
	}

	// Action pour recuperer la liste des musees

	public String listMusees() {
		listeMusees = museeAvisManager.getAllMusees();
		return SUCCESS;
	}

	// Action pour se redireger ves le formulaire d'ajout d'un musee
	public String addMusee() {
		return SUCCESS;
	}

	// Action pour sauvegarder un musee dans la base de donnees
	public String saveAddMusee() {

		byte[] tabImage = null;
		FileInputStream fis;
		try {
			fis = new FileInputStream(museeImage);
			tabImage = IOUtils.toByteArray(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		musee.setImage(tabImage);
		musee.setNomImage(museeImageFileName);
		musee.setTypeImage(museeImageContentType);
		museeAvisManager.addMusee(musee);
		return SUCCESS;
	}

	// Action pour se redireger vers l'interface de mise a jour d'un musee
	public String updateMusee() {
		musee = museeAvisManager.getMuseeById(idMusee);
		return SUCCESS;
	}

	// Action pour sauvegarder la mise a jour
	public String saveUpdateMusee() {
		Musee m = museeAvisManager.getMuseeById(musee.getIdMusee());
		musee.setNomImage(museeImageFileName);
		musee.setTypeImage(museeImageContentType);
		if (museeImage == null) {
			musee.setImage(m.getImage());
			musee.setNomImage(m.getNomImage());
			musee.setTypeImage(m.getTypeImage());
		} else {
			byte[] tabImage = null;
			FileInputStream fis;
			try {
				fis = new FileInputStream(museeImage);
				tabImage = IOUtils.toByteArray(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			musee.setImage(tabImage);
			musee.setNomImage(museeImageFileName);
			musee.setTypeImage(museeImageContentType);
		}
		museeAvisManager.updateMusee(musee);
		return SUCCESS;
	}

	// Action pour supprimer un musee
	public String deleteMusee() {
		museeAvisManager.deleteMusee(idMusee);
		return SUCCESS;
	}

	// Action pour afficher un musee
	public String showMusee() {
		musee = museeAvisManager.getMuseeById(idMusee);
		listeMusees = museeAvisManager.getAllMusees();
		listeAvis = museeAvisManager.getAllAvisForMusee(idMusee);
		return SUCCESS;
	}

	// Action pour poster un avis
	public String postAvis() {
		museeAvisManager.addAvis(avis, idMusee);
		musee=museeAvisManager.getMuseeById(idMusee);
		avis=null;
		return SUCCESS;
	}

	// Action pour supprimer un avis
	public String deleteAvis() {

		// Dans ce code on parcours la liste des avis appartenant à un musee et
		// on supprime l'avis qu'on veut supprimer

		Musee m = museeAvisManager.getMuseeById(idMusee);
		List<Avis> listeA = m.getAvis();
		int i = 0;
		for (Avis a : listeA) {
			if (a.getIdAvis().compareTo(idAvis) == 0) {
				listeA.remove(i);
				break;
			}
			i++;
		}
		m.setAvis(listeA);
		museeAvisManager.updateMusee(m);
		musee=m;
		return SUCCESS;
	}

	// Action pour obtenir l'interface de l'administration de l'application
	public String editMusees() {
		Map<String, Object> sessionAttributes = ActionContext.getContext()
				.getSession();

		Admin a = (Admin) sessionAttributes.get("admin");
		listeAdmins = adminManager.getOtherAdmins(a.getLogin());
		listeMusees = museeAvisManager.getAllMusees();
		return SUCCESS;
	}

	// Getters and Setters pour les differents objets echangees entre l'action
	// et l'interface utilisateur

	public void setListeMusees(List<Musee> listeMusees) {
		this.listeMusees = listeMusees;
	}

	public void setListeAvis(List<Avis> listeAvis) {
		this.listeAvis = listeAvis;
	}

	public void setAvis(Avis avis) {
		this.avis = avis;
	}

	public void setMusee(Musee musee) {
		this.musee = musee;
	}

	public void setIdMusee(Long idMusee) {
		this.idMusee = idMusee;
	}

	public List<Musee> getListeMusees() {
		return listeMusees;
	}

	public List<Avis> getListeAvis() {
		return listeAvis;
	}

	public Avis getAvis() {
		return avis;
	}

	public Musee getMusee() {
		return musee;
	}

	public MuseeAvisManager getMuseeAvisManager() {
		return museeAvisManager;
	}

	public Long getIdMusee() {
		return idMusee;
	}

	public Long getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(Long idAvis) {
		this.idAvis = idAvis;
	}

	public File getMuseeImage() {
		return museeImage;
	}

	public void setMuseeImage(File museeImage) {
		this.museeImage = museeImage;
	}

	public String getMuseeImageContentType() {
		return museeImageContentType;
	}

	public void setMuseeImageContentType(String museeImageContentType) {
		this.museeImageContentType = museeImageContentType;
	}

	public String getMuseeImageFileName() {
		return museeImageFileName;
	}

	public void setMuseeImageFileName(String museeImageFileName) {
		this.museeImageFileName = museeImageFileName;
	}

	public List<Admin> getListeAdmins() {
		return listeAdmins;
	}

	public void setListeAdmins(List<Admin> listeAdmins) {
		this.listeAdmins = listeAdmins;
	}

	/*
	 * les deux setters setMuseeAvisManager setAdminManager vont être utilsés
	 * par Spring pour l'injection des dépendances
	 */
	public void setMuseeAvisManager(MuseeAvisManager museeAvisManager) {
		this.museeAvisManager = museeAvisManager;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}
}
