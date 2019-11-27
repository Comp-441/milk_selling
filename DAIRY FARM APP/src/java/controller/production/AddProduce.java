/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.production;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import person.employees.Clerk;
import production.cow.Cow;
import production.produce.MilkProduced;

/**
 *
 * @author root
 */
public class AddProduce extends HttpServlet {


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
         doPost(request, response);
      
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
        
    Date dateAdded =new Date(System.currentTimeMillis());
//    int   empId         = Integer.parseInt(request.getParameter("Emp_ID"));
    
    
    double quantity     = Double.parseDouble(request.getParameter("quantity"));
//    String productionId = request.getParameter("productionID");
    
    
    String remarks      = request.getParameter("remarks");    
    String cowID        = request.getParameter("cow_id");
    
    Cow cow= new Cow(cowID);
    
    
    //Session data
    HttpSession session=request.getSession();
    
    Clerk clerk=(Clerk)session.getAttribute("clerk");
    
    
    MilkProduced milkProduced=new MilkProduced(clerk, dateAdded, quantity, "P-4", remarks, cow);
    
    
       //redirect url
        String url="/DAIRY FARM APPLICATION/resources/clerck/views/produce/";
        
        //check if clerck is null
        
        if(clerk instanceof Clerk)
           clerk.addMilkProduced(milkProduced);
        else
            url="/DAIRY FARM APPLICATION/";
        
        //include request dispatcher
        response.sendRedirect(url);
       
    }

}
