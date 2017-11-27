/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizerassg1ap;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umer
 */
public class QuizerModelRead {
    private static ObjectInputStream input;
    
    public static void openFile(){
        try // open file
        {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("quizzes.ser")));
        }    
        catch (IOException ioException)
        {
           System.err.println("Error opening file.");
           System.exit(1); 
        }
    }
    
    public static List readRecords(){
        List<Quiz> qlist=new ArrayList();
        openFile();
        try
        {
            while (true) // loop until there is an EOFException
            {   
                qlist.add((Quiz) input.readObject());
            }
        }
        catch (EOFException endOfFileException)
        {
            System.out.printf("No more records%n");
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch (IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
        closeFile();
        return qlist;
    }
    
    public static Quiz readRecord(String title){
        openFile();
        try
        {
            while (true) // loop until there is an EOFException
            {   
                Quiz record = (Quiz) input.readObject();
                String tt=record.getTitle();
                if(tt.equals(title)){
                    return record;
                }
            }
        }
        catch (EOFException endOfFileException)
        {
            System.out.printf("No more records%n");
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch (IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
        closeFile();
        return new Quiz();
    } // end method readRecords
    
    public static void closeFile()
    {
        try
        {
            if (input != null)
            input.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
            System.exit(1);
        }
    }
}
