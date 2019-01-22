package chords.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    public void openAddSongView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chords/AddSong.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add New Song");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
