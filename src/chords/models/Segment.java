package chords.models;

public class Segment {
    private Chord chord;
    private String lyrics;

    public Segment() {
        chord = new Chord();
    }

    public String prettyFormatSegment() {
        return "CHORD: " + chord + "\n" + "LYRIC: " + lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Chord getChord() {
        return chord;
    }

    public void setChord(Chord chord) {
        this.chord = chord;
    }

    public void addCharacterToChord(char c) {
        if (this.chord.getName() == null) {
            this.chord.setName(String.valueOf(c));
        } else {
            this.chord.setName(this.chord.getName() + c);
        }
    }

    public void addCharactertoLyrics(char c) {
        if (lyrics == null) {
            lyrics = String.valueOf(c);
        } else {
            this.lyrics = this.lyrics + c;
        }
    }

    @Override
    public String toString() {
        return "[" + chord.getName() + "]" + lyrics;
    }
}
