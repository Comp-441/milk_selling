/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee.manager;

import id_reader.TextIO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import person.employees.Employee;
import reports.employees.EmployeeReport;

/**
 *
 * @author root
 */
public class viewEmployees extends HttpServlet {

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
      
        
        EmployeeReport report=new EmployeeReport(); 
            
        ArrayList<Employee> employeeReport= report.getEmployeesReport();
        
        
           //read latest ID
         String path=this.getServletContext().getRealPath("/WEB-INF/IDS/employees_id/id.txt");
         
         String employee_id="EMP/"+TextIO.read_id(path)+"/19";
         
         //creating session and its values
         HttpSession session= request.getSession();
          
         //add report to session
         session.setAttribute("employees", employeeReport);  
         
         //add the latest id to session
         session.setAttribute("employee_id", employee_id);
          
         //url to forward response
         String url="/resources/views/employees/";
          
         //creating dispatcher
         RequestDispatcher dispatcher= getServletContext().getRequestDispatcher(url);
            
         
         //forward request
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
