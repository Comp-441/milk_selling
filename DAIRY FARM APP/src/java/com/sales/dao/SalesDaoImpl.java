/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.dao;

import java.sql.Connection;
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

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    @Override
    public List<Sales> viewSales() {
      
        //Reference variables
        List<Sales> list = null;
        Sales sales = null;
        
        try{
            list = new ArrayList<Sales>();
            
            String sql = "SELECT * FROM sales";
            
            //get database connection
            connection = DBConnect.openConnection();
            
            statement = connection.createStatement();
            
            //execute sql query
            resultSet = statement.executeQuery(sql);
            
            //Process the resultset
            while(resultSet.next()){
                sales = new Sales();
                sales.setSaleId(resultSet.getString("salesId"));
                sales.setQuantity(resultSet.getDouble("quantity"));
                sales.setDateProduced(resultSet.getDate("dateProduced"));
                
                
                //Add sale to the list
                list.add(sales);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return list;
    }
    
}
