package chords.controllers;

import chords.models.Segment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EditSongController {
    private ArrayList<Segment> segments;

    @FXML
    public TextArea song_body;
    @FXML
    public TextField song_title;
    @FXML
    public Button save;

    public void init(String title) {
        song_title.setText(title);
    }

    public void save() {
        this.segments = parseSongBody(song_body.getText());
        Stage stage = (Stage) save.getScene().getWindow();
        stage.close();
    }

    private ArrayList<Segment> parseSongBody(String body) {
        // Split lyrics by line first
        String[] songLines = body.split("\n");
        ArrayList<Segment> result = new ArrayList<>();

        for (String line : songLines) {
            Segment currSegment = new Segment();
            boolean isChord = false;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                // If c = '[', start of chord, start new segment, isChord = true, add previous segment to result
                if (c == '[') {
                    // Add old segment if segment hasn't been set
                    if (currSegment.getChord().getName() != null) {
                        result.add(currSegment);
                        currSegment = new Segment();
                    }
                    // Make new segment
                    isChord = true;
                }
                // If c = ']', end of chord, isChord = false
                else if (c == ']') {
                    isChord = false;
                }
                // Else, add character to current segment, chord if isChord, lyrics if isLyric
                else {
                    if (isChord) {
                        currSegment.addCharacterToChord(c);
                    } else {
                        currSegment.addCharactertoLyrics(c);
                    }
                }
            }
            result.add(currSegment);
        }
        return result;
    }

    public ArrayList<Segment> getSegments() {
        return this.segments;
    }
}
