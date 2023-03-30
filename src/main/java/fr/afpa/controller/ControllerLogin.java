package fr.afpa.controller;


import fr.afpa.application.HelloApplication;
import fr.afpa.dao.UsersDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.SQLException;

//controller qui gère la vue login
public class ControllerLogin {
    @FXML
    private CheckBox btnSign;
    @FXML
    private TextField tfMail;

    @FXML
    private TextField tfMdp;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    UsersDao usersDao = new UsersDao();

    public void initialize(){
        tfMail.setText("kelvin@bing.fr");
        tfMdp.setText("azerty");
    }

    public void login() throws IOException, SQLException {

        String mail = tfMail.getText();
        String mdp = tfMdp.getText();

        if (!mail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\.?[a-zA-Z]*$")){
            alert.setTitle("Erreur");
            alert.setHeaderText("Adresse email invalide !!!");
            alert.setContentText("L'adresse email n'est pas valide");
            alert.showAndWait();

            return;
        }
        if (mail.isEmpty() || mdp.isEmpty()) {
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs vide");
            alert.setContentText("Remplir les champs");
            alert.showAndWait();

            return;
        }

        usersDao.checkUser(mail, mdp);
    }

    @FXML
    private void goToSign() throws IOException {
        if(btnSign.isSelected()){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/signIn.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            HelloApplication.stage.setScene(scene);
            HelloApplication.stage.setTitle("Inscription");
        }
    }
}
