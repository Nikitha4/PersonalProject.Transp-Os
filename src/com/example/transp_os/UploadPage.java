package com.example.transp_os;

import javax.swing.*;
import java.awt.*;

public class UploadPage {

    private JPanel Upload;

    public static void NewScreen() {
        JFrame frame = new JFrame("Transp-Os");
        frame.setContentPane(new UploadPage().Upload);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension();
        dimension.height = 500;
        dimension.width = 500;
        frame.setMinimumSize(dimension);
        frame.pack();
        frame.setVisible(true);
    }
}
