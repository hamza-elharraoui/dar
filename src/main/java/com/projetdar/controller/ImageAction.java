package com.projetdar.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.projetdar.service.MuseeAvisManager;
// C'est la classe responsable de recuperer une image  
public class ImageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte[] imageInByte = null;
	private Long idMusee;

	private MuseeAvisManager museeAvisManager;

	public String execute() {
		return SUCCESS;
	}

	public byte[] getCustomImageInBytes() {

		imageInByte = museeAvisManager.getMuseeById(idMusee).getImage();
		return imageInByte;
	}

	public String getCustomContentType() {
		return museeAvisManager.getMuseeById(idMusee).getTypeImage();
	}

	public MuseeAvisManager getMuseeAvisManager() {
		return museeAvisManager;
	}

	public void setMuseeAvisManager(MuseeAvisManager museeAvisManager) {
		this.museeAvisManager = museeAvisManager;
	}

	public Long getIdMusee() {
		return idMusee;
	}

	public void setIdMusee(Long idMusee) {
		this.idMusee = idMusee;
	}
}