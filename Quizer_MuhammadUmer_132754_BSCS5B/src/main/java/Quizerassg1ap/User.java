/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizerassg1ap;

import java.io.Serializable;

/**
 *
 * @author Umer
 */

//Class User
public class User implements Serializable{
    private String userName;
    private String password;
    private String role;
    private int score;
    
    //Setters and Getters
    
    public int getScore(){
    return score;
    }
    
    public void setScore(int score){
    this.score=score;
    }
    
    public String getUserName(){
    return userName;
    }
    
    public void setUserName(String userName){
    this.userName=userName;
    }
    
    public String getPassword(){
    return password;
    }
    
    public void setPassword(String password){
    this.password=password;
    }
    
    public String getRole(){
    return role;
    }
    
    public void setRole(String role){
    this.role=role;
    }
    
    //Print method
    public void printUser(){
    System.out.printf("%s\t%s\t%s\t%d",getUserName(),getPassword(),getRole(),getScore());
    }
    
    //COnstructor
    //For Student
    User(String userName, String password, String role, int score){
        setUserName(userName);
        setPassword(password);
        setRole(role);
        setScore(score);
    }
    
    //For Insturctor
    User(String userName, String password, String role){
        setUserName(userName);
        setPassword(password);
        setRole(role);
    }
    User(){
    setUserName(null);
    }
}