package com.example.transp_os;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransposeNote {

    private Map<String, Integer> musicalKeys;
    private List<String> notes;

    public void initialize() {
        musicalKeys = new HashMap<>();
        musicalKeys.put("Cb", -7);
        musicalKeys.put("Gb",-6);
        musicalKeys.put("Db",-5);
        musicalKeys.put("Ab",-4);
        musicalKeys.put("Eb",-3);
        musicalKeys.put("Bb",-2);
        musicalKeys.put("F",-1);
        musicalKeys.put("C",0);
        musicalKeys.put("G", 1);
        musicalKeys.put("D", 2);
        musicalKeys.put("A", 3);
        musicalKeys.put("E", 4);
        musicalKeys.put("B", 5);
        musicalKeys.put("FSharp", 6);
        musicalKeys.put("CSharp", 7);

        notes = new ArrayList<>();
        notes.add("C");
        notes.add("C#/Db");
        notes.add("D");
        notes.add("D#/Eb");
        notes.add("E");
        notes.add("F");
        notes.add("F#/Gb");
        notes.add("G");
        notes.add("G#/Ab");
        notes.add("A");
        notes.add("A#/Bb");
        notes.add("B");
    }

    public String getNote(String startingKey, String newKey, String startingNote) {
        initialize();
        Integer startingValue = musicalKeys.get(startingKey);
        System.out.println(startingValue);

        Integer newValue = musicalKeys.get(newKey);
        System.out.println(newValue);

        Integer relativeValue = startingValue - newValue;
        System.out.println(relativeValue);

        Integer startingNotePosition = notes.indexOf(startingNote);
        System.out.println(startingNotePosition);

        Integer newNotePosition;
        if (startingNotePosition + relativeValue < 0) {
            newNotePosition = startingNotePosition + relativeValue + 12;
        } else {
            newNotePosition = startingNotePosition + relativeValue;
        }

        System.out.println(newNotePosition);

        return notes.get(newNotePosition);
    }
}
