/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Data.User;
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
public class addContacts extends HttpServlet {

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
        User user= (User) session.getAttribute("user");
        if(user!=null){
            PrintWriter out = response.getWriter();
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String contactId=request.getParameter("contactId");
            String addressLine1=request.getParameter("addressLine1");
            String addressLine2=request.getParameter("addressLine2");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            String ZIP=request.getParameter("ZIP");
            String country=request.getParameter("country");
            String home=request.getParameter("Home");
            String work=request.getParameter("Work");
            String mobile=request.getParameter("Mobile");
            try{
                dataBase.updateContact(firstName,lastName,contactId,addressLine1,addressLine2,city,state,ZIP,country,home,work,mobile);
                response.sendRedirect("Directory");
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
