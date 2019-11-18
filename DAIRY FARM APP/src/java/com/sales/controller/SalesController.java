/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import person.employees.Clerk;

/**
 *
 * @author thucheiz
 */
public class SalesController extends HttpServlet {

//    SalesDao salesDao = null;
//    
//    public SalesController(){
//        salesDao = new SalesDaoImpl();
//    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
////        get user parameters
//        String date_from= request.getParameter("date_from");
//        String date_from= request.getParameter("date_from");
//        String date_from= request.getParameter("date_from");
//        String date_from= request.getParameter("date_from");
//
//       
//        //get list of sales by calling dao method
//        
//        
////       List<Sales> list = salesDao.viewSales();
////        Clerk clerk=new Clerk();
//        
//       
//       
//       
//       //Add sale to request object
//       request.setAttribute("list", clerk.viewSalesReport(Date.valueOf(date_from)));
//       RequestDispatcher dispatcher = request.getRequestDispatcher("sale-list.jsp");
//       
//       dispatcher.forward(request, response);
    }


}
