/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author danie
 */
public class Platinum extends User{

    public Platinum(String user, String psd) {
        super(user, psd);

    }

    @Override
    public int getposition() {
        return 3; 
    }

    @Override
    public String getStatus() {
        return "Your Status is: Platinum";//To change body of generated methods, choose Tools | Templates.
    }
    
}
