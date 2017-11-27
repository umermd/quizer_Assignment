/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizerassg1ap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umer
 */
public class Quiz implements Serializable {
    String title;
    String description;
    List<Question> questions=new ArrayList();
    Quiz(String title, String description){
        this.title=title;
        this.description=description;
    }
    Quiz(String title, String description, List<Question> qlist)
    {
    this.title=title;
    this.description=description;
    questions=qlist;
    }
    
    Quiz(){}
    
    public String getTitle(){
    return title;
    }
    
    public String getDescription(){
    return description;
    }
    
    public void addQuestionMCQ(String type, String text, String expectedans, String option1, String option2, String option3, String option4){
    questions.add(new Question(type, text, expectedans, option1, option2, option3, option4));
    }
    public void addQuestionTrueFalse(String type, String text, String expectedans, boolean option){
    questions.add(new Question(type, text, expectedans, option));
    }
    public void addQuestionNumeric(String type, String text, String expectedans, double answer){
    questions.add(new Question(type, text, expectedans, answer));
    }
}
