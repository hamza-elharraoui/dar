package com.projetdar.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.projetdar.entity.Admin;

public class AuhtenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = -5011962009065225959L;

	@Override
	public void destroy() {
		// Destruction des ressources crees après l'execution de l'interceptor
	}

	@Override
	public void init() {
		// Creation des ressources avant l'exécution de l'interceptor
	}

	// C'est la methode qui s'excute quand on a une action qui necessite
	// l'authentification
	// elle permet de recuperer la session courante, verifier est ce que
	// l'utilisateur est bien authentifie, et apres invoque l'intercepteur
	// suivant dans le stack des intercepteurs
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("A l'intérieur de l'intercepteur");
		Map<String, Object> sessionAttributes = actionInvocation
				.getInvocationContext().getSession();

		Admin admin = (Admin) sessionAttributes.get("admin");

		if (sessionAttributes == null || admin == null) {
			return Action.INPUT;
		} else {
			Action action = (Action) actionInvocation.getAction();
			if (!(admin.getLogin() == null && admin.getPassword() == null)) {
				if (action instanceof AdminAware) {
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
					((AdminAware) action).setAdmin(admin);
				}
				return actionInvocation.invoke();
			} else {
				return Action.INPUT;
			}

		}
	}
}
