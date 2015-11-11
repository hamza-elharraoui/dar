package com.projetdar.dao;

import java.util.List;

import com.projetdar.entity.Admin;

/**
 * 
 * AdminDAO est l'interface qui regroupe les diff�rentes m�thodes de la couche
 * d'acc�es au donn�es des admins
 *
 */
public interface AdminDAO {
	/**
	 * Ajoute un administrateur de l'application
	 * 
	 * @param admin
	 *            l'objet admin
	 */
	public void addAdmin(Admin admin);

	/**
	 * R�cup�re la liste de tous les administrateurs de l'application
	 * 
	 * @return retourne liste des administeurs
	 */
	public List<Admin> getAllAdmins();

	/**
	 * Recupere la liste de tous les administrateurs de l'application sauf celui
	 * connecté
	 * 
	 * @param nom
	 *            nom de l'admin connecte
	 * @return retourne liste des administeurs
	 */
	public List<Admin> getOtherAdmins(String nom);

	/**
	 * permet de recuperer un administrateur en se basant sur son login
	 * 
	 * @param login
	 *            login de l'administrateur
	 */
	public Admin getAdminByLogin(String login);

	/**
	 * permet de r�cup�rer un administrateur en se basant sur son id
	 * 
	 * @param login
	 *            id de l'administrateur
	 */
	public Admin getAdminById(Long idAdmin);

	/**
	 * permet de modifier un administrateur
	 * 
	 * @param admin
	 *            objet administrateur � modifier
	 */
	public void updateAdmin(Admin admin);

	/**
	 * permet de supprimer un administrateur
	 * 
	 * @param idAdmin
	 *            id de l'administrateur
	 */
	public void deleteAdmin(Long idAdmin);
}