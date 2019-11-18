/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee.manager;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import person.employees.Clerk;
import person.employees.Manager;
import person.employees.designation.Designation;

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
     Date   dateProduced = new Date(System.currentTimeMillis());
     String firstName    = request.getParameter("firstName");
     String secondName   = request.getParameter("secondName");
     String dateOfBirth  = request.getParameter("dateOfBirth");
     String empId        = request.getParameter("passWord");
     String phoneNumber  = request.getParameter("phoneNumber");

    
      Designation d       = Designation.Clerk;
     
        //Saving the data        
        Clerk  clerk = new Clerk(Date.valueOf(dateOfBirth), empId, firstName, secondName, phoneNumber);
        clerk.setDesignation(Designation.Clerk);
        
        
        Manager manager=new Manager();
        manager.addClerk(clerk);
       
       
      
      //url
        String url= getServletContext().getRealPath("manager.jsp");
      
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

  
}
