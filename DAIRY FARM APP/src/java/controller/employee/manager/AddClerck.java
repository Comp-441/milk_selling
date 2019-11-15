/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import person.employees.Clerk;
import person.employees.designation.Designation;
import production.sales.Sales;

/**
 *
 * @author root
 */
public class AddClerck extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Customer ID
     Date   dateProduced = new Date();
     String firstName    = request.getParameter("firstName");
     String secondName   = request.getParameter("secondName");
     String dateOfBirth  = request.getParameter("dateOfBirth");
     String empId        = request.getParameter("empId");
    
     Designation d       = Designation.Clerk;
     
     //Saving the data
        Sales sales= new Sales();
        Clerk  clerk = new Clerk();
        clerk.sellMilk(sales);
        
      //dispatcher
      request.setAttribute("sale", sales);
      
      //url
        String url= getServletContext().getRealPath("manager.jsp");
      
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

  
}
