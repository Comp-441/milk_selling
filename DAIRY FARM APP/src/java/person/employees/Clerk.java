package person.employees;

import database.Database;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.employees.designation.Designation;
import production.cow.Cow;
import production.produce.MilkProduced;
import production.sales.Sales;

public class Clerk  extends Employee implements Serializable{


    public Clerk(Date dateOfBirth, String password, String firstName, String secondName, String phoneNumber) {
        super(dateOfBirth, password, firstName, secondName, phoneNumber);
        
        this.setDesignation(Designation.Clerk);
    }

    public Clerk(String firstName, String secondName) {
        super(firstName, secondName);
    }
    
    
    
     public Clerk(int empId) {
        super(empId);
    }

    public Clerk() {
    }
     
    

    public  boolean addMilkProduced(MilkProduced produced){
        boolean inserSuccessFull=false;
 
        try {
            Database database= new Database();
            
            //Query for inserting produce
            String query="INSERT INTO `milkproduced` (`production_Id`, `emp_id`, `quantity`, `date_added`, `cow_id`, `remark`) VALUES (?, ?, ?, ?, ?, ?)";
            
            //Loading a prepared statement from database object
            PreparedStatement statement= database.getPreparedStatement(query);
            
            
            statement.setString(1, produced.getProductionId());
            statement.setInt(2, this.getEmpId());
            
            statement.setDouble(3, produced.getQuantity());
            statement.setDate(4, (Date) produced.getDateAdded());
            
            statement.setString(5, produced.getCow().getId());
            statement.setString(6, produced.getRemarks());
            
            inserSuccessFull=database.insertToDB(statement);
            database.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Clerk.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inserSuccessFull;
    }
    
    
    
    public  boolean sellMilk(Sales sale){
        boolean inserSuccessFull=false;

        try {
            Database database= new Database();
            
            String query="INSERT INTO `sales` (`sale_Id`, `production_Id`, `emp_id`, `quantity_sold`, `date_sold`) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement statement= database.getPreparedStatement(query);
            
            
            statement.setString(1, sale.getSaleId());
            statement.setString(2, sale.getProduction().getProductionId());
            
            statement.setInt(3, this.getEmpId());
            statement.setDouble(4, sale.getQuantity());
            
            statement.setDate(5, sale.getDateProduced());
            
            inserSuccessFull=database.insertToDB(statement);
             database.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Clerk.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return inserSuccessFull;
    }
    
    
    
    
    public  boolean addCow(Cow cow){
          boolean inserSuccessFull=false;

        try {
            Database database= new Database();
            
            String query="INSERT INTO `cow` (`nickname`, `cow_id`) VALUES(?, ?)";
            
            PreparedStatement statement= database.getPreparedStatement(query); 
            
            statement.setString(1, cow.getUsername());
            statement.setString(2, cow.getId());
            
            inserSuccessFull=database.insertToDB(statement);
            database.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Clerk.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return inserSuccessFull;
    }
    
}
