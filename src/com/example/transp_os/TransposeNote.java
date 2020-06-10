package com.example.transp_os;

import java.util.ArrayList;
import java.util.List;

/**
 * This class transposes one note between different instrument keys
 */
public class TransposeNote {

    private static final int NUMBER_OF_NOTES = 12;
    private List<String> notes;

    private void initialize() {

        notes = new ArrayList<>();
        notes.add("Bb");
        notes.add("F");
        notes.add("C");
        notes.add("G");
        notes.add("D");
        notes.add("A");
        notes.add("E");
        notes.add("B");
        notes.add("F#");
        notes.add("C#");
        notes.add("G#");
        notes.add("D#");

    }

    /**
     * transposes startNote from startKey to newKey
     * @param startKey takes in user's starting key
     * @param newKey takes in user's new key
     * @param startNote takes in user's starting note
     * @return returns a String representing the new transposed note
     */
    public String getNote(String startKey, String newKey, String startNote) {

        initialize();
        Integer startingValue = notes.indexOf(startKey);
        Integer newValue = notes.indexOf(newKey);

        // relative value is negated to account for shifting between two instrument keys
        int relativeValue = startingValue - newValue;

        int newNoteIndex = notes.indexOf(startNote) + relativeValue;

        // makes sure that the newNoteIndex is within the list's range
        if (newNoteIndex < 0) {
            newNoteIndex += NUMBER_OF_NOTES;
        } else {
            newNoteIndex = newNoteIndex % NUMBER_OF_NOTES;
        }

        return notes.get(newNoteIndex);
    }
}
