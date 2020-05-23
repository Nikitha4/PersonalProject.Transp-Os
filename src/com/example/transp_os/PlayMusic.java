package com.example.transp_os;

import org.jfugue.player.Player;

import java.util.ArrayList;
import java.util.List;


public class PlayMusic {
    String[] notes = new String[]{"C4", "Db4", "D4", "Eb4" ,"E4", "F4", "Gb4", "G4", "Ab4", "A4", "Bb4", "B4",
            "C5", "Db5", "D5", "Eb5" ,"E5", "F5", "Gb5", "G5", "Ab5", "A5", "Bb5", "B5",
            "C6", "Db6", "D6", "Eb6" ,"E6", "F6", "Gb6", "G6", "Ab6", "A6", "Bb6", "B6",
            "C7"};
    int[] baseScalePositions = new int[]{12, 14, 16, 17, 19, 21, 23, 24};
    String scaleToPlay = "";
    int count = 0;

    public void playScale(int current_transpose_value) {

        for (int i = 0; i < 8; i++) {
            count++;
            scaleToPlay += (notes[baseScalePositions[i] + current_transpose_value] + " ");
        }

        ScalesPage userChoice = new ScalesPage();
        System.out.println(userChoice.isReverse);
        if(userChoice.isReverse) {
            for (int i = 6; i >= 0; i--) {
                count++;
                scaleToPlay += (notes[baseScalePositions[i] + current_transpose_value] + " ");
            }
        }

        System.out.println(scaleToPlay);
        Player player = new Player();
        player.play(scaleToPlay);

    }
}
