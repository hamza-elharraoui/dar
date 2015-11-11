package com.projetdar.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projetdar.entity.Admin;
import com.projetdar.service.AdminManager;

public class LoginAction extends ActionSupport implements SessionAware,
		ModelDriven<Admin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	private Map<String, Object> sessionAttributes = null;
	private AdminManager adminManager;

	@Override
	public String execute() {
		System.out.println("A l'intérieur de l'action LoginAction");
		Admin a = adminManager.getAdminByLogin(admin.getLogin());
		if (a != null) {
			if (a.getPassword().equals(admin.getPassword())) {
				sessionAttributes.put("admin", admin);
				return SUCCESS;
			}
			addActionError("Erreur d'authentification : Mot de passe ou Login erroné");
			admin=null;
			return ERROR;
		}
		addActionError("Erreur d'authentification : Mot de passe ou Login erroné");
		admin=null;
		return ERROR;

	}

	public String deleteSession() {
		sessionAttributes = ActionContext.getContext().getSession();
		sessionAttributes.clear();
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

}
