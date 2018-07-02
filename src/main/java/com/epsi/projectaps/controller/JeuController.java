package com.epsi.projectaps.controller;

import com.epsi.projectaps.dao.EventDao;
import com.epsi.projectaps.dao.JeuDao;
import com.epsi.projectaps.model.Event;
import com.epsi.projectaps.model.Jeu;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@ManagedBean
@RequestScoped
public class JeuController {

    private Jeu jeu = new Jeu();
    private String nom;
    private String regles;
    private boolean de;
    private boolean carte;
    private int nombreJoueurMini;
    private int nombreJoueurMax;

    public JeuController() {
        FacesContext.getCurrentInstance().getViewRoot()
                .setLocale(new Locale("en"));
    }

    public String addJeu() throws SQLException {
        JeuDao jeuDao = new JeuDao();
        jeu = new Jeu(nom, regles, de, carte, nombreJoueurMini, nombreJoueurMax);
        if (jeuDao.addJeu(jeu) == 1) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Congratulations, Game adding has been successful",
                            ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Game adding failure : A problem occur during gmae adding", ""));
        }
        jeu = null;
        return null;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegles() {
        return regles;
    }

    public void setRegles(String regles) {
        this.regles = regles;
    }

    public boolean isDe() {
        return de;
    }

    public void setDe(boolean de) {
        this.de = de;
    }

    public boolean isCarte() {
        return carte;
    }

    public void setCarte(boolean carte) {
        this.carte = carte;
    }

    public int getNombreJoueurMini() {
        return nombreJoueurMini;
    }

    public void setNombreJoueurMini(int nombreJoueurMini) {
        this.nombreJoueurMini = nombreJoueurMini;
    }

    public int getNombreJoueurMax() {
        return nombreJoueurMax;
    }

    public void setNombreJoueurMax(int nombreJoueurMax) {
        this.nombreJoueurMax = nombreJoueurMax;
    }
}