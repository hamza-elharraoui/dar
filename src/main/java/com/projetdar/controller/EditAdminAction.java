package com.projetdar.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetdar.entity.Admin;
import com.projetdar.service.AdminManager;

public class EditAdminAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;

	private List<Admin> admins;
	private Admin admin;
	private AdminManager adminManager;

	// This method return list of admins in database
	public String listAdmins() {
		admins = adminManager.getAllAdmins();
		return SUCCESS;
	}

	// This method will be called when a admin object is added
	public String addAdmin() {
		adminManager.addAdmin(admin);
		return SUCCESS;
	}

	// Deletes a admin by it's id passed in path parameter
	public String deleteAdmin() {
		adminManager.deleteAdmin(admin.getIdAdmin());
		return SUCCESS;
	}

	// This method will be called before any of Action method is invoked;
	// So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		admin = null;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
