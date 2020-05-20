/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.io.BufferedReader;
import java.io.FileReader;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author danie
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField usernam;
    @FXML
    private Label passtxt;
    @FXML
    private Button button;
    @FXML
    private Label error;
    @FXML
    private PasswordField pasword;
    private String fileInput1;
    private String fileInput2;

    private BufferedReader reader;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if(usernam.getText().equals("admin") && pasword.getText().equals("admin")){

            Parent managerparent = FXMLLoader.load(getClass().getResource("ManagerWindow.fxml"));
             Scene managerview = new Scene(managerparent);
             //This line gets the stage information
             Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
             window.setScene(managerview);
             window.show();
        }
       
        else{
            try{
                reader = new BufferedReader(new FileReader(usernam.getText() + ".txt"));
                String line = reader.readLine();
                    fileInput1 = line;
                    fileInput2 = reader.readLine();
                reader.close();
                if(fileInput1.equals(usernam.getText()) && fileInput2.equals(pasword.getText())){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("ClientGUI.fxml"));
                    Parent cPage = loader.load();
                    Scene cScene = new Scene(cPage);
                    ClientGUIController controller = loader.getController();
                    controller.inputData(usernam.getText());
                    Stage cStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    cStage.setScene(cScene);
                    cStage.show();
                    
                }
                else
                    error.setText("Invalid1");
                
            
        }catch(IOException e){
            error.setText("Invalid");
        }
        }
    }
    
    

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
