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
public class Gold extends User{

    public Gold(String user, String psd) {
        super(user, psd);

    }

    @Override
    public int getposition() {
        return 2; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStatus() {
        return "Your Status is: Gold";//To change body of generated methods, choose Tools | Templates.
    }
    
}
