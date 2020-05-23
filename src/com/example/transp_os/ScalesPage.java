package com.example.transp_os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScalesPage {
    private JPanel Scales;
    private JButton plusButton;
    private JButton minusButton;;
    private JButton playButton;
    private JLabel displayTransposeValue;
    private JCheckBox reverseCheckBox;
    private int transpose_value;
    static boolean isReverse;

    public static void NewScreen() {
        JFrame frame = new JFrame("Transp-Os");
        frame.setContentPane(new ScalesPage().Scales);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        frame.setMinimumSize(dimension);
        frame.pack();
        frame.setVisible(true);
    }

    public ScalesPage() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayMusic music = new PlayMusic();
                music.playScale(transpose_value);
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (transpose_value == 12) {
                    transpose_value = -12;
                } else {
                    ++transpose_value;
                }
                //transpose_value = transpose_value % 13;
                String display = "Current Transpose Value: " + transpose_value;
                displayTransposeValue.setText(display);
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (transpose_value == -12) {
                    transpose_value = 12;
                } else {
                    --transpose_value;
                }
                String display = "Current Transpose Value: " + transpose_value;
                displayTransposeValue.setText(display);
            }
        });

        reverseCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isReverse = reverseCheckBox.getModel().isSelected();
            }
        });
    }
}
