/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.SalesReport;

import com.sales.dao.DBConnect;
import database.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import production.sales.Sales;

/**
 *
 * @author thucheiz
 */
public class SalesDaoImpl implements SalesDao{

//    Connection connection = null;
//    Statement statement = null;
//    ResultSet resultSet = null;
    
    
    @Override
    public List<Sales> viewSales(Date date_from) {
      
        //Reference variables
        List<Sales> list = null;
        Sales sales = null;
        
        try{
            list = new ArrayList<Sales>();
            
            String sql = "SELECT * FROM sales where date_sold between ? and ? and quantity between ? and ?";
            
//            //get database connection
//            connection = DBConnect.openConnection();
//            
//            statement = connection.createStatement();
            
            Database database = new Database();
            
            PreparedStatement statement=database.getPreparedStatement(sql);
            
            statement.setDate(1,date_from);
            
//            
            //execute sql query
          ResultSet resultSet = database.retrieveInfo(statement);
            
            //Process the resultset
            while(resultSet.next()){
                sales = new Sales();
                sales.setSaleId(resultSet.getString("salesId"));
                sales.setQuantity(resultSet.getDouble("quantity"));
                sales.setDateProduced(resultSet.getDate("date_sold"));
                
                
                //Add sale to the list
                list.add(sales);
            }
            
            database.close();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return list;
    }
    
}
