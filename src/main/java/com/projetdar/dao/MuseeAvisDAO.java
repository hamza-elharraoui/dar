package com.projetdar.dao;

import java.util.List;

import com.projetdar.entity.Avis;
import com.projetdar.entity.Musee;



/**
 * 
 * MuseeAvisDAO est l'interface qui regroupe les differentes  methodes de la
 * couche d'accees au donnees des avis et des musees
 *
 */
public interface MuseeAvisDAO {
	/**
	 * Ajoute un avis d'un utilisateur vis-e-vis d'un musee
	 * 
	 * @param avis
	 *            l'objet avis
	 * @param idMusee
	 *            l'id du musee pour lesquel appartient l'avis
	 */
	public void addAvis(Avis avis, Long idMusee);

	/**
	 * Recuperer la liste des avis des visiteurs de l'application par rapport a
	 * un musee donnee
	 * 
	 * @param idMusee
	 *            L'id du musee
	 * @return retourne liste des avis
	 */
	public List<Avis> getAllAvisForMusee(Long idMusee);

	/**
	 * Recuperer un avis relatif a un musee en se basant sur son id
	 * 
	 * @param idAvis
	 *            L'id de l'avis
	 * @return retourne l'objet avis recherche
	 */
	public Avis getAvisById(Long idAvis);

	/**
	 * supprime un avis
	 * 
	 * @param idAvis
	 *            l'id de l'avis
	 */
	public void deleteAvis(Long idAvis);

	/**
	 * Ajoute un musee 
	 * 
	 * @param musee
	 *            un objet de classe Musee
	 */
	public void addMusee(Musee musee);

	/**
	 * Retourne un musee existant en entrant son id
	 * 
	 * @param idMusee
	 * @return objet musee
	 */
	public Musee getMuseeById(Long idMusee);

	/**
	 * permet de modifier les informations d'un musee deja existant
	 * 
	 * @param musee
	 *            instance de classe Musee
	 */
	public void updateMusee(Musee musee);

	/**
	 * Retourne tous les musees existants dans la base de donnees
	 * 
	 * @return liste des musees
	 */
	public List<Musee> getAllMusees();

	/**
	 * Supprime un musee de la base de donnees
	 * 
	 * @param museeId
	 *            l'id du musee a supprimer
	 */
	public void deleteMusee(Long idMusee);
}