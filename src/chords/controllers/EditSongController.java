package chords.controllers;

import chords.models.Segment;
import chords.models.SongElement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EditSongController {
    private ArrayList<SongElement> songElements;
    private String title;

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
        this.songElements = parseSongBody(song_body.getText());
        if (!this.songElements.isEmpty()) {
            this.title = song_title.getText();
            Stage stage = (Stage) save.getScene().getWindow();
            stage.close();
        }
    }

    private ArrayList<SongElement> parseSongBody(String body) {
        String strippedBody = body.replace("\n", "");
        ArrayList<SongElement> result = new ArrayList<>();
        ArrayList<Segment> currElementSegments = new ArrayList<>();
        Segment currSegment = new Segment();
        SongElement currElement = new SongElement();
        boolean isChord = false;
        boolean isElement = false;

        if (validations(strippedBody)) {
            for (int i = 0; i < strippedBody.length(); i++) {
                char c = strippedBody.charAt(i);
                if (c == '[') {
                    if (currSegment.getChord() != null && currSegment.getLyrics() != null) {
                        currElementSegments.add(currSegment);
                        currSegment = new Segment();
                    }
                    isChord = true;
                } else if (c == ']') {
                    isChord = false;
                } else if (c == '{') {
                    if (!isChord) {
                        if (currElement.getTitle() != null) {
                            currElementSegments.add(currSegment);
                            currElement.setSegments(currElementSegments);
                            result.add(currElement);
                            currElementSegments = new ArrayList<>();
                            currSegment = new Segment();
                            currElement = new SongElement();
                        }
                        isElement = true;
                    }
                } else if (c == '}') {
                    if (!isChord) {
                        isElement = false;
                    }
                } else {
                    if (isChord) {
                        currSegment.addCharacterToChord(c);
                    } else if (isElement) {
                        currElement.addCharToTitle(c);
                    } else {
                        currSegment.addCharactertoLyrics(c);
                    }
                }
            }
            currElementSegments.add(currSegment);
            currElement.setSegments(currElementSegments);
            result.add(currElement);
        }
        return result;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<SongElement> getSongElements() {
        return songElements;
    }

    private boolean validations(String s) {
        int bracketCount = 0;
        int curlyCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                bracketCount++;
            }
            if (c == ']') {
                bracketCount--;
            }
            if (c == '{') {
                curlyCount++;
            }
            if (c == '}') {
                curlyCount--;
            }
        }
        return bracketCount == 0 && curlyCount == 0;
    }
}
