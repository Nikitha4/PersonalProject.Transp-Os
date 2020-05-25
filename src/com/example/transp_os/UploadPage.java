package com.example.transp_os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UploadPage {

    private static JFrame frame;
    private JPanel Upload;
    private JButton backButton;

    public static void NewScreen() {
        frame = new JFrame("Transp-Os");
        frame.setContentPane(new UploadPage().Upload);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        frame.setMinimumSize(dimension);
        frame.pack();
        frame.setVisible(true);
    }

    public UploadPage() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App mainScreen = new App();
                mainScreen.NewScreen();
                frame.setVisible(false);
            }
        });
    }
}
