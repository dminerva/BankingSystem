/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 123
 */
public class FXMLHomePageController implements Initializable {
    private User currUser;
    private JDBCManager dbm = new JDBCManager();
    
    @FXML private Label userLabel;    
    @FXML private TableView<Account> accountTable;   
    @FXML private TableColumn<Account, Integer> idColumn;
    @FXML private TableColumn<Account, String> typeColumn;    
    @FXML private TableColumn<Account, Double> balanceColumn;
    
    public void setCurrUser(String username) {
        //set user
        currUser = dbm.getUserByEmail(username);
        userLabel.setText(currUser.getFirstName() + " " + currUser.getLastName());
        
        //retrieve users accounts
        idColumn.setCellValueFactory(new PropertyValueFactory<Account, Integer>("accountId"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("accountType"));
        balanceColumn.setCellValueFactory(new PropertyValueFactory<Account, Double>("balance"));
        
        try {
            System.out.println(currUser.toString());
            accountTable.setItems(dbm.getUsersAccounts(currUser.getMemberId()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
