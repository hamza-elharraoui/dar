package com.projetdar.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// c'est la fonction responsable du cryptage du mot de passe de l'admin, afin de ne stocker dans la BD que le mot de passe crypte
// Nous utilisons ici l'algorithme du cryptage MD5

public class CryptWithMD5 {
	private static MessageDigest md;

	public static String cryptWithMD5(String pass) {
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			System.out.println(ex.getMessage());
		}
		return null;

	}
}