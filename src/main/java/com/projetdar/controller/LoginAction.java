package com.projetdar.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projetdar.entity.Admin;
import com.projetdar.service.AdminManager;
import com.projetdar.service.CryptWithMD5;
import com.projetdar.service.MuseeAvisManager;

public class LoginAction extends ActionSupport implements SessionAware,
		ModelDriven<Admin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	private Map<String, Object> sessionAttributes = null;
	private AdminManager adminManager;
//	private MuseeAvisManager museeAvisManager;

	@Override
	public String execute() {
		System.out.println("A l'intérieur de l'action LoginAction");
		Admin a = adminManager.getAdminByLogin(admin.getLogin());
		if (a != null) {
			if (a.getPassword().equals(
					CryptWithMD5.cryptWithMD5(admin.getPassword()))) {
				sessionAttributes.put("admin", admin);
				return SUCCESS;
			} else {
				// addActionError("Erreur d'authentification : Mot de passe erroné");
				admin = new Admin();
				sessionAttributes.remove(admin);
				return ERROR;
			}
		}
		// addActionError("Erreur d'authentification : Login erroné");
		admin = new Admin();
		sessionAttributes.remove(admin);
		return ERROR;

	}

	public String deleteSession() {
		sessionAttributes = ActionContext.getContext().getSession();
		sessionAttributes.remove("admin");
		return SUCCESS;
	}

	@Override
	public Admin getModel() {
		return admin;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

//	public void setMuseeAvisManager(MuseeAvisManager museeAvisManager) {
//		this.museeAvisManager = museeAvisManager;
//	}

}
