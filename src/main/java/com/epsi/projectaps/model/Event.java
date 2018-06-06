package com.epsi.projectaps.model;

import java.util.Date;

public class Event {

    private String name;
    private int idEvent;
    private String lieu;
    private Date date;
    private String description;

    public Event(String name, int idEvent, String lieu, Date date, String description) {
        this.name = name;
        this.idEvent = idEvent;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
