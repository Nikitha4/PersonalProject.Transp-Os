package com.example.transp_os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates the screen for the ScalesPage
 */
public class ScalesPage {
    private static final int NUMBER_OF_POSITIVE_TRANSPOSE_VALUES = 12;
    private static JFrame frame;
    private JPanel Scales;
    private JButton plusButton;
    private JButton minusButton;;
    private JButton playButton;
    private JLabel displayTransposeValue;
    private JCheckBox reverseCheckBox;
    private JButton backButton;
    private int transpose_value;
    /**
     * true if user does want the reverse scale, false is user does not want the reverse scale
     */
    static boolean isReverse;

    /**
     * creates a new screen with starting attributes for dimension and visibility
     */
    public static void NewScreen() {
        frame = new JFrame("Transp-Os");
        frame.setContentPane(new ScalesPage().Scales);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        frame.setMinimumSize(dimension);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * initializes instance of ScalesPage with features that the user can interact with
     */
    public ScalesPage() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TranposeScales music = new TranposeScales();
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
                String display = "Current Transpose Value: " + transpose_value;
                displayTransposeValue.setText(display);
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (transpose_value == -NUMBER_OF_POSITIVE_TRANSPOSE_VALUES) {
                    transpose_value = NUMBER_OF_POSITIVE_TRANSPOSE_VALUES;
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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.NewScreen();
                frame.setVisible(false);
            }
        });
    }
}
