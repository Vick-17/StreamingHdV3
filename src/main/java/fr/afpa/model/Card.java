package fr.afpa.model;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;

public class Card extends VBox {
    public Card(Film film){
        File file = new File("C:\\Users\\vegav\\.imgStreaming\\" + film.getImgPath());
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
        Label label = new Label();
        label.setText(film.getTitre());
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(300);
        this.getChildren().add(imageView);
        this.getChildren().add(label);
    }

    public Card(Game game){
        File file = new File("C:\\Users\\vegav\\.imgStreaming\\" + game.getImagePath());
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
        Label label = new Label();
        label.setText(game.getTitle());
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(300);
        this.getChildren().add(imageView);
        this.getChildren().add(label);
    }
}
