/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import person.employees.designation.Designation;
import production.sales.Sales;
import reports.SalesReport.SalesReport;

/**
 *
 * @author root
 */
public class RetrieveSales extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
       //Get parameters for the report
        String date=(String)request.getParameter("min_date");
                
        

        Date date_from      = (date != null) ? Date.valueOf((String)request.getParameter("min_date")) : Date.valueOf("2010-10-1");
        Date date_to        = (date != null) ? Date.valueOf((String)request.getParameter("max_date")) : new Date(System.currentTimeMillis()); 
        
        
        double min_quantity = (date != null) ? Double.parseDouble(request.getParameter("min_quantity")) : 0.00 ; 
        double max_quantity = (date != null) ? Double.parseDouble(request.getParameter("max_quantity")) : 1000.00 ; 

        String emp_id           = (date != null) ? request.getParameter("emp_id") : "all"  ;
        Designation designation = (date != null) ? Designation.valueOf(request.getParameter("designation")) : Designation.Clerk;
        
        
        
        //generate report
        SalesReport salesReport=new SalesReport();       
        
        ArrayList<Sales>  report= salesReport.viewSales(date_from, date_to,  min_quantity,  max_quantity,  emp_id,  designation);
        
        System.out.println("elements:\t"+report.size());
        
        //Session
        HttpSession session=request.getSession();
        
        //remove previous session if it exists
        session.removeAttribute("salesReport");
        
        //add the results to a session
        session.setAttribute("salesReport", report);
        
        
        //Dispatcher
        String url="/resources/views/sales/";
          
          
        RequestDispatcher dispatcher= getServletContext().getRequestDispatcher(url);
            
        
        //dispatch request
        dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
