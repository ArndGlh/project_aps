package com.epsi.projectaps.model;

public class Jeu {

    private int id;
    private String nom;
    private String regles;
    private boolean de;
    private boolean carte;
    private int nombreJoueurMini;
    private int nombreJoueurMax;

    public Jeu() {}

    public Jeu(String nom, String regles, boolean de, boolean carte, int nombreJoueurMini, int nombreJoueurMax) {
        this.nom = nom;
        this.regles = regles;
        this.de = de;
        this.carte = carte;
        this.nombreJoueurMini = nombreJoueurMini;
        this.nombreJoueurMax = nombreJoueurMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
