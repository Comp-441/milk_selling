/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee.clerk;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import person.employees.Clerk;
import production.produce.MilkProduced;
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
     Date   dateSold = new Date(System.currentTimeMillis());
//     String empId        = request.getParameter("emp_id");
     String productionId = request.getParameter("production_Id");
//     String saleId       = request.getParameter("sale_Id");
     double quantity     = Double.parseDouble(request.getParameter("quantity_sold"));
     
     MilkProduced produced=new MilkProduced(productionId);
     
     //Saving the data
        Sales sales= new Sales(dateSold, produced,"S-1", quantity);
        Clerk  clerk = new Clerk(3);
        clerk.sellMilk(sales);
        
      //dispatcher      
      //url
      String url="/resources/clerck/";
      
      RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
      dispatcher.forward(request, response);
    }

  
}
