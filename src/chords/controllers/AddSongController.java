package chords.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import chords.models.Song;

public class AddSongController {

    @FXML
    private Text output;
    @FXML
    private TextField new_song_name;

    @FXML
    public void addSong() {
        Song song = new Song(new_song_name.getText());
        output.setText("New Song: " + song.getTitle() + " was added");
    }
}
