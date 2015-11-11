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
		// Destruction des ressources crées après l'exécution de l'interceptor
	}

	@Override
	public void init() {
		// Création des ressources avant l'exécution de l'interceptor
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("A l'intérieur de l'intercepteur");
		Map<String, Object> sessionAttributes = actionInvocation
				.getInvocationContext().getSession();

		Admin admin = (Admin) sessionAttributes.get("admin");

		if (admin == null) {
			return Action.LOGIN;
		} else {
			Action action = (Action) actionInvocation.getAction();
			if (action instanceof AdminAware) {
				((AdminAware) action).setAdmin(admin);
			}
			return actionInvocation.invoke();
		}
	}

}
