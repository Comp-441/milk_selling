/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.SalesReport;

import database.Database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import person.employees.Clerk;
import person.employees.designation.Designation;
import production.sales.Sales;

/**
 *
 * @author root
 */
public class SalesReport {
    
    public ArrayList<Sales> viewSales(Date date_from, Date date_to, double min_quantity, double max_quantity, String emp_id, Designation designation) {
      
        //Reference variables
        ArrayList<Sales> list = null;
        Sales sales = null;
        
        try{
            list = new ArrayList<>();
            
            Database database = new Database();
            
            //Query used by clercks
            String sql  = "SELECT * FROM sales where date_sold between ? and ? and quantity_sold between ? and ?";
            
            //Query used by manager           
//              i. All employees
            String sql2 = "SELECT sales.*, employee.first_name, employee.last_name,employee.emp_id  FROM `sales`,employee "
                    + "where date_sold between ? and ? and quantity between ? and ? "
                    + "WHERE sales.emp_id=employee.emp_id ";
            
//              ii. Specific employee
             String sql3 = "SELECT sales.*, employee.first_name, employee.last_name, employee.emp_id FROM `sales`,employee "
                    + "where date_sold between ? and ? and quantity between ? and ? and emp_id=?"
                    + "WHERE sales.emp_id=employee.emp_id ";

            
             
             String query= (designation == Designation.Clerk)?sql:
                           (emp_id.equalsIgnoreCase("all"))?sql2:sql3;
             
            PreparedStatement statement=database.getPreparedStatement(query);
            statement.setDate(1,date_from);
            statement.setDate(2,date_to);
            statement.setDouble(3,min_quantity);
            statement.setDouble(4,max_quantity);

             
             if(designation == Designation.Clerk){    
                 //execute sql query
              
             ResultSet resultSet = database.retrieveInfo(statement);
            //Process the resultset
            while(resultSet.next()){
                sales = new Sales();
                sales.setSaleId(resultSet.getString(1));
                sales.setQuantity(resultSet.getDouble(4));
                sales.setDateProduced(resultSet.getDate(5));
                
                
                //Add sale to the list
                list.add(sales);
            }
         }else{
             if(!emp_id.equalsIgnoreCase("all"))
              statement.setInt(5,Integer.parseInt(emp_id));
             
                
             ResultSet resultSet = database.retrieveInfo(statement);
            //Process the resultset
            while(resultSet.next()){
                sales = new Sales();
                sales.setSaleId(resultSet.getString(1));
                sales.setQuantity(resultSet.getDouble(4));
                sales.setDateProduced(resultSet.getDate(5));
                
                Clerk clerk= new Clerk(resultSet.getString(6), resultSet.getString(7));
                sales.setClerk(clerk);
                
                //Add sale to the list
                list.add(sales);
            }
             
         }
             
         
            
            database.close();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return list;
    }
    
}
