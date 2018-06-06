package com.epsi.projectaps.Dao;

import com.epsi.projectaps.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Database{

    public UserDao(){
        super();
    }

    public int addUser(User user){
        // TODO encrypt password
        try {
        PreparedStatement statement = getConnexion().prepareStatement("INSERT INTO USER (USERNAME, USERPASSWORD, USERMAIL) VALUES (?, ?, ?)");
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getUserMail());
        return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet findUser(User user){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM USER WHERE USERNAME = ?");
            statement.setString(1, user.getUserName());
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findAllUser(){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM USER");
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int updateUser(User user){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("UPDATE USER SET USESERNAME=? AND USERMAIL=? AND USERPASSWORD=? WHERE ID=?");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUserMail());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteUser(User user){
        try{
            PreparedStatement statement = getConnexion().prepareStatement("DELETE * FROM USER WHERE ID=?");
            statement.setInt(1, user.getId());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
