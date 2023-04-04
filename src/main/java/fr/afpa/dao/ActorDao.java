package fr.afpa.dao;

import fr.afpa.model.Acteur;
import fr.afpa.model.ConnectionBdd;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class ActorDao extends Dao<Acteur> {


    private final Connection connection;

    public ActorDao() {
        connection = ConnectionBdd.getInstance().connection;
    }

    public void addActor(String name, String lastName, String age) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into actor (name, lastName, age) values (?,?,?)");
            st.setString(1, name);
            st.setString(2, lastName);
            st.setString(3, age);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Acteur find(int id) {
        return null;
    }

    @Override
    public ArrayList<Acteur> findAll() {
        ArrayList<Acteur> acteurs = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from actor");
            while(rs.next()){
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String age = rs.getString("age");

                Acteur acteur = new Acteur(name, lastName, age);
                acteurs.add(acteur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return acteurs;
    }
}
