/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 123
 */
public class JDBCManager {
    private String dbUrl = "jdbc:mysql://localhost/banking_system";
    private String user = "root";
    private String pass = "";
    private Connection conn;

    public JDBCManager() {
        //get connection
        try {
            conn = (Connection) DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //login
    public boolean login(String email, String pass) {
        boolean success = false;
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE email='" + email + "' AND password='" + pass + "'";            
            ResultSet rs = stmt.executeQuery(sql); 
            
            if(rs.next() == true) {
                success = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public User getUserByEmail(String email) {
        User currUser = new User();
        
        try {
            Statement stmt = conn.createStatement();            
            String sql = "SELECT * FROM user WHERE email='" + email + "'";            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                currUser.setMemberId(rs.getInt("member_id"));
                currUser.setEmail(rs.getString("email"));
                currUser.setPassword(rs.getString("password"));
                currUser.setFirstName(rs.getString("first_name"));
                currUser.setLastName(rs.getString("last_name"));
                currUser.setAddress(rs.getString("address"));
                currUser.setPhoneNumber(rs.getString("phone_number"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCManager.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return currUser;
    }
    
    public ObservableList<Account> getUsersAccounts(int memberID) { 
        ObservableList<Account> userAccounts = FXCollections.observableArrayList();
        
        try {     
            Statement stmt = conn.createStatement();            
            String sql = "SELECT * FROM account WHERE member_id='" + memberID + "'";            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Account account = new Account(rs.getInt("account_id"), rs.getInt("member_id"), rs.getString("account_type"), rs.getDouble("balance"));
                userAccounts.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userAccounts;
    }
}
