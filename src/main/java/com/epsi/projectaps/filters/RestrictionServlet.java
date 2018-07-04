package com.epsi.projectaps.filters;


import com.epsi.projectaps.controller.RegisterController;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictionServlet extends HttpServlet {
    public static final String ACCES_PUBLIC = "/index.xhtml";
    public static final String ACCES_RESTREINT = "/espacePerso/";
    public static final String ATT_SESSION_USER = "user";

    @Inject
    RegisterController registerController;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if (!registerController.isLoggedIn()) {
            response.sendRedirect(request.getContextPath() + ACCES_PUBLIC);
        } else {
            request.getRequestDispatcher(ACCES_RESTREINT);
            this.getServletContext().getRequestDispatcher(ACCES_RESTREINT).forward(request, response);
        }
    }
}