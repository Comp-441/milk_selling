/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.controller;

import com.sales.dao.SalesDao;
import com.sales.dao.SalesDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import production.sales.Sales;

/**
 *
 * @author thucheiz
 */
public class SalesController extends HttpServlet {

    SalesDao salesDao = null;
    
    public SalesController(){
        salesDao = new SalesDaoImpl();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //get list of sales by calling dao method
        
       List<Sales> list = salesDao.viewSales();
       
       //Add sale to request object
       request.setAttribute("list", list);
       RequestDispatcher dispatcher = request.getRequestDispatcher("sale-list.jsp");
       
       dispatcher.forward(request, response);
    }


}
