package chords.controllers;

import chords.models.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private ObservableList<Song> songsList;

    @FXML ListView<Song> songs_list;

    public void openAddSongView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chords/AddSong.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add New Song");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        AddSongController addSongController = fxmlLoader.getController();
        Song newSong = addSongController.getNewSong();

        if (songsList == null) {
            songsList = FXCollections.observableArrayList();
        }
        songsList.add(newSong);
        songs_list.setItems(songsList);
    }
}
