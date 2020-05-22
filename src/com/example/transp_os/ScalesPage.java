package com.example.transp_os;

import org.jfugue.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScalesPage {
    private JPanel Scales;
    private JButton upButton;
    private JButton playButton;
    private JButton downButton;
    private JLabel displayTransposeValue;
    private int transpose_value;

    public static void NewScreen() {
        JFrame frame = new JFrame("Transp-Os");
        frame.setContentPane(new ScalesPage().Scales);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 1000;
        dimension.width = 1000;
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

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++transpose_value;
                transpose_value = transpose_value % 12;
                String display = "Current Transpose Value: " + transpose_value;
                displayTransposeValue.setText(display);
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                --transpose_value;
                transpose_value = transpose_value % 12;
                String display = "Current Transpose Value: " + transpose_value;
                displayTransposeValue.setText(display);
            }
        });
    }
}
