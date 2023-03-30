package fr.afpa.controller;

import fr.afpa.dao.Dao;
import fr.afpa.dao.MoviesDao;
import fr.afpa.dao.PlaylistDao;
import fr.afpa.model.Film;
import fr.afpa.application.HelloApplication;
import fr.afpa.model.GetUserId;
import fr.afpa.model.Playlist;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//controller de la vue Playlist
public class ControllerPlaylist {
    @FXML
    private TableView<Film> tableFilm;
    @FXML
    private TableView<Film> tableVPlaylist;
    private final ObservableList<Film> films = FXCollections.observableArrayList();
    private final ObservableList<Film> movies = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Film, String> colTitle = null;
    @FXML
    private TableColumn<Film, String> colPlaylist = null;
    @FXML
    private Button btnAddMoviesBdd;
    @FXML
    private Button btnUpdate;
    MoviesDao moviesDao = new MoviesDao();
    PlaylistDao playlistDao = new PlaylistDao();

    // création de la methode pour aller a la page d'accueil
    @FXML
    public void returnHome() throws IOException {
        Stage stage = HelloApplication.stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Streaming");
        stage.setScene(scene);
    }
    @FXML
    public void goToFormAdd() throws IOException {
        Stage stage = HelloApplication.stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/ajoutFilm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Add movies");
        stage.setScene(scene);
    }

    @FXML
    public void addFilmPlaylist() throws SQLException {
        tableVPlaylist.setItems(movies);
        Film selectedFilm  = tableFilm.getSelectionModel().getSelectedItem();

        if (!tableVPlaylist.getItems().contains(selectedFilm)) {
            tableVPlaylist.getItems().add(selectedFilm);
            playlistDao.addMoviesPlaylist(selectedFilm.getId());
        }
        colPlaylist.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));
    }

    @FXML
    public void initialize() {
        int idUser = GetUserId.getInstance().getId();
        films.addAll(moviesDao.findAll());
        tableFilm.setItems(films);
        colTitle.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));

        movies.addAll(playlistDao.getFilmsForUser(idUser));
        tableVPlaylist.setItems(movies);
        colPlaylist.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitre()));
    }
    @FXML
    public void onModifyMovie() throws IOException {
        Film selectedFilm = tableFilm.getSelectionModel().getSelectedItem();
        Stage stage = HelloApplication.stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/ajoutFilm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ControllerAddMovies controllerAddMovies = fxmlLoader.getController();
        controllerAddMovies.loadMovie(selectedFilm.getId());
        stage.setTitle("Update movies");
        stage.setScene(scene);
    }
    @FXML
    public void delete(){
        Film selectedFilm = tableVPlaylist.getSelectionModel().getSelectedItem();
        movies.remove(selectedFilm);
    }
}