package person.employees;

import database.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Employee{

    public Manager() {
        
    }
    
    public  boolean addClerk(Clerk clerk){
        boolean inserSuccessFull=false;
        try {
            Database database= new Database();
            
            //Query for inserting produce
            String query="INSERT INTO `employee` (`first_name`, `last_name`, `designation`, `phone_no`, `date_added`, `password`)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            
            //Loading a prepared statement from database object
            PreparedStatement statement= database.getPreparedStatement(query);
            
            statement.setString(1, clerk.getFirstName());
            statement.setString(2, clerk.getSecondName());
            
            statement.setString(3, clerk.getDesignation().toString());
            statement.setString(4, clerk.getPhoneNumber());
            
            statement.setDate(5, clerk.getDateAdded());
            statement.setString(6, clerk.getPassword());
            
            inserSuccessFull= database.insertToDB(statement);
            database.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return inserSuccessFull;
    }

    public  void removeClerk(Clerk clerk){

    }

}
