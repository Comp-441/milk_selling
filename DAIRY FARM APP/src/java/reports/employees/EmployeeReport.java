/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.employees;

import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.employees.Clerk;
import person.employees.Employee;
import production.cow.Cow;
import reports.ProductionReport.CowsReport;

/**
 *
 * @author root
 */
public class EmployeeReport {
    
    
     public ArrayList<Employee> getEmployeesReport(){
        
        ArrayList<Employee> list=new ArrayList<>();
        try {
            
            
            String query="select * from employee";
            
            Database database=new Database();
            
            PreparedStatement statement=database.getPreparedStatement(query);
            
            ResultSet resultSet= database.retrieveInfo(statement);
            
            while (resultSet.next()) {              
              Employee employee=new Clerk(resultSet.getString(2), resultSet.getString(3));
              
              list.add(employee);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(CowsReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return  list;
    }
    
}
