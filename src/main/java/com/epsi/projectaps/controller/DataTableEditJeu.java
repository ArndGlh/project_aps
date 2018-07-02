package com.epsi.projectaps.controller;


import com.epsi.projectaps.dao.JeuDao;
import com.epsi.projectaps.model.Jeu;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DataTableEditJeu implements Serializable {

    private List<Jeu> jeux;

    private Jeu selectedJeu;

    private JeuDao service;

    @PostConstruct
    public void init() {
        jeux = (List<Jeu>) (new JeuDao()).findAllJeu();
    }

    public List<Jeu> getJeux() {
        return jeux;
    }

    public void setService(JeuDao service) {
        this.service = service;
    }

    public Jeu getSelectedJeu() {
        return selectedJeu;
    }

    public void setSelectedJeu(Jeu selectedJeu) {
        this.selectedJeu = selectedJeu;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Jeu Edited", String.valueOf(((Jeu) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(((Jeu) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
