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
public class Question implements Serializable {
    String type;
    String text;
    String expected;
    String[] mcqarray=new String[4];
    boolean truefalse;
    double numans;
    
    //for MCQs
    Question(String type, String text, String expectedans, String option1, String option2, String option3, String option4){
        this.type=type;
        this.text=text;
        this.expected=expectedans;
        mcqarray[0]=option1;
        mcqarray[1]=option2;
        mcqarray[2]=option3;
        mcqarray[3]=option4;
    }
    
    //For True False
    Question(String type, String text, String expectedans, boolean option){
        this.type=type;
        this.text=text;
        this.expected=expectedans;
        truefalse=option;
    }
    //Other Questions
    Question(String type, String text, String expectedans, double answer){
        this.type=type;
        this.text=text;
        this.expected=expectedans;
        numans=answer;
    }
}
