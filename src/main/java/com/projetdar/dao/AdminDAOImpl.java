package com.projetdar.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetdar.entity.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {
	/**
	 * La variable sessionFactory est inject� par Spring
	 */
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAllAdmins() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Admin").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getOtherAdmins(String nom) {
		List<Admin> admins = this.sessionFactory.getCurrentSession()
				.createQuery("from Admin a where a.login <> :login ")
				.setString("login", nom).list();
		return admins;
	}

	@Override
	public Admin getAdminByLogin(String login) {
		return (Admin) this.sessionFactory.getCurrentSession()
				.createQuery("from Admin a where a.login= :login ")
				.setString("login", login).uniqueResult();
	}

	@Override
	public Admin getAdminById(Long idAdmin) {
		return (Admin) this.sessionFactory.getCurrentSession().get(Admin.class,
				idAdmin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().merge(admin);
	}

	@Override
	public void deleteAdmin(Long idAdmin) {
		this.sessionFactory.getCurrentSession().delete(getAdminById(idAdmin));
	}

}
