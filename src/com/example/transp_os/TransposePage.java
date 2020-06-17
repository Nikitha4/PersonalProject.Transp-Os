package com.example.transp_os;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates the screen for the TransposePage
 */
public class TransposePage {
    private static JFrame frame;
    private JPanel Transpose;
    private JButton backButton;
    private JComboBox inputKey;
    private JComboBox inputNote;
    private JComboBox outputKey;
    private JLabel outputNote;
    private JLabel instructionOne;
    private JLabel instructionTwo;
    private JLabel instructionThree;
    private JButton answerButton;

    /**
     * creates a new screen with starting attributes for dimension and visibility
     */
    public static void NewScreen() {
        frame = new JFrame("Transp-Os");
        frame.setContentPane(new TransposePage().Transpose);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        frame.setMinimumSize(dimension);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * initializes instance of TransposePage with features that the user can interact with
     */
    public TransposePage() {
        backButton.addActionListener(e -> {
            App.NewScreen();
            frame.setVisible(false);
        });

        answerButton.addActionListener(e -> {
            TransposeNote findAnswer = new TransposeNote();
            String answer = findAnswer.getNote(inputKey.getSelectedItem().toString(),
                    outputKey.getSelectedItem().toString(), inputNote.getSelectedItem().toString());

            outputNote.setText("New Note: " + answer);
        });
    }
}
