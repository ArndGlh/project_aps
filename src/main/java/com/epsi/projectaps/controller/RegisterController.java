package com.epsi.projectaps.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.epsi.projectaps.dao.UserDao;
import com.epsi.projectaps.model.User;
import org.primefaces.event.ToggleEvent;

@ManagedBean
@RequestScoped
public class RegisterController {

	private User user = new User();

	public RegisterController() {
		FacesContext.getCurrentInstance().getViewRoot()
				.setLocale(new Locale("en"));
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String addUser() throws SQLException {
		if (!user.getPassword().equals(user.getPasswordConfirm())) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Registration failure : passwords must match", ""));
		} else {
			UserDao userDao = new UserDao();
			if(userDao.addUser(user) == 1) {
				FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_INFO,
										"Congratulations, registration has been successful",
										""));
			}else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Registration failure : A problem occur during registration", ""));
			}
			user = null;
		}
		return null;
	}


	// ==================================================================
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
