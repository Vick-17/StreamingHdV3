package fr.afpa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBdd {
    private static ConnectionBdd instance;

    public Connection connection;

    private ConnectionBdd(){
        try{
            String url = "jdbc:postgresql://localhost:5432/StreamingHd";
            String user = "postgres";
            String password = "iie254007.";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ConnectionBdd getInstance(){
        if(instance == null){
            instance = new ConnectionBdd();
        }
        return instance;
    }
}
