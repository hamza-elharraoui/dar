package com.projetdar.dao;

import java.util.List;

import com.projetdar.entity.Avis;
import com.projetdar.entity.Musee;

/**
 * 
 * MuseeAvisDAO est l'interface qui regroupe les diff�rentes m�thodes de la
 * couche d'acc�es au donn�es des avis et des mus�es
 *
 */
public interface MuseeAvisDAO {
	/**
	 * Ajoute un avis d'un utilisateur vis-�-vis d'un mus�e
	 * 
	 * @param avis
	 *            l'objet avis
	 * @param idMusee
	 *            l'id du mus�e pour lesquel appartient l'avis
	 */
	public void addAvis(Avis avis, Long idMusee);

	/**
	 * R�cup�re la liste des avis des visiteurs de l'application par rapport �
	 * un mus�e donn�e
	 * 
	 * @param idMusee
	 *            L'id du mus�e
	 * @return retourne liste des avis
	 */
	public List<Avis> getAllAvisForMusee(Long idMusee);

	/**
	 * R�cup�re un avis relatif � un mus�e en se basant sur son id
	 * 
	 * @param idAvis
	 *            L'id de l'avis
	 * @return retourne l'objet avis recherch�
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
	 * Ajoute un mus�e
	 * 
	 * @param musee
	 *            un objet de classe Musee
	 */
	public void addMusee(Musee musee);

	/**
	 * Retourne un mus�e existant en entrant son id
	 * 
	 * @param idMusee
	 * @return objet mus�e
	 */
	public Musee getMuseeById(Long idMusee);

	/**
	 * permet de modifier les informations d'un mus�e d�j� existant
	 * 
	 * @param musee
	 *            instance de classe Mus�e
	 */
	public void updateMusee(Musee musee);

	/**
	 * Retourne tous les mus�es existants dans la base de donn�es
	 * 
	 * @return liste des mus�es
	 */
	public List<Musee> getAllMusees();

	/**
	 * Supprime un mus�e de la base de donn�es
	 * 
	 * @param museeId
	 *            l'id du mus�e � supprimer
	 */
	public void deleteMusee(Long idMusee);
}