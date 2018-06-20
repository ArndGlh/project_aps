package com.epsi.projectaps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    /* Connexion à la base de données */
    private static final String url = "jdbc:mysql://localhost:3306/project_aps";
    private static final String utilisateur = "project_aps";
    private static final String motDePasse = "project_aps";
    private Connection connexion = null;

    /* a transformer en singleton peu être */
    public Database() {

        /* Chargement du driver JDBC pour MySQL
        * A ne faire qu'un seule fois, a voir comment le modifier
        *
        * */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
        }

        try{
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        }catch (SQLException e){
            e.printStackTrace();
            /* Gérer les éventuelles erreurs ici */
        }
    }

    public Connection getConnexion() {
        return connexion;
    }


    public void destroy(){

            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }

}