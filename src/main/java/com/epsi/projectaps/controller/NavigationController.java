package com.epsi.projectaps.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean
@RequestScoped
public class NavigationController {
    private static final String ACCUEIL_PAGE = "accueil";
    private static final String EVENT_PAGE = "event";
    private static final String JEU_PAGE = "jeu";
    private static final String LOGIN_PAGE = "index";
    private static final String REGISTER_PAGE = "register";

    public void isLoggedIn() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        if(session.getAttribute("user") == null) {
            session.setAttribute("page", "login");
            facesContext.getExternalContext().redirect("");
        }
        /*else {
            // TODO il faut faire en sorte que si l'utilisateur est connecté alors au rechargement on charge la page courante et non le login !! Je galère
            facesContext.getExternalContext().redirect(goTo((String) session.getAttribute("page")) + ".xhtml");
        }*/
    }

    public String goTo(String chemin) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        if(chemin.equals("login")) {
            session.setAttribute("page", "login");
            return LOGIN_PAGE;
        }
        if(chemin.equals("register")) {
            session.setAttribute("page", "register");
            return REGISTER_PAGE;
        }
        if(session.getAttribute("user") == null) {
            session.setAttribute("page", "login");
            return LOGIN_PAGE;
        }
        if(chemin.equals("home")) {
            session.setAttribute("page", "home");
            return ACCUEIL_PAGE;
        }
        else if(chemin.equals("event")) {
            session.setAttribute("page", "event");
            return EVENT_PAGE;
        }
        else if(chemin.equals("jeu")) {
            session.setAttribute("page", "jeu");
            return JEU_PAGE;
        }
        return null;
    }


}
