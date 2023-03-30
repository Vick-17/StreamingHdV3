package fr.afpa.dao;

import fr.afpa.application.HelloApplication;
import fr.afpa.model.ConnectionBdd;
import fr.afpa.model.GetUserId;
import fr.afpa.model.Users;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import org.mindrot.jbcrypt.BCrypt;

public class UsersDao extends Dao<Users> {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private Connection connection;

    public UsersDao(){
        connection = ConnectionBdd.getInstance().connection;
    }

    public void newUsers(String nom,String email, String password) throws SQLException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        PreparedStatement statement = connection.prepareStatement("insert into users (name, email, password) values (?,?,?)");
        statement.setString(1, nom);
        statement.setString(2, email);
        statement.setString(3, hashedPassword);
        statement.executeUpdate();
    }

    public void checkUser(String email, String password) throws SQLException, IOException {
        connection = ConnectionBdd.getInstance().connection;
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?;");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            String hashedPassword = resultSet.getString("password");
            int userId = resultSet.getInt("id");
            if (BCrypt.checkpw(password, hashedPassword)){
                GetUserId.getInstance().setID(userId);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/playlist.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                HelloApplication.stage.setScene(scene);
                HelloApplication.stage.setTitle("Playlist");
            } else {
                alert.setTitle("ALERT !!!!");
                alert.setHeaderText("Results:");
                alert.setContentText("Mot de passe incorrect");
                alert.showAndWait();
            }
        }else {
            alert.setTitle("ALERTE !!!!");
            alert.setHeaderText("Results:");
            alert.setContentText("Email inconue");
            alert.showAndWait();
        }
    }

    @Override
    public Users find(int id) {
        return null;
    }

    @Override
    public ArrayList<Users> findAll() {
        return null;
    }

}
