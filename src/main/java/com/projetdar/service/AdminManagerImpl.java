package com.projetdar.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetdar.dao.AdminDAO;
import com.projetdar.entity.Admin;

public class AdminManagerImpl implements AdminManager {
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public void addAdmin(Admin admin) {
		adminDAO.addAdmin(admin);
	}

	@Override
	@Transactional
	public List<Admin> getAllAdmins() {
		return adminDAO.getAllAdmins();
	}

	@Override
	@Transactional
	public Admin getAdminByLogin(String login) {
		return adminDAO.getAdminByLogin(login);
	}

	@Override
	@Transactional
	public Admin getAdminById(Long idAdmin) {
		return adminDAO.getAdminById(idAdmin);
	}

	@Override
	@Transactional
	public void updateAdmin(Admin admin) {
		adminDAO.updateAdmin(admin);
	}

	@Override
	@Transactional
	public void deleteAdmin(Long idAdmin) {
		adminDAO.deleteAdmin(idAdmin);
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	@Transactional
	public List<Admin> getOtherAdmins(String nom) {
		return adminDAO.getOtherAdmins(nom);
		
	}

}
