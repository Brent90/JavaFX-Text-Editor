/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.scene.control.Tab;
import javafx.stage.FileChooser;

/**
 *
 * @author slinger
 */
public class FileOperations {

    private final FileChooser fileChooser = new FileChooser();
    private File file;

    public FileOperations() {
        this.fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

    }

    public StringBuilder openFile() {
        //opens and loads the file
        file = fileChooser.showOpenDialog(null);
        StringBuilder stringBuilder = new StringBuilder();

        if (file != null) {
            try {
                Scanner reader = new Scanner(file);
                while (reader.hasNext()) {
                    stringBuilder.append(reader.nextLine()).append("\n");
                }

            } catch (FileNotFoundException e) {
                System.out.println("file not loaded");
                System.out.println(e.getMessage());
            }
        } else {
            //user hit cancel so nothing to do
        }

        return stringBuilder;

    }

    public void saveFileAs(String text) {

        //make file have extension of txt
        //fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        file = fileChooser.showSaveDialog(null);

        //make sure to check file is not null so program doesn't crash if cancel is pressed
        if (file != null) {
            myPrintWriter(text);

        }
    }

    public void saveFile(String text) {
        //this is a quick save so you don't need to go through dialog popup each time
        //if the file doesn't exist it calls saveFileAs

        if (file != null) {
            if (file.exists()) {
                myPrintWriter(text);
            }
        } else {
            saveFileAs(text);
        }

    }

    public void myPrintWriter(String text) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(text);
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFileName() {
        return file.getName();
    }

    public StringBuilder getFile() {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                stringBuilder.append(reader.nextLine()).append("\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not loaded");
            System.out.println(e.getMessage());
        }
        return stringBuilder;
    }

}
