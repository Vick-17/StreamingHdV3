package fr.afpa.controller;

import fr.afpa.dao.ActorDao;
import fr.afpa.model.Acteur;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerAddActor {
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputLastName;
    @FXML
    private TextField inputAge;
    @FXML
    private Button btnAddActor;
    ActorDao actorDao = new ActorDao();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);



    @FXML
    public void addActor(){
        String name = inputName.getText();
        String lastName = inputName.getText();
        String age = inputName.getText();
        if(!name.isEmpty() || !lastName.isEmpty() || !age.isEmpty()){
            actorDao.addActor(name, lastName, age);
            alert.setTitle("Bravo");
            alert.setHeaderText("Acteur ajouté");
            alert.setContentText("Les information on bien été ajouter a la base de données");
            alert.showAndWait();
        }else {
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs vide");
            alert.setContentText("un des champs est vide");
            alert.showAndWait();
        }
    }
}
