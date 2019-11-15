/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee.clerk;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import person.employees.Clerk;
import production.sales.Sales;

/**
 *
 * @author root
 */
public class MakeSale extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Customer ID
     Date   dateProduced = new Date();
     String customerId   = request.getParameter("customerID");
     String empId        = request.getParameter("empID");
     String productionId = request.getParameter("productioID");
     String saleId       = request.getParameter("saleID");
     String quantity     = request.getParameter("quantity");
     
     
     //Saving the data
        Sales sales= new Sales();
//        Clerk  clerk = new Clerk();
//        clerk.sellMilk(sales);
        
      //dispatcher
      request.setAttribute("sale", sales);
      
      //url
      String url= getServletContext().getRealPath("sales.jsp");
      
      RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
      dispatcher.forward(request, response);
    }

  
}
