package com.epsi.projectaps.dao;

import com.epsi.projectaps.model.Event;
import com.epsi.projectaps.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipantDao extends Database {

    public ParticipantDao() {
        super();
    }

    public void linkUserEvent(User user, Event event) {
        try {
            PreparedStatement statement = getConnexion().prepareStatement("INSERT INTO PARTICIPANT (IDUSER, IDEVENT) VALUES (?, ?)");
            statement.setInt(1, user.getId());
            statement.setInt(2, event.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void unLinkUserEvent(User user, Event event) {
        try {
            PreparedStatement statement = getConnexion().prepareStatement("DELETE * FROM PARTICIPANT WHERE IDUSER=? AND IDEVENT=?");
            statement.setInt(1, user.getId());
            statement.setInt(2, event.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}