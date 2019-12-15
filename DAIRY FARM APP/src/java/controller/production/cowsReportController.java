/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.production;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id_reader.TextIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import production.cow.Cow;
import reports.ProductionReport.CowsReport;

/**
 *
 * @author root
 */
public class cowsReportController extends HttpServlet {

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
       
        
        //generate report
         CowsReport report=new CowsReport();
                
         ArrayList<Cow> list=report.getCowsReport();
         
         
         //read latest ID
         String path=this.getServletContext().getRealPath("/WEB-INF/IDS/cow_id/id.txt");
         
         String cow_id="C-"+TextIO.read_id(path);
         
         //creating session and its values
         HttpSession session= request.getSession();
          
         //add report to session
         session.setAttribute("cowsReport", list);  
         
         //add the latest id to session
         session.setAttribute("cow_id", cow_id);
         
         
         if(((String)request.getParameter("redirect")).equalsIgnoreCase("yes")){
          
         //url to forward response
         String url="/resources/views/cows/";
          
         //creating dispatcher
         RequestDispatcher dispatcher= getServletContext().getRequestDispatcher(url);
            
         
         //forward request
         dispatcher.forward(request, response);

         }else{
             
         ArrayList results= new ArrayList();
         results.add(list);
         results.add(new Cow(cow_id));
         
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         String json=gson.toJson(results);
          
          
          PrintWriter out = response.getWriter();
          response.setContentType("text/javascript");
          response.setCharacterEncoding("UTF-8");
          out.print(json); 
          out.flush();
         
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
