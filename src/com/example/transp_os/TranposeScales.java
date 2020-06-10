package com.example.transp_os;

import org.jfugue.player.Player;

/**
 * TransposeScales class is used to construct/transpose and play musical scales
 */
public class TranposeScales {

    private static final int LENGTH_OF_SCALE = 8;
    private static final int LENGTH_OF_REVERSE_SCALE = 6;

    // String array of musical notes ranging from C4 to C7
    // these notes will be used to construct the transposed scale
    private final String[] notes = new String[]{"C4", "Db4", "D4", "Eb4" ,"E4", "F4", "Gb4", "G4", "Ab4", "A4", "Bb4", "B4",
            "C5", "Db5", "D5", "Eb5" ,"E5", "F5", "Gb5", "G5", "Ab5", "A5", "Bb5", "B5",
            "C6", "Db6", "D6", "Eb6" ,"E6", "F6", "Gb6", "G6", "Ab6", "A6", "Bb6", "B6",
            "C7"};

    // int array of note positions for the C Scale, which is used as the reference scale for transposition
    private final int[] baseScalePositions = new int[]{12, 14, 16, 17, 19, 21, 23, 24};


    /**
     * plays back the transposed scale
     * @param currentTransposeValue takes in how far up/down the C scale is transposed
     */
    public void playScale(int currentTransposeValue) {

        // initialize empty String for the scale
        String scaleToPlay = "";

        for (int i = 0; i < LENGTH_OF_SCALE; i++) {

            // adds each note of the transposed scale to the String scaleToPlay
            scaleToPlay += (notes[baseScalePositions[i] + currentTransposeValue] + " ");
        }

        // if user wants the reverse scale to played as well, adds each note of the transposed reverse scale
        // to the String scaleToPlay
        if(ScalesPage.isReverse) {
            for (int i = LENGTH_OF_REVERSE_SCALE; i >= 0; i--) {
                scaleToPlay += (notes[baseScalePositions[i] + currentTransposeValue] + " ");
            }
        }

        Player player = new Player();
        player.play(scaleToPlay);
    }
}
