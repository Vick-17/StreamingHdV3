package fr.afpa.controller;

import fr.afpa.dao.GameDao;
import fr.afpa.dao.MoviesDao;
import fr.afpa.model.Card;
import fr.afpa.model.Film;
import fr.afpa.model.Game;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;


public class ControllerAccueil {
    @FXML
    private TableView<Film> tableFilm;
    @FXML
    private TableColumn<Film, String> colTitle;
    @FXML
    private TableColumn<Film, String> colDate;
    @FXML
    private VBox card1;
    @FXML
    private VBox card2;
    @FXML
    private VBox card3;
    @FXML
    private HBox hboxMovies;
    MoviesDao moviesDao = new MoviesDao();
    GameDao gameDao = new GameDao();
    ArrayList<Film> films;
    ArrayList<Game> games;

    @FXML
    public void initialize(){
        films = moviesDao.findAll();
        games = gameDao.findAll();
        for (int i = 0; i < 3; i++){
        Card cardMovie = new Card(films.get(i));
            hboxMovies.getChildren().add(cardMovie);
        Card cardGame = new Card(games.get(i));
            hboxMovies.getChildren().add(cardGame);
        }
    }
}
            /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = dateFormat.format(cellData.getValue().getDateSortie());
            return new SimpleStringProperty(formattedDate);*/
