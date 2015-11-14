package com.projetdar.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetdar.entity.Avis;
import com.projetdar.entity.Musee;

/**
 * MuseeAvisDAOImpl est la classe qui implemente l'interface MuseeAvisDAO, et
 * permets d'interagir avec une base de donnees relationnels en utilisant le
 * framework Hibernate
 * 
 *
 */
@Repository
public class MuseeAvisDaoImpl implements MuseeAvisDAO {
	/**
	 * La variable sessionFactory est injecte par Spring
	 */
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// code des differentes methodes implementes, en utilisant le framework
	// Hibernate
	@Override
	public void addAvis(Avis avis, Long idMusee) {
		Musee musee = getMuseeById(idMusee);
		avis.setMusee(musee);
		this.sessionFactory.getCurrentSession().save(avis);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Avis> getAllAvisForMusee(Long idMusee) {
		Musee musee = getMuseeById(idMusee);
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Avis a where a.musee= :musee ")
				.setEntity("musee", musee).list();
	}

	@Override
	public Avis getAvisById(Long idAvis) {
		return (Avis) sessionFactory.getCurrentSession()
				.get(Avis.class, idAvis);
	}

	@Override
	public void deleteAvis(Long idAvis) {
		Avis avis = (Avis) this.sessionFactory.getCurrentSession().load(
				Avis.class, idAvis);
		if (null != avis) {
			this.sessionFactory.getCurrentSession().delete(avis);
		}

	}

	@Override
	public void addMusee(Musee musee) {
		this.sessionFactory.getCurrentSession().save(musee);
	}

	@Override
	public void updateMusee(Musee musee) {
		this.sessionFactory.getCurrentSession().merge(musee);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musee> getAllMusees() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Musee").list();
	}

	@Override
	public void deleteMusee(Long museeId) {
		this.sessionFactory.getCurrentSession().delete(getMuseeById(museeId));
	}

	@Override
	public Musee getMuseeById(Long idMusee) {
		return (Musee) this.sessionFactory.getCurrentSession().get(Musee.class,
				idMusee);
	}
}
