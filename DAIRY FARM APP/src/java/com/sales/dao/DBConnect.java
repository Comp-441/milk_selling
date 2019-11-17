/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author thucheiz
 */
public class DBConnect {
    	
// Define database properties
	
	private static final String URL = "jdbc:mysql://localhost:3306/dairy_farm";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static Connection connection = null; //Reference variable to hold the connection object

    public static Connection openConnection(){
    	//Check connection
    	
    	if(connection != null){
    		return connection;
    	}else{
    		try{
        		//Load the driver
        		Class.forName(DRIVER);
        		
        		//Get the connection
        		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        		
    			
    		}catch(Exception e){
    			e.printStackTrace();
    		}

    		return connection;
    	}
    }
}
