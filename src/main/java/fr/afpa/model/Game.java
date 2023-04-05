package fr.afpa.model;

import java.sql.Date;

public class Game {
    private int id;
    private String title;
    private Date publiDate;
    private String description;
    private String imagePath;

    public Game(int id, String title, Date publiDate, String description, String imagePath) {
        this.id = id;
        this.title = title;
        this.publiDate = publiDate;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Game() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubliDate() {
        return publiDate;
    }

    public void setPubliDate(Date publiDate) {
        this.publiDate = publiDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
