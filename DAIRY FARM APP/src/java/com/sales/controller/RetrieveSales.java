/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
         Date date_from = Date.valueOf(request.getParameter("date_from")); 
        Date date_to    = Date.valueOf(request.getParameter("date_from"));
        double min_quantity   = Double.parseDouble(request.getParameter("min_quantity"));
        double max_quantity   = Double.parseDouble(request.getParameter("min_quantity"));
        String emp_id         = request.getParameter("emp_id");
        Designation designation = Designation.valueOf(request.getParameter("designation"));
        
        
        SalesReport salesReport=new SalesReport();
        
        
        ArrayList<Sales>  report= salesReport.viewSales(date_from, date_to,  min_quantity,  max_quantity,  emp_id,  designation);
        
       //Session
        HttpSession session=request.getSession();
        
        //remove previous session if it exists
        session.removeAttribute("salesReport");
        
        //add the results to a session
        session.setAttribute("salesReport", report);
        
      //Dispatcher
        
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
