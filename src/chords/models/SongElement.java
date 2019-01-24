package chords.models;

import java.util.ArrayList;

public class SongElement {
    private String title;
    private ArrayList<Segment> segments;

    public SongElement() {
        segments = new ArrayList<>();
    }

    public ArrayList<Segment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Segment> segments) {
        this.segments = segments;
    }

    public String prettyFormatElement() {
        StringBuilder sb = new StringBuilder(title).append("\n");
        for (Segment s : segments) {
            sb.append(s.prettyFormatSegment()).append("\n");
        }
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addCharToTitle(char c) {
        if (title == null) {
            title = String.valueOf(c);
        } else {
            title = title + c;
        }
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
