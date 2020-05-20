/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author Daniel Sadig 
 * Student Number: 500894225
 * 
 * Overview
 *  This class describes what is needed to create a new user, it looks at the username, password and role
 *  it is an abstract class that is later extended by the other customer classes 
 *  The username and password are immutable since they are final and can not be changed latter
 * must be extended by another class
 * 
 * Abstraction function is 
 * 
 *   AF(c): an abstract user class User class U
 *   U username = c.username
 *   U password = c.password
 * 
 * Rep invariant is
 * 
 *  RF(c) = False if password or username are null
 *                  password or username are empty
 *                  password or username are equal to admin
 *      = true otherwise
 * 
 * 
 * 
 *specs for constructor
 * Constructor: pass in a username and password 
 * 
 * 
 */
public abstract class User {
    //The username and password of the client 
    final private String  username, password;
    
    
    //Requiers: pass in 2 string 
    //Modifies:NONE
    //Effects: sets the username and password 
    public User (String user, String psd){
        this.username = user;
        this.password = psd;
        RepOk();
    }
    
    //returns the password of the client 
    private String getPassowrd(){
        return this.password;
    }
    
    //Effects: returns the username of the cleint 
    private String getUsername(){
        return this.username;
    }
    
    //Effect: returns the position of the client interms of a number 1 = silver, 2 = Gold, 3 = platinum
    public abstract int getposition();
    
    //Effects: returns the position of the client interms of a string 
    public abstract String getStatus();
    
    //Effects: implements the abstraction function and returns the output of the abstraction function
    @Override
    public String toString(){
        String hold;
        hold = "Username: " + getUsername() + "\n" + "Password :" + getPassowrd(); 
        return hold;
    }
    
    //Effects: Checks if the input is valid when creating a user following the rep invariant instructions
    public boolean RepOk(){
       if((username.isEmpty() || username.equals(null) || username =="admin" ) || (password.isEmpty() || password == null || password == "admin")){
        return false;
    }
        else  {
        return true;
                }
    }
    
}
