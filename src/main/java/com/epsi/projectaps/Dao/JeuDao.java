package com.epsi.projectaps.Dao;

import com.epsi.projectaps.model.Jeu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JeuDao extends Database{

    public JeuDao() {
        super();
    }


    public int addJeu(Jeu jeu){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("INSERT INTO JEU (NAME, REGLE, DE, CARTE, NOMBREJOUEURMIN, NOMBREJOUEURMAX) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, jeu.getNom());
            statement.setString(2, jeu.getRegles());
            statement.setBoolean(3, jeu.isDe());
            statement.setBoolean(4, jeu.isCarte());
            statement.setInt(5, jeu.getNombreJoueurMini());
            statement.setInt(6, jeu.getNombreJoueurMax());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet findJeu(Jeu jeu){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM JEU WHERE JEUNAME = ?");
            statement.setString(1, jeu.getNom());
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findAllJeu(){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("SELECT * FROM JEU");
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int updateJeu(Jeu jeu){
        try {
            PreparedStatement statement = getConnexion().prepareStatement("UPDATE JEU SET REGLE=? AND DE=? AND CARTE=? AND NOMBREJOUEURMIN=? AND NOMBREJOUEURMAX =? WHERE ID=?");
            statement.setString(1, jeu.getRegles());
            statement.setBoolean(2, jeu.isDe());
            statement.setBoolean(3, jeu.isCarte());
            statement.setInt(4, jeu.getNombreJoueurMini());
            statement.setInt(5, jeu.getNombreJoueurMax());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteJeu(Jeu jeu){
        try{
            PreparedStatement statement = getConnexion().prepareStatement("DELETE * FROM JEU WHERE ID=?");
            statement.setInt(1, jeu.getId());
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    } 
}
