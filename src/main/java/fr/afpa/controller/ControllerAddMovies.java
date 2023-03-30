package fr.afpa.controller;

import fr.afpa.dao.MoviesDao;
import fr.afpa.model.Film;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;

public class ControllerAddMovies {
    @FXML
    private TextField inputTitle;
    @FXML
    private DatePicker inputDate;
    private int movieId;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    MoviesDao moviesDao = new MoviesDao();

    @FXML
    public void addFilm(){

        String title = inputTitle.getText();
        Date publiDate = Date.valueOf(inputDate.getValue());

        if(title.isEmpty() || publiDate.toString().isEmpty()){
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs vide");
            alert.setContentText("Le champ titre ou date de sortie est vide");
            alert.showAndWait();
        } else {
            if (this.movieId == 0){
                moviesDao.addMovies(title, publiDate);
                alert.setTitle("Bravo");
                alert.setHeaderText("Film ajouter");
                alert.setContentText("Le film " + title + " a été ajouter a la base de données");
            } else {
                moviesDao.updateMovie(movieId, title, publiDate);
                alert.setTitle("Bravo");
                alert.setHeaderText("Film modifié");
                alert.setContentText("Le film " + title + " a été modifié dans la base de données");
            }
        }
    }

    public void loadMovie(int movieId){
        this.movieId = movieId;
        Film film = moviesDao.find(movieId);
        inputTitle.setText(film.getTitre());
        inputDate.setValue(film.getDateSortie().toLocalDate());
    }
}
