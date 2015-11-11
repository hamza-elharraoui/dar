package com.projetdar.service;

import java.util.List;

import com.projetdar.entity.Avis;
import com.projetdar.entity.Musee;

public interface MuseeAvisManager {
	public void addAvis(Avis avis, Long idMusee);

	public List<Avis> getAllAvisForMusee(Long idMusee);

	public Avis getAvisById(Long idAvis);

	public void deleteAvis(Long idAvis);

	public void addMusee(Musee musee);

	public Musee getMuseeById(Long idMusee);

	public void updateMusee(Musee musee);

	public List<Musee> getAllMusees();

	public void deleteMusee(Long idMusee);

}
