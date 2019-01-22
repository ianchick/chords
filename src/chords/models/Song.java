package chords.models;

import java.util.ArrayList;

public class Song {
    private String title;
    private String key;
    private ArrayList<SongElement> songElements;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
