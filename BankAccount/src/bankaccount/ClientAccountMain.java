/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class ClientAccountMain {
    private String newUserName,newPasword, bal;
    private BufferedReader reader;
    private FileWriter fr = null;
    
    public boolean deposit(String username, double initialBal, double newBal){
        try{
                reader = new BufferedReader(new FileReader(username + ".txt"));
                String line = reader.readLine();
                    newUserName = line;
                    newPasword = reader.readLine();
                    bal = reader.readLine();
                reader.close();
            //}
        //try{
            fr = new FileWriter(username + ".txt");
            fr.write(username+ "\n");
            fr.write(newPasword + "\n");
            if(newBal < 0){
                fr.close();
                return false;}
            else{
            newBal = newBal + initialBal;
            fr.write(Double.toString(newBal));
            fr.close();
            return true;
            }
        }
        catch(IOException e){
                System.out.println("Error");
                return false;
            }
            
}
    
        public boolean withdrawMoney(String username, double initialBal, double newBal){
        FileWriter fr = null;
        try{
                reader = new BufferedReader(new FileReader(username + ".txt"));
                String line = reader.readLine();
                    newUserName = line;
                    newPasword = reader.readLine();
                    bal = reader.readLine();
                reader.close();
            //}
        //try{
            fr = new FileWriter(username + ".txt");
            fr.write(username+ "\n");
            fr.write(newPasword + "\n");
            if(initialBal - newBal < 0 || newBal < 0){
                fr.write(Double.toString(initialBal));
                fr.close();
                return false;
            }
            else{
                newBal = initialBal - newBal;
                fr.write(Double.toString(newBal));
                fr.close();
                return true;
            }
        }
        catch(IOException e){
                return false;
            }
            
}
        public boolean onlinePurchase(String username, double initial, double purch,int pos){
        FileWriter fr = null;
        try{
                reader = new BufferedReader(new FileReader(username + ".txt"));
                String line = reader.readLine();
                    newUserName = line;
                    newPasword = reader.readLine();
                    bal = reader.readLine();
                reader.close();
            //}
        //try{
            if(purch < 50)
                return false;
            else{
                if(pos == 1)
                    purch = purch + 20;
                if(pos == 2)
                    purch = purch + 10;
                if(pos == 3)
                    purch = purch;
            }
            fr = new FileWriter(username + ".txt");
            fr.write(username+ "\n");
            fr.write(newPasword + "\n");
             if(initial - purch < 0){
                fr.write(Double.toString(initial));
                fr.close();
                return false;
            }
             else
             {
                 purch = initial - purch;
                fr.write(Double.toString(purch));
                fr.close();
            return true;
             }
        }
        catch(IOException e){
                System.out.println("Error");
                return false;
            }            
        }
}
