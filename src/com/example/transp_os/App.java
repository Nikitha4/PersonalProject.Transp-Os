package com.example.transp_os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * App class calls the starting method and begins the application
 */
public class App {
    private JButton scalesButton;
    private JPanel panelMain;
    private JButton uploadButton;
    private JButton transposeButton;
    private JLabel title;
    private static JFrame frame;

    /**
     * initializes instance of App class with three buttons that can open different pages
     */
    public App() {
        scalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScalesPage.NewScreen();
                // makes App.form gui not visible when ScalesPage is opened
                frame.setVisible(false);
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UploadPage.NewScreen();
                // makes App.form gui not visible when UploadPage is opened
                frame.setVisible(false);
            }
        });

        transposeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransposePage.NewScreen();
                // makes App.form gui not visible when TransposePage is opened
                frame.setVisible(false);
            }
        });

    }

    /**
     * opens an App.form gui to start the application
     * @param args parameter for main function
     */
    public static void main(String[] args) {
        NewScreen();
    }

    /**
     * creates a new screen with starting attributes for dimension and visibility
     */
    static void NewScreen() {
        frame = new JFrame("Transp-Os");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        frame.setMinimumSize(dimension);
        frame.pack();
        frame.setVisible(true);
    }
}
