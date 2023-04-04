package fr.afpa.controller;

import fr.afpa.dao.MoviesDao;
import fr.afpa.model.Film;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    MoviesDao moviesDao = new MoviesDao();
    ArrayList<Film> films;

    @FXML
    public void initialize(){
        films = moviesDao.findAll();
        for (int i = 0; i < 3; i++){
            File file = new File("C:\\Users\\Happy\\.imgStreaming\\" + films.get(i).getImgPath());
            Image image = new Image(file.toURI().toString());
            ImageView imageView = new ImageView();
            Label label = new Label();
            label.setText(films.get(i).getTitre());
            imageView.setImage(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(300);
            card1.getChildren().add(imageView);
            card1.getChildren().add(label);
        }
    }
}
            /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = dateFormat.format(cellData.getValue().getDateSortie());
            return new SimpleStringProperty(formattedDate);*/
