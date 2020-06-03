package com.example.transp_os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransposePage {
    private static JFrame frame;
    private JPanel Transpose;
    private JButton backButton;
    private JComboBox inputKey;
    private JComboBox inputNote;
    private JComboBox outputKey;
    private JLabel outputNote;
    private JButton answerButton;
    private JLabel instructionOne;
    private JLabel instructionTwo;
    private JLabel InstructionThree;

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

    public TransposePage() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App mainScreen = new App();
                mainScreen.NewScreen();
                frame.setVisible(false);
            }
        });

        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransposeNote findAnswer = new TransposeNote();
                String answer = findAnswer.getNote(inputKey.getSelectedItem().toString(), outputKey.getSelectedItem().toString(),
                        inputNote.getSelectedItem().toString());

                outputNote.setText("New Note: " + answer);
            }
        });

    }
}
