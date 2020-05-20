/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author danie
 */
public class ManagerAcount extends Application {
    private ArrayList<User> Customers = new ArrayList<User>();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public boolean CreateAcount(String user, String psd){
        try{
        File file = new File(user + ".txt");
        if (file.createNewFile()) {
            Customers.add(new Silver(user,psd));
            return true;
        }
        else{
          return false;
        }
        } catch (IOException ex) {
            //Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean WriteToAccount(String user, String psd){
        
        FileWriter fr = null;
        try{
            fr = new FileWriter(user + ".txt");
            fr.write(user+ "\n");
            fr.write(psd + "\n");
            fr.write("100.0");
            fr.close();
        }
        catch(IOException e){
            return false;
        }
        return true;
    }
    
    public boolean DeleteAcount(String user){
        try{
        if(Files.deleteIfExists(Paths.get(user + ".txt")) == true){
            return true;
        }
        return false;
        }
        catch(Exception e){
            return false;
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         launch(args);
       
    }
    
}
