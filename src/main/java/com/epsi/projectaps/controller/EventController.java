package com.epsi.projectaps.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.epsi.projectaps.dao.EventDao;
import com.epsi.projectaps.dao.UserDao;
import com.epsi.projectaps.model.Event;
import com.epsi.projectaps.model.User;

@ManagedBean
@RequestScoped
public class EventController {

    private Event event = new Event();
    private Date date;
    private String name;
    private String lieu;
    private String description;

    public EventController() {
        FacesContext.getCurrentInstance().getViewRoot()
                .setLocale(new Locale("en"));
    }

    public String addEvent() throws SQLException {
        EventDao eventDao = new EventDao();
        LocalDate lDate = date.toInstant().atZone(ZoneId.of("Europe/Paris").systemDefault()).toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(lDate);
        event = new Event(name, lieu, sqlDate, description);
        if(eventDao.addEvent(event) == 1) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Congratulations, event adding has been successful",
                            ""));
        }else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Event adding failure : A problem occur during event adding", ""));
        }
        event = null;
        return null;
    }


    // ==================================================================
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
