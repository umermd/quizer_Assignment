/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizerassg1ap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Umer
 */
public class AddToUserFile {
    private static ObjectOutputStream output; // outputs data to file
    
    public static void openFile()
    {
        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("users.ser")));
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
        List<User> savedusers=new ArrayList();
        savedusers=ReadUserFile.readRecords();
        Iterator itr=savedusers.iterator();
        openFile();
        while(itr.hasNext()){
            try
            {
                // create new record; this example assumes valid input
                User usr =(User)itr.next();
                // serialize record object into file
                output.writeObject(usr);
                System.out.printf("%s\t%s\t%s",usr.getUserName(),usr.getPassword(),usr.getRole());
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


public static void addRecordStudent(String userName, String password, String role, int score)
    {
        savePreviousRecords();
        try
        {
            // create new record; this example assumes valid input
            User usr = new User(userName, password, role, score);
            // serialize record object into file
            output.writeObject(usr);
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

    

    
     public static void addRecordInstructor(String userName, String password, String role)
    {
        savePreviousRecords();
        try
        {
            // create new record; this example assumes valid input
            User usr = new User(userName, password, role);
            // serialize record object into file
            output.writeObject(usr);
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
