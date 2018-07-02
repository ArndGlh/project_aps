package com.epsi.projectaps.dao;

import com.epsi.projectaps.model.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDao extends Database {

    public EventDao(){
        super();
    }

    public int addEvent(Event event){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("INSERT INTO EVENT (NAME, LIEU, DATE, DESCRIPTION) VALUES (?, ?, ?, ?)");
            statement.setString(1, event.getName());
            statement.setString(2, event.getLieu());
            statement.setDate(3, event.getDate());
            statement.setString(4, event.getDescription());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet findEvent(Event event){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM EVENT WHERE ID = ?");
            statement.setInt(1, event.getId());
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findAllEvent(){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM EVENT");
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int updateEvent(Event event){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("UPDATE EVENT SET NAME=? AND LIEU=? AND DATE=? AND DESCRIPTION=?  WHERE ID=?");
            statement.setString(1, event.getName());
            statement.setString(2, event.getLieu());
            statement.setDate(3, event.getDate());
            statement.setString(4, event.getDescription());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteEvent(Event event){
        try{
            PreparedStatement statement = getConnexion().prepareStatement("DELETE * FROM EVENT WHERE ID=?");
            statement.setInt(1, event.getId());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
