/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginController;

import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import person.employees.Clerk;
import person.employees.Manager;

/**
 *
 * @author root
 */
public class Login extends HttpServlet {

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
       
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String category = request.getParameter("category");
            
            
            
            
            
            int id= Integer.parseInt(username.substring(2));
            
            
            //Set the url to dispatch to
            
            
            String url=(category.equalsIgnoreCase("Clerk"))?"/resources/clerck/":"/resources/manager/";
            
            
            //Process login
            Database database=new Database();
            
            //Query
            String query= "SELECT * from employee where emp_id=? and password=? and designation=?";
            
            PreparedStatement statement=database.getPreparedStatement(query);
            
            //give prepared statements parameters
            statement.setInt(1, id);
            statement.setString(2, password);
            statement.setString(3, category);
           
            ResultSet resultSet= database.retrieveInfo(statement);
            
            if(resultSet.next()){
              //Create Session for looged in user
                HttpSession session= request.getSession();
                
                //create either ckerk or Manager
                if(category.equalsIgnoreCase("clerk")){
                  Clerk clerk=new Clerk(resultSet.getString(2), resultSet.getString(3));
                  clerk.setEmpId(resultSet.getInt(1));
                  
                  session.removeAttribute("clerk");

                  session.setAttribute("clerk", clerk);
                  
                    System.out.println(session.getAttribute("clerk"));
                }else{
                   Manager manager= new Manager(resultSet.getString(2), resultSet.getString(3));
                   
                  manager.setEmpId(resultSet.getInt(1));
                  
                  session.removeAttribute("manager");
                  session.setAttribute("manager", manager);
                }
                               
                
                
                 //dispatcher
                
                RequestDispatcher dispatcher= getServletContext().getRequestDispatcher(url);
                
                //dispatch request
                dispatcher.forward(request, response);
                
              
            }else{
                //dispatcher
                
                url= "/index.jsp";
                
                RequestDispatcher dispatcher= getServletContext().getRequestDispatcher(url);
                
                //dispatch request
                dispatcher.forward(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
