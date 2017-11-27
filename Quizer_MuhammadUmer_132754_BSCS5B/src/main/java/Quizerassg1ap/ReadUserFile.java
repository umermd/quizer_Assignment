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
import javax.swing.JOptionPane;
/**
 *
 * @author Umer
 */
public class ReadUserFile {
    private static ObjectInputStream input;
    
    public static void openFile(){
        try // open file
        {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("users.ser")));
        }    
        catch (IOException ioException)
        {
           System.err.println("Error opening file.");
           System.exit(1); 
        }
    }
    
    public static List readRecords(){
        List<User> userlist=new ArrayList();
        openFile();
        try
        {
            while (true) // loop until there is an EOFException
            {   
                userlist.add((User) input.readObject());
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
        return userlist;
    }
    
    public static User readRecord(String userName, String password){
        openFile();
        try
        {
            while (true) // loop until there is an EOFException
            {   
                User record = (User) input.readObject();
                String un=record.getUserName();
                String ps=record.getPassword();
                if((un.equals(userName))&&(ps.equals(password))){
                    record.printUser();
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
        return new User();
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
