package id_reader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class TextIO {
    
    
        
    public static int read_id(String fileName){
        
        int id=0;
        try {
            
            File file=new File(fileName);
            
            Scanner scanner=new Scanner(file);
            id=Integer.parseInt(scanner.nextLine());
              
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return id;
    } 
    
    
        public static void upadate_id(String fileName){
       
            
           int id =read_id(fileName);
        try {
            
            File file=new File(fileName);
            
            FileWriter fileWriter=new FileWriter(file);
           
            
            fileWriter.write(""+ ++id);
            fileWriter.close();
                        
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(TextIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
}
