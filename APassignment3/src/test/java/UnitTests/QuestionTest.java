/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Entity.Question;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Muhammad Umer
 */
public class QuestionTest extends TestCase {
    @Test
    public void testQuestionsEquivalency() {
        Question qa=new Question("MCQ","Earth is Flat","False");
        Question qb=new Question("MCQ","Earth is Flat","False","Yes","True","Almost","False");
        Question qc=new Question("True/False","Earth is Flat","False");
        Question qd=new Question("True/False","Earth is Flat","True");
        
        assertFalse(qa.equals(qb));
        assertFalse(qc.equals(qd));
    }
    
}
