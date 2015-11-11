package com.projetdar.dao;

import java.util.List;

import com.projetdar.entity.Avis;
import com.projetdar.entity.Musee;

/**
 * 
 * MuseeAvisDAO est l'interface qui regroupe les différentes méthodes de la
 * couche d'accées au données des avis et des musées
 *
 */
public interface MuseeAvisDAO {
	/**
	 * Ajoute un avis d'un utilisateur vis-à-vis d'un musée
	 * 
	 * @param avis
	 *            l'objet avis
	 * @param idMusee
	 *            l'id du musée pour lesquel appartient l'avis
	 */
	public void addAvis(Avis avis, Long idMusee);

	/**
	 * Récupère la liste des avis des visiteurs de l'application par rapport à
	 * un musée donnée
	 * 
	 * @param idMusee
	 *            L'id du musée
	 * @return retourne liste des avis
	 */
	public List<Avis> getAllAvisForMusee(Long idMusee);

	/**
	 * Récupère un avis relatif à un musée en se basant sur son id
	 * 
	 * @param idAvis
	 *            L'id de l'avis
	 * @return retourne l'objet avis recherché
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
	 * Ajoute un musée
	 * 
	 * @param musee
	 *            un objet de classe Musee
	 */
	public void addMusee(Musee musee);

	/**
	 * Retourne un musée existant en entrant son id
	 * 
	 * @param idMusee
	 * @return objet musée
	 */
	public Musee getMuseeById(Long idMusee);

	/**
	 * permet de modifier les informations d'un musée déjà existant
	 * 
	 * @param musee
	 *            instance de classe Musée
	 */
	public void updateMusee(Musee musee);

	/**
	 * Retourne tous les musées existants dans la base de données
	 * 
	 * @return liste des musées
	 */
	public List<Musee> getAllMusees();

	/**
	 * Supprime un musée de la base de données
	 * 
	 * @param museeId
	 *            l'id du musée à supprimer
	 */
	public void deleteMusee(Long idMusee);
}