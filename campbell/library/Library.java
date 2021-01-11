package org.campbell.library;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import org.campbell.admin.Admin;

public class Library extends Application {
    boolean isAdmin = false;
    Admin admin;
    @Override 
    public void start(Stage stage) {

        BorderPane bPane = new BorderPane();

        Label lbl = new Label("The Campbell Home Library, coming soon!");

        Button btnAdmin = new Button("Admin");

        GridPane pane = new GridPane();
        // pane.setPadding(new Insets(100, 100, 100, 100));
        pane.setVgap(15);
        pane.setHgap(5);

        // Label lbl = new Label("The Campbell Home Library, coming soon!");
        // pane.setConstraints(lbl, 0, 0);

        // Button btnAdmin = new Button("Admin");
        // pane.setConstraints(btnAdmin, 1, 0);

        Label lblItem = new Label("Item Type");
        pane.setConstraints(lblItem, 0, 1);
        TextField txtItem = new TextField();
        txtItem.setMaxWidth(250);
        pane.setConstraints(txtItem, 1, 1);

        Label lblTitle = new Label("Title");
        pane.setConstraints(lblTitle, 2, 1);
        TextField txtTitle = new TextField();
        txtTitle.setMaxWidth(250);
        pane.setConstraints(txtTitle, 3, 1);

        Label lblAuthorL = new Label("Author's Last Name");
        pane.setConstraints(lblAuthorL, 0, 2);
        TextField txtAuthorL = new TextField();
        txtAuthorL.setMaxWidth(250);
        pane.setConstraints(txtAuthorL, 1, 2);

        Label lblAuthorF = new Label("Author's First Name");
        pane.setConstraints(lblAuthorF, 2, 2);
        TextField txtAuthorF = new TextField();
        txtAuthorF.setMaxWidth(250);
        pane.setConstraints(txtAuthorF, 3, 2);

        Label lblGenre = new Label("Genre");
        pane.setConstraints(lblGenre, 0, 3);
        TextField txtGenre = new TextField();
        txtGenre.setMaxWidth(250);
        pane.setConstraints(txtGenre, 1, 3);

        Label lblSGenre = new Label("Sub Genre");
        pane.setConstraints(lblSGenre, 3, 3);
        TextField txtSGenre = new TextField();
        txtSGenre.setMaxWidth(250);
        pane.setConstraints(txtSGenre, 4, 3);

        Label lblLcc = new Label("LCC");
        pane.setConstraints(lblLcc, 0, 4);
        TextField txtLcc = new TextField();
        txtLcc.setMaxWidth(250);
        pane.setConstraints(txtLcc, 1, 4);

        Label lblIsbn10 = new Label("ISBN10");
        pane.setConstraints(lblIsbn10, 0, 5);
        TextField txtIsbn10 = new TextField();
        txtIsbn10.setMaxWidth(250);
        pane.setConstraints(txtIsbn10, 1, 5);

        Label lblIsbn13 = new Label("ISBN13");
        pane.setConstraints(lblIsbn13, 2, 5);
        TextField txtIsbn13 = new TextField();
        txtIsbn13.setMaxWidth(250);
        pane.setConstraints(txtIsbn13, 3, 5);

        Label lblKeyWords = new Label("Key Words");
        pane.setConstraints(lblKeyWords, 0, 6);
        TextField txtKeyWords = new TextField();
        txtKeyWords.setMaxWidth(250);
        pane.setConstraints(txtKeyWords, 1, 6);

        Label lblSummary = new Label("Summary");
        pane.setConstraints(lblSummary, 0, 7);
        TextArea txtSummary = new TextArea();
        pane.setConstraints(txtSummary, 1, 7);

        Label lblRoom = new Label("Room");
        pane.setConstraints(lblRoom, 0, 8);
        TextField txtRoom = new TextField();
        txtRoom.setMaxWidth(250);
        pane.setConstraints(txtRoom, 1, 8);

        Label lblLocation = new Label("Location");
        pane.setConstraints(lblLocation, 2, 8);
        TextField txtLocation = new TextField();
        txtLocation.setMaxWidth(250);
        pane.setConstraints(txtLocation, 3, 8);

        Button submit = new Button("Submit");
        pane.setConstraints(submit, 0, 9);

        pane.getChildren().addAll(
            lbl, 
            btnAdmin,
            lblItem,
            txtItem,
            lblTitle, 
            txtTitle, 
            lblAuthorL, 
            txtAuthorL,
            lblAuthorF, 
            txtAuthorF,
            lblGenre,
            txtGenre,
            lblSGenre,
            txtSGenre,
            lblLcc,
            txtLcc,
            lblIsbn10,
            txtIsbn10,
            lblIsbn13,
            txtIsbn13,
            lblKeyWords,
            txtKeyWords,
            lblSummary,
            txtSummary,
            lblRoom,
            txtRoom,
            lblLocation,
            txtLocation,
            submit
            );

            bPane.setTop(lbl);
            bPane.setLeft(pane);

        // adminBox.setVisible(false);

        Scene scene = new Scene(bPane, 1000, 700);
        stage.setScene(scene);
        stage.show();

        submit.setOnAction(e -> {
            
            admin = new Admin();

            String title = txtTitle.getText();
            String authorL = txtAuthorL.getText();
            String authorF = txtAuthorF.getText();
            String item = txtItem.getText();
            String genre = txtGenre.getText();
            String sGenre = txtSGenre.getText();
            String lcc = txtLcc.getText();
            String isbn10 = txtIsbn10.getText();
            String isbn13 = txtIsbn13.getText();
            String keyWords = txtKeyWords.getText();
            String summary = txtSummary.getText();
            String room = txtRoom.getText();
            String location = txtLocation.getText();

            String[] params = new String[13];

            params[0] = title;
            params[1] = authorL;
            params[2] = authorF;
            params[3] = item;
            params[4] = genre;
            params[5] = sGenre;
            params[6] = lcc;
            params[7] = isbn10;
            params[8] = isbn13;
            params[9] = keyWords;
            params[10] = summary;
            params[11] = room;
            params[12] = location;

            admin.addBooks(params);

        });

        // adminBtn.setOnAction(e -> {
        //     isAdmin = true;

        //     adminBox.setVisible(true);
        // });


    }

    public static void main(String[] args) {
        launch(args);
    }
}