package com.projetdar.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetdar.dao.MuseeAvisDAO;
import com.projetdar.entity.Avis;
import com.projetdar.entity.Musee;

public class MuseeAvisManagerImpl implements MuseeAvisManager {

	private MuseeAvisDAO museeAvisDAO;

	public void setMuseeAvisDAO(MuseeAvisDAO museeAvisDAO) {
		this.museeAvisDAO = museeAvisDAO;
	}

	@Override
	@Transactional
	public void addAvis(Avis avis, Long idMusee) {
		museeAvisDAO.addAvis(avis, idMusee);
	}

	@Override
	@Transactional
	public List<Avis> getAllAvisForMusee(Long idMusee) {

		return museeAvisDAO.getAllAvisForMusee(idMusee);
	}

	@Override
	@Transactional
	public Avis getAvisById(Long idAvis) {

		return museeAvisDAO.getAvisById(idAvis);
	}

	@Override
	@Transactional
	public void deleteAvis(Long idAvis) {
		museeAvisDAO.deleteAvis(idAvis);
	}

	@Override
	@Transactional
	public void addMusee(Musee musee) {
		museeAvisDAO.addMusee(musee);
	}

	@Override
	@Transactional
	public Musee getMuseeById(Long idMusee) {
		return museeAvisDAO.getMuseeById(idMusee);
	}

	@Override
	@Transactional
	public void updateMusee(Musee musee) {
		museeAvisDAO.updateMusee(musee);
	}

	@Override
	@Transactional
	public List<Musee> getAllMusees() {
		return museeAvisDAO.getAllMusees();
	}

	@Override
	@Transactional
	public void deleteMusee(Long idMusee) {
		museeAvisDAO.deleteMusee(idMusee);
	}

}
