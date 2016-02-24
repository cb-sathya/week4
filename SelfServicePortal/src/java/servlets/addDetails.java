/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Data.dataBase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-sathyanarayanan
 */
public class addDetails extends HttpServlet {

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
        response.setHeader("Cache-Control","no-store");
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("User");
        if(user!=null){
            PrintWriter out = response.getWriter();
            RequestDispatcher reqDis=request.getRequestDispatcher("Details.jsp");
            String firstName=user.getFirstName();
            String lastName=user.getLastName();
            String email;
            String addressLine1=request.getParameter("addressLine1");
            String addressLine2=request.getParameter("addressLine2");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            String ZIP=request.getParameter("ZIP");
            String country=request.getParameter("country");
            try{
                email=user.getEmail();
                user.setUser(firstName,lastName,addressLine1,addressLine2,city,state,ZIP,country);
                dataBase.updateUser(firstName,lastName,email,addressLine1,addressLine2,city,state,ZIP,country);
                reqDis.include(request, response);
                out.print("<center>Address added successfully</center>");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            request.setAttribute("Error" , "Session has ended. Please login again");
            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
            rd.include(request,response);
        }
    }
}