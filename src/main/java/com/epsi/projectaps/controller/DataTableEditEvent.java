package com.epsi.projectaps.controller;

import com.epsi.projectaps.dao.EventDao;
import com.epsi.projectaps.model.Event;
import com.epsi.projectaps.model.Jeu;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DataTableEditEvent implements Serializable{

    private List<Event> events;

    private Event selectedEvent;

    private EventDao service;

    @PostConstruct
    public void init() {
        events = (List<Event>) (new EventDao()).findAllEvent();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setService(EventDao service) {
        this.service = service;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Event Edited", String.valueOf(((Event) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(((Jeu) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
