package com.example.transp_os;

import org.jfugue.player.Player;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class UploadPage {

    private static JFrame frame;
    private JPanel Upload;
    private Player player = new Player();
    private JButton backButton;
    private JButton getFileButton;
    private JButton playFileButton;
    private JLabel problemMessage;
    private java.io.File inputFile;

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

        getFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenFile of = new OpenFile();
                try {
                    of.open();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                // new input text
                inputFile = of.file;

                if (inputFile == null) {
                    problemMessage.setText("no file uploaded");
                } else if (!checkFileValidity(inputFile)) {
                    problemMessage.setText("invalid file");
                } else {
                    problemMessage.setText(inputFile.toString());
                }
            }
        });

        playFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               PlayFile(inputFile);
            }
        });
    }

    public boolean checkFileValidity(File file) {
        System.out.println(file);
        String fileString = file.toString();
        String[] fileArray = fileString.split("\\.");
        System.out.println(fileArray[fileArray.length - 1]);
        return fileArray[fileArray.length - 1].equals("mid");
    }

    public void PlayFile(File file) {
        if (file != null && checkFileValidity(file)) {
            Synthesizer synthesizer = null;
            javax.sound.midi.Sequencer sequencer = null;
            InputStream inputStream;
            try {
                synthesizer = MidiSystem.getSynthesizer();
                synthesizer.open();
                synthesizer.loadAllInstruments(synthesizer.getDefaultSoundbank());

                sequencer = MidiSystem.getSequencer(false);
                sequencer.open();
                sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());

                inputStream = new BufferedInputStream(new FileInputStream(file));
                sequencer.setSequence(inputStream);
                org.jfugue.player.SequencerManager.getInstance().setSequencer(sequencer);
                player.play(sequencer.getSequence());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                synthesizer.close();
                sequencer.close();
            }
        }
    }
}
