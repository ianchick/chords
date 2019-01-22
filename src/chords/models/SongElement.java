package chords.models;

import java.util.ArrayList;

public class SongElement {
    private String title;
    private ArrayList<Segment> segments;

    public ArrayList<Segment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Segment> segments) {
        this.segments = segments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(": ");
        for (Segment s : segments) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}
