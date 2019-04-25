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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
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
    private final FileOperations fileOperations = new FileOperations();
    private final Map<Tab, String> tabList = new HashMap<>();

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
        tabPane.getSelectionModel().selectedItemProperty().addListener(c -> {
            textArea.setText(tabList.get(tabPane.getSelectionModel().getSelectedItem()));
        });

    }

    @FXML
    private void createNewFile() {
        Tab tab = new Tab("new tab");
        tabPane.getTabs().add(tab);
    }

    @FXML
    private void openFile(ActionEvent event) {
        textArea.setText(fileOperations.openFile().toString());

        try {
            Tab tab = new Tab(fileOperations.getFileName());
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
            tabList.put(tabPane.getSelectionModel().getSelectedItem(), fileOperations.getFile().toString());
            textArea.setText(fileOperations.getFile().toString());
        } catch (Exception e) {
        }

    }

    @FXML
    private void saveFile() {
        fileOperations.saveFile(textArea.getText());
        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        tab.setText(fileOperations.getFileName());
        tabList.put(tabPane.getSelectionModel().getSelectedItem(), fileOperations.getFile().toString());
        textArea.setText(fileOperations.getFile().toString());

    }

    @FXML
    private void saveFileAs() {
        fileOperations.saveFileAs(textArea.getText());
        // Tab tab = new Tab(fileOperations.getFileName());
        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        tab.setText(fileOperations.getFileName());
        tabList.put(tabPane.getSelectionModel().getSelectedItem(), fileOperations.getFile().toString());
        textArea.setText(fileOperations.getFile().toString());

    }

}
