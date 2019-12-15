/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.ProductionReport;

import database.Database;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import production.cow.Cow;

/**
 *
 * @author root
 */
public class CowsReport implements Serializable{

    public CowsReport() {}
    
    
    
    
    public ArrayList<Cow> getCowsReport(){
        
        ArrayList<Cow> list=new ArrayList<>();
        try {

            String query="select * from cow";
            
            Database database=new Database();
            
            PreparedStatement statement=database.getPreparedStatement(query);
            
            ResultSet resultSet= database.retrieveInfo(statement);
            
            while (resultSet.next()) {
              Cow cow=new Cow(resultSet.getString(2).toUpperCase(), resultSet.getString(1).toUpperCase());
              
              list.add(cow);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(CowsReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return  list;
    }
    
}
