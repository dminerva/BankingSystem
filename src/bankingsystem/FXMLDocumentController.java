/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author 123
 */
public class FXMLDocumentController implements Initializable {
    private JDBCManager dbm = new JDBCManager();
    
    @FXML
    private TextField usernameField, passwordField;
    
    @FXML 
    private Label errorMsg;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if(dbm.login(username, password) == true) {
            /*Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();*/

            //create a new scene
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLHomePage.fxml"));
            Parent home_page_parent = loader.load();
            Scene home_page_scene = new Scene(home_page_parent);
            
            //access the new scenes controller and call a method
            FXMLHomePageController controller = loader.getController();
            controller.setCurrUser(username);
            
            //open new scene
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        } else {
            usernameField.clear();
            passwordField.clear();
            errorMsg.setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
