package com.epsi.projectaps.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.epsi.projectaps.dao.UserDao;
import com.epsi.projectaps.model.User;
import org.primefaces.event.ToggleEvent;

@ManagedBean
@RequestScoped
public class RegisterController {
    private static final String ACCUEIL_REDIRECT = "accueil";
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failure : passwords must match", ""));
        } else {
            UserDao userDao = new UserDao();
            if (userDao.addUser(user) == 1) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Congratulations, registration has been successful", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failure : A problem occur during registration", ""));
                return "index.xhtml";
            }
            user = null;
        }
        return "accueil.xhtml";
    }

    public String verifyUser() {
        try {
            boolean currentUser = new UserDao().findUser(user).first();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            if (currentUser) {
                System.out.println("1current user : "+currentUser);
                session.setAttribute("user", user);
                return ACCUEIL_REDIRECT;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed!", ""));
                System.out.println("2current user : "+currentUser);
                return null;
            }
        } catch (Exception e) {
            // Handle unknown username/password
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed!", ""));
            return null;
        }
    }


    // ==================================================================
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
