/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtexteditor;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author slinger
 */
public class MainController implements Initializable {

    private File file;

    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void createNewFile(ActionEvent event) {
        System.out.println("making new file....");
    }

    @FXML
    private void openFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        //set path to open users home folder
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        //make only .txt files open
        //fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));

        //load home folder
        file = fileChooser.showOpenDialog(null);

        //make sure to check file is not null so program doesn't crash if cancel is pressed
        if (file != null) {
            //read file
            try {
                Scanner reader = new Scanner(file);
                //use stringbuilder because mutability
                StringBuilder stringBuilder = new StringBuilder();

                while (reader.hasNext()) {
                    stringBuilder.append(reader.nextLine()).append("\n");
                    textArea.setText(stringBuilder.toString());
                }

            } catch (FileNotFoundException e) {
                System.out.println("file not loaded");
                System.out.println(e.getMessage());
            }
        }

    }

    @FXML
    private void closeProgram(ActionEvent event) {
    }

    @FXML
    private void saveFile() {
        // work on this
        if (file != null) {
            if (file.exists()) {
                try {
                    PrintWriter printWriter = new PrintWriter(file);
                    printWriter.println(textArea.getText());
                    printWriter.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        } else {

            System.out.println("file does not exist");
        }

    }

    @FXML
    private void saveFileAs(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //default place to save is home
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        //make file have extension of txt
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));

        file = fileChooser.showSaveDialog(null);

        //make sure to check file is not null so program doesn't crash if cancel is pressed
        if (file != null) {
            //get text from file
            try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.println(textArea.getText());
                printWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
