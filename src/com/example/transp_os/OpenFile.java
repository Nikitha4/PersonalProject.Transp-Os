package com.example.transp_os;

import javax.swing.*;
import java.io.File;

/**
 * OpenFile allows files to be opened from the device's file explorer
 */
public class OpenFile {
    private JFileChooser fileChooser = new JFileChooser();

    /**
     * instance variable that stores user's selected file
     */
    File file;

    /**
     * checks if the selected file can be opened and stores the file
     */
    void open() {

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            // retrieves file
            file = fileChooser.getSelectedFile();

        }
    }
}
