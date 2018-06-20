package com.epsi.projectaps.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.epsi.projectaps.dao.EventDao;
import com.epsi.projectaps.dao.UserDao;
import com.epsi.projectaps.model.Event;
import com.epsi.projectaps.model.User;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class EventController {

    private Event event = new Event();

    public EventController() {
        FacesContext.getCurrentInstance().getViewRoot()
                .setLocale(new Locale("en"));
    }

    public String addEvent() throws SQLException {
        EventDao eventDao = new EventDao();
        System.out.println(event.getName());
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
}
