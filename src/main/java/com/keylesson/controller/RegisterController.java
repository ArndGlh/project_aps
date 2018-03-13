package com.keylesson.controller;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.keylesson.model.User;

@ManagedBean
@RequestScoped
public class RegisterController {

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RegisterController() {
		FacesContext.getCurrentInstance().getViewRoot()
				.setLocale(new Locale("en"));
	}

	public String addUser() {
		if (!user.getPassword().equals(user.getPasswordConfirm())) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Registration failure : passwords must match", ""));
		} else {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									"Congratulations, registration has been successful",
									""));
			user = null;
		}
		return null;
	}
}
