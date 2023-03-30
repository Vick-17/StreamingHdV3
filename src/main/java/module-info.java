module fr.afpa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;
    requires java.mail;

    opens view to javafx.fxml;
    exports fr.afpa.controller;
    opens fr.afpa.controller to javafx.fxml;
    exports fr.afpa.model;
    opens fr.afpa.model to javafx.fxml;
    exports fr.afpa.application;
    opens fr.afpa.application to javafx.fxml;
}

