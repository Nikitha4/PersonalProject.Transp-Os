package com.example.transp_os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App {
    private JButton scales_button;
    private JPanel panelMain;
    private JButton upload_button;
    private static JFrame frame;

    public App() {
        scales_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScalesPage second_screen = new ScalesPage();
                second_screen.NewScreen();
                frame.setVisible(false);
            }
        });
        //scales_button.addActionListener(e -> JOptionPane.showMessageDialog(null, "hello"));

        upload_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UploadPage second_screen = new UploadPage();
                second_screen.NewScreen();
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        NewScreen();
        /*frame = new JFrame("Transp-Os");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        frame.setMinimumSize(dimension);
        frame.pack();
        frame.setVisible(true);*/
    }

    public static void NewScreen() {
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
