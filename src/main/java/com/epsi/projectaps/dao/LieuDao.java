package com.epsi.projectaps.dao;

import com.epsi.projectaps.model.Lieu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LieuDao extends Database{


    public int addLieu(Lieu lieu){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("INSERT INTO LIEU (ID, NAME, LONG, LAT) VALUES (?, ?, ?, ?)");
            statement.setInt(1, lieu.getId());
            statement.setString(2, lieu.getName());
            statement.setString(3, lieu.getLongitude());
            statement.setString(4, lieu.getLatitude());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet findLieu(Lieu lieu){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM LIEU WHERE ID = ?");
            statement.setInt(1, lieu.getId());
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findAllLieu(){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM LIEU");
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int updateLieu(Lieu lieu){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("UPDATE LIEU SET NOM=? AND LONG=? AND LAT=? WHERE ID=?");
            statement.setString(1, lieu.getName());
            statement.setString(2, lieu.getLongitude());
            statement.setString(3, lieu.getLatitude());
            statement.setInt(4, lieu.getId());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteLieu(Lieu lieu){
        try{
            PreparedStatement statement = getConnexion().prepareStatement("DELETE * FROM LIEU WHERE ID=?");
            statement.setInt(1, lieu.getId());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
