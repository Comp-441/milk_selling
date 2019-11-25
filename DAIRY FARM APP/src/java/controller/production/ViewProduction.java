/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.production;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import production.produce.MilkProduced;
import reports.ProductionReport.ProductionReport;

/**
 *
 * @author root
 */
public class ViewProduction extends HttpServlet {

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

        Date from= Date.valueOf(request.getParameter("min_date"));
        Date to  = Date.valueOf(request.getParameter("max_date"));
        
        String cowID= request.getParameter("cowID");
        
        double minQuantity = Double.parseDouble(request.getParameter("minQuantity"));
        double maxQuantity = Double.parseDouble(request.getParameter("maxQuantity"));
        
       
        ArrayList<MilkProduced>  productionReport= new ProductionReport().productionReport(from, to, cowID, minQuantity, maxQuantity);
        
        

        //Session
        //Session
        HttpSession session=request.getSession();
        
        //remove previous session if it exists
        session.removeAttribute("salesReport");
        
        //add the results to a session
        session.setAttribute("productionReport", productionReport);   
        
        
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
