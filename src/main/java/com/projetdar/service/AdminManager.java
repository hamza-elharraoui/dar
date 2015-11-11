package com.projetdar.service;

import java.util.List;

import com.projetdar.entity.Admin;

public interface AdminManager {

	public void addAdmin(Admin admin);

	public List<Admin> getAllAdmins();

	public List<Admin> getOtherAdmins(String nom);

	public Admin getAdminByLogin(String login);

	public Admin getAdminById(Long idAdmin);

	public void updateAdmin(Admin admin);

	public void deleteAdmin(Long idAdmin);
}
