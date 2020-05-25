package com.example.transp_os;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class OpenFile {
    JFileChooser fileChooser = new JFileChooser();
    StringBuilder sb = new StringBuilder();
    File file;

    public void Open() throws Exception {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            // retrieves file
            file = fileChooser.getSelectedFile();

            // make a scanner for the file
            /*Scanner input = new Scanner(file);

            System.out.println("4");
            // read text from file
            while(input.hasNext()) {
                System.out.println("5");
                sb.append(input.nextLine());
                sb.append("\n");
            }
            input.close();*/
        } else {
            sb.append("No file was selected");
        }

    }
}
