package com.epsi.projectaps.model;

import java.sql.Date;

public class Event {

    private int id;
    private String name;
    private String idLieu;
    private Date date;
    private String description;

    public Event(String name, String idLieu, Date date, String description) {
        this.name = name;
        this.idLieu = idLieu;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(String idLieu) {
        this.idLieu = idLieu;
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
