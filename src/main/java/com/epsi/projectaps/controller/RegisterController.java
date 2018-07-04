package com.epsi.projectaps.controller;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import com.epsi.projectaps.dao.UserDao;
import com.epsi.projectaps.model.User;

@Named
@SessionScoped
public class RegisterController implements Serializable{
    private static final String ACCUEIL_REDIRECT = "espacePerso/accueil";
    private static final String LOGIN_REDIRECT = "/index.xhtml";
    private static final String REGISTER_REDIRECT = "register";

    private String userName;
    private String password;
    private String passwordConfirm;
    private String userMail;
    private User user = new User();

    public RegisterController() {

    }

    public String addUser() throws SQLException {
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failure : passwords must match", ""));
        } else {
            UserDao userDao = new UserDao();
            if(!userDao.findUser(user).first()) {
                if (userDao.addUser(user) == 1) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Congratulations, registration has been successful", ""));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failure : A problem occur during registration", ""));
                    return LOGIN_REDIRECT;
                }
            }else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failure : A problem occur during registration", ""));
                return REGISTER_REDIRECT;
            }
            user = null;
        }
        return ACCUEIL_REDIRECT;
    }

    public String verifyUser() {
        try {
            user.setUserName(userName);
            user.setPassword(password);
            boolean currentUser = new UserDao().findUser(user).first();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            if (currentUser) {
                user.setAuthenticated(true);
                return ACCUEIL_REDIRECT;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed!", ""));
                return null;
            }
        } catch (Exception e) {
            // Handle unknown username/password
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed!", ""));
            return null;
        }
    }

    public String logout() {
        user.setAuthenticated(false);
        return LOGIN_REDIRECT;
    }

    public boolean isLoggedIn() {
        return user.isAuthenticated();
    }

    // ==================================================================
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
