package javafxtexteditor;

import FileOperations.FileOperations;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author slinger
 */
public class MainController implements Initializable {

    private File file;
    private FileOperations fileOperations = new FileOperations();

    @FXML
    private TextArea textArea;
    @FXML
    private TabPane tabPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabPane.setTabMinWidth(150);

    }

    @FXML
    private void createNewFile(ActionEvent event) {
    
    }

    @FXML
    private void openFile(ActionEvent event) {
        textArea.setText(fileOperations.openFile().toString());
    }

    @FXML
    private void saveFile() {
        fileOperations.saveFile(textArea.getText());

    }

    @FXML
    private void saveFileAs() {
        fileOperations.saveFileAs(textArea.getText());
    }

}
