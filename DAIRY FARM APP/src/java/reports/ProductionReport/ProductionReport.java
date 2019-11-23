/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.ProductionReport;

import database.Database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.employees.Clerk;
import production.cow.Cow;
import production.produce.MilkProduced;

/**
 *
 * @author root
 */
public class ProductionReport {
    
    
    public ArrayList<MilkProduced> productionReport(Date from, Date to, String cowID, double minQuantity, double maxQuantity){
         ArrayList<MilkProduced>  report= new ArrayList<>();

        
        try {
            Database database=new Database();
            
            
            String query1 ="SELECT milkproduced.*,cow.nickname,employee.first_name, employee.last_name FROM milkproduced,cow,employee"
                    + " where date_added between ? and ? and cow_id=? and quantity between ? and ?"
                    + " and  milkproduced.cow_id=cow.cow_id and employee.emp_id=milkproduced.emp_id";
            
            String query2 ="SELECT milkproduced.*,cow.nickname,employee.first_name, employee.last_name FROM milkproduced,cow,employee"
                    + " where date_added between ? and ? and quantity between ? and ? "
                    + " and  milkproduced.cow_id=cow.cow_id  and employee.emp_id=milkproduced.emp_id";
            
            PreparedStatement statement=database.getPreparedStatement(cowID.equalsIgnoreCase("all")?query2:query1);
            
            statement.setDate(1, from);
            statement.setDate(2, to);
            
            
            
            if(!cowID.equalsIgnoreCase("all")){
               statement.setString(3, cowID);
               statement.setDouble(4, minQuantity);
               statement.setDouble(5, maxQuantity);

            }else{
               statement.setDouble(3, minQuantity);
               statement.setDouble(4, maxQuantity);
            }
            
            
            ResultSet resultSet=database.retrieveInfo(statement);
            
            
            while(resultSet.next()){
                
                
//                production_Id 	emp_id 	quantity 	date_added 	cow_id 	remark 	nickname 	first_name 	last_name 	

                String productionId = resultSet.getString(1);
                String employeeId   = resultSet.getString(2);
                double quantity     = resultSet.getDouble(3);
                Date   dateAdded    = resultSet.getDate(4);
                String cowId        = resultSet.getString(5);
                
                String remarks      = resultSet.getString(6);
                String cowNickName  = resultSet.getString(7);
                
                String firstName    = resultSet.getString(8);
                String lastName     = resultSet.getString(9);

                
                Cow cow= new Cow(cowId,cowNickName);
                Clerk clerk = new Clerk(firstName,lastName);
                
                
                MilkProduced milkProduced= new MilkProduced(clerk,dateAdded, quantity, productionId, remarks,  cow);
                
                report.add(milkProduced);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return report;
    }
    
}
