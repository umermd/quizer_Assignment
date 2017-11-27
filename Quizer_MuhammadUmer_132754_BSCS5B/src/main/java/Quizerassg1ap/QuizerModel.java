/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizerassg1ap;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Umer
 */
public class QuizerModel {
      private static ObjectOutputStream output; // outputs data to file
    
    public static void openFile()
    {
        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("quizzes.ser")));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }
    }
    
    public static void closeFile()
    {
        try
        {
            if (output != null)
            output.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
        }
    }

    public static void savePreviousRecords(){
        List<Quiz> savedquizzes=new ArrayList();
        savedquizzes=QuizerModelRead.readRecords();
        Iterator itr=savedquizzes.iterator();
        openFile();
        while(itr.hasNext()){
            try
            {
                // create new record; this example assumes valid input
                Quiz qz =(Quiz)itr.next();
                // serialize record object into file
                output.writeObject(qz);
                System.out.printf("%s\t%s",qz.getTitle(),qz.getDescription());
            }
            catch (NoSuchElementException elementException)
            {
                System.err.println("Invalid input. Please try again.");
            }
            catch (IOException ioException)
            {
                System.err.println("Error writing to file. Terminating.");
            }
        }
    }


public static void addQuiz(String title, String description, List<Question> qlist)
    {
        savePreviousRecords();
        try
        {
            // create new record; this example assumes valid input
            Quiz qz = new Quiz(title, description, qlist);
            // serialize record object into file
            output.writeObject(qz);
        }
        catch (NoSuchElementException elementException)
        {
            System.err.println("Invalid input. Please try again.");
        }
        catch (IOException ioException)
        {
            System.err.println("Error writing to file. Terminating.");
        }
        closeFile();
    }
}
