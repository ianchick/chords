package chords.models;

import java.util.ArrayList;

public class Song {
    private String title;
    private String key;
    private ArrayList<SongElement> songElements;

    public Song(String title) {
        this.title = title;
        songElements = new ArrayList<>();
    }

    public String prettyFormatSong() {
        StringBuilder sb = new StringBuilder();
        for (SongElement s : songElements) {
            sb.append(s.prettyFormatElement()).append("\n");
        }
        return sb.toString();
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

    public ArrayList<SongElement> getSongElements() {
        return songElements;
    }

    public void setSongElements(ArrayList<SongElement> songElements) {
        this.songElements = songElements;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
