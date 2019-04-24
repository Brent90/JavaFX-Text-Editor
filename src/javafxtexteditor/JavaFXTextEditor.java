
package javafxtexteditor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author slinger
 */
public class JavaFXTextEditor extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
         
        
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            primaryStage.setScene(new Scene(root));
            
           
            
            primaryStage.show();

            //  dbConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }   
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
