package chords.models;

/**
 * TODO: Transposing logic will need include steps and chord numbers
 */
public class Chord {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
