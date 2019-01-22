package chords.controllers;

import chords.models.Song;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSongController {

    private Song newSong;

    @FXML
    private TextField new_song_name;
    @FXML
    private Button save;

    public void addSong() {
        newSong = new Song(new_song_name.getText());
        if (!newSong.getTitle().isEmpty()) {
            Stage stage = (Stage) save.getScene().getWindow();
            stage.close();
        }
    }

    public Song getNewSong() {
        return newSong;
    }
}
