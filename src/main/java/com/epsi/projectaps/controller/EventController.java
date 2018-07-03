package com.epsi.projectaps.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.epsi.projectaps.dao.EventDao;
import com.epsi.projectaps.model.Event;

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
        if (eventDao.addEvent(event) == 1) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Congratulations, event adding has been successful",
                            ""));

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Event adding failure : A problem occur during event adding", ""));
        }
        event = null;
        return "event.xhtml";
    }

    public List<Event> findAllEvent() {
        try {
            EventDao eventDao = new EventDao();
            ResultSet resultSet = eventDao.findAllEvent();
            List<Event> eventList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("name");
                String lieu = resultSet.getString("lieu");
                Date date = resultSet.getDate("date");
                String description = resultSet.getString("description");

                Event event = new Event(nom, lieu, date, description);
                event.setId(id);
                eventList.add(event);
            }
            return eventList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Event>();
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
