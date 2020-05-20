/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class ClientGUIController implements Initializable {

    @FXML
    private Label Nametag;
    @FXML
    private Label BalanceTag;
    @FXML
    private Label StatusTag;
    @FXML
    private Button goBack;
    @FXML
    private Tab tab1;
    private int pos;
    private String fileinput1,fileinput2;
    private BufferedReader reader;
    private double initialBalance;
    private ClientAccountMain client = new ClientAccountMain();
    
    private User customerStatus; 
    
    
    private String username;
    @FXML
    private Button sub_but;
    @FXML
    private TextField Depos_text;
    @FXML
    private TextField With_text;
    @FXML
    private Button Wsubmit;
    @FXML
    private TextField purch_text;
    @FXML
    private Button purch_but;
    private Component frame = null;
    

    /**
     * Initializes the controller class.
     */
    
    public void inputData(String usern){
        this.username = usern;
        
        try{
                reader = new BufferedReader(new FileReader(username + ".txt"));
                String line = reader.readLine();
                    fileinput1 = line;
                    line = reader.readLine();
                    fileinput2 = reader.readLine();
                

                reader.close();
            }     
            catch(IOException e){
                System.out.println("Error");
            }
            
        
    }
    
    @FXML
    private void logOut(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window2.setScene(scene);
        window2.show();

    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    //this is going to create an abservable list

    
    
    
    @FXML
    private void tabOne(Event event) throws Exception{
        Nametag.setText("Username: " + fileinput1);
        BalanceTag.setText("Balance: $ " + fileinput2);
       this.initialBalance = Double.parseDouble(fileinput2);
        if(Double.parseDouble(fileinput2) < 10000){
            customerStatus = new Silver(fileinput1,fileinput2);
            pos = customerStatus.getposition();
            StatusTag.setText(customerStatus.getStatus());
        } 
        else if(Double.parseDouble(fileinput2) < 20000){
            customerStatus = new Gold(fileinput1,fileinput2);
            pos = customerStatus.getposition();
            StatusTag.setText(customerStatus.getStatus());
        }
         else if(Double.parseDouble(fileinput2) > 20000){
            customerStatus = new Platinum(fileinput1,fileinput2);
            pos = customerStatus.getposition();
            StatusTag.setText(customerStatus.getStatus());
        }
    }

    @FXML
    private void Deposite(ActionEvent event) {
        try{
        if( (client.deposit(username, initialBalance, Double.parseDouble(Depos_text.getText())) == true)){
            inputData(username);
            tabOne(event);
            Depos_text.setText(null);
        }
        else
            JOptionPane.showMessageDialog(frame,"Please enter a positive number","Inane error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(frame,"Please enter a Number","Inane error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    @FXML
    public void Withdraw(ActionEvent event){
        try{
        if( (client.withdrawMoney(username, Double.parseDouble(fileinput2), Double.parseDouble(With_text.getText())) == true)){
            inputData(username);
            tabOne(event);
            With_text.setText(null);
        }
        else
            JOptionPane.showMessageDialog(frame,"Not Enough Money in the bank","Inane error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(frame,"Enter a valid number that is less than the Balance","Inane error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void purchase(ActionEvent event) throws Exception{
        try{
        if((client.onlinePurchase(username, initialBalance, Double.parseDouble(purch_text.getText()),pos) == true)){
            inputData(username);
            tabOne(event);
            purch_text.setText(null); 
        }
        else
            if(Double.parseDouble(purch_text.getText()) < 50)
                JOptionPane.showMessageDialog(frame,"Purchase Must be greater than $50","Inane error", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(frame,"Not enough Money in the Bank","Inane error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(frame,"Please Enter a Valid number","Inane error", JOptionPane.ERROR_MESSAGE);
        }
       

    }
    }
