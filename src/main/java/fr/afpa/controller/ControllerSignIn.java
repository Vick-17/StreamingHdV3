package fr.afpa.controller;

import fr.afpa.application.HelloApplication;
import fr.afpa.dao.UsersDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class ControllerSignIn {
    @FXML
    private TextField signName;
    @FXML
    private TextField signEmail;
    @FXML
    private TextField signPassword;
    @FXML
    private CheckBox btnToLog;
    UsersDao userDao = new UsersDao();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private void signIn() throws SQLException, IOException {
        String nom = signName.getText();
        String email = signEmail.getText();
        String password = signPassword.getText();

        if(nom.isEmpty() || email.isEmpty() || password.isEmpty()){
            alert.setTitle("WARNING !!!");
            alert.setHeaderText("Results: ");
            alert.setContentText("Tous les champs doivent être remplis.");
            alert.showAndWait();
            return;
        }

        if(!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            alert.setTitle("WARNING !!!");
            alert.setHeaderText("Results: ");
            alert.setContentText("Format email invalid");
            alert.showAndWait();
            return;
        }

        userDao.newUsers(nom, email, password);
        alert.setTitle("FÉLICITATION !!!");
        alert.setHeaderText("Results: ");
        alert.setContentText("Inscription reussi");
        alert.showAndWait();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.stage.setScene(scene);
        HelloApplication.stage.setTitle("Sign in");
        HelloApplication.stage.setScene(scene);

    }

    @FXML
    private void goToLog() throws IOException {
        if(btnToLog.isSelected()){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            HelloApplication.stage.setScene(scene);
            HelloApplication.stage.setTitle("Connection");
        }
    }

}
