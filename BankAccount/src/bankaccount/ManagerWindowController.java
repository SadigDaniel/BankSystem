/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;


import java.awt.Component;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class ManagerWindowController implements Initializable {

    @FXML
    private MenuButton menu;
    @FXML
    private MenuItem Acion1;
    @FXML
    private MenuItem Delete;
    @FXML
    private Button Logout;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private Label txt1;
    @FXML
    private Label txt2;
    @FXML
    private Button submit;
    private Component frame = null;
    private ManagerAcount manager = new ManagerAcount();
    
   @FXML
    private void goToMain(ActionEvent event) throws Exception{
        
            menu.setText("logout");
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
             //This line gets the stage information
             Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
             window2.setScene(scene);
             window2.show();

    }
    @FXML
    private void AddClient(ActionEvent event) throws Exception{
        menu.setText("ADD");
        txt1.setText("Username: ");
        txt2.setText("Password: ");
                        
    }
    @FXML
    private void DeleteKey(ActionEvent event) throws Exception{
        menu.setText("Delete");
        txt1.setText("Delete Username: ");
        txt2.setText(" ");
    }
    
    @FXML
    private void AddCustomer(ActionEvent event) throws Exception{
        if(menu.getText().equals("ADD")){
            if(Username.getText().equals(null) || Password.getText().equals(null) || Username.getText().equals("") || Password.getText().equals("") ||Username.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Username or password can not be null","Inane error", JOptionPane.ERROR_MESSAGE);}
            
            else if(Username.getText().equals("admin") || Password.getText().equals("admin")){
                JOptionPane.showMessageDialog(frame,"Username or password alreadexit","Inane", JOptionPane.ERROR_MESSAGE);}
            
            else if(!(Username.getText().equals(null) || Username.getText().isEmpty() || Username.getText().equals("admin"))){
                if(manager.CreateAcount(Username.getText(), Password.getText())== true){
                    JOptionPane.showMessageDialog(frame,"Suscsesfully created a user");
                    manager.WriteToAccount(Username.getText(), Password.getText());
                    Username.setText("");
                    Password.setText("");
                    
                }
                else
                    JOptionPane.showMessageDialog(frame,"This username already exist","Inane error", JOptionPane.ERROR_MESSAGE);

                
            }
        
    }
        else if(menu.getText().equals("Delete")){
          if(manager.DeleteAcount(Username.getText()) == true){
            JOptionPane.showMessageDialog(frame,"Suscsesfully Deleted");
            Username.setText("");
            
        }
            else
                JOptionPane.showMessageDialog(frame,"This user does not exist","Inane error", JOptionPane.ERROR_MESSAGE);
        }
        
        else
            JOptionPane.showMessageDialog(frame,"Select an option from the drop down menu first","Inane error", JOptionPane.ERROR_MESSAGE);
        

    }


    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
