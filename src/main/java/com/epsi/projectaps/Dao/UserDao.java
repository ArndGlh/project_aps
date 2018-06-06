package com.epsi.projectaps.Dao;

import com.epsi.projectaps.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao extends Database{

    public UserDao(){
        super();
    }

    public int addUser(User user) throws SQLException {
        Connection c = getConnexion();
        // TODO encrypt password
        PreparedStatement statement = getConnexion().prepareStatement("INSERT INTO USER (USERNAME, USERPASSWORD, USERMAIL) VALUES (?, ?, ?)");
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getUserMail());
        return statement.executeUpdate();
    }


    // ===============

}
