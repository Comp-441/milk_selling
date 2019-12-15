/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cow.addNewCow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id_reader.TextIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import person.employees.Clerk;
import production.cow.Cow;

/**
 *
 * @author root
 */
public class AddCow extends HttpServlet {

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
        
        
        String name = request.getParameter("cow_name");
        String id   = request.getParameter("cow_id");
        
        Cow cow=new Cow(id, name);
        
        HttpSession session= request.getSession();
        
        Clerk clerk=(Clerk) session.getAttribute("clerk");
        
        //redirect url
        String url="/DAIRY FARM APPLICATION/resources/clerck/views/cows/";
        
        
        String path=this.getServletContext().getRealPath("/WEB-INF/IDS/cow_id/id.txt");
        
        
        //check if clerck is null
        
        if(clerk instanceof Clerk)
           clerk.addCow(cow, path);
        else
            url="/DAIRY FARM APPLICATION/";
        
        
//        processing response
        
        
        Gson gson = new GsonBuilder().setPrettyPrinting()
                    .create();
        String json = gson.toJson(new Cow("C-"+TextIO.read_id(path)));
        
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/javascript");
        response.setCharacterEncoding("UTF-8");
        out.print(json); 
        out.flush();
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
