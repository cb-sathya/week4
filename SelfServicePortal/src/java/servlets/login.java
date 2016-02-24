/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Data.dataBase;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author cb-sathyanarayanan
 */
public class login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        User user=null;
        int indx = email.indexOf("@");
        try{
            RequestDispatcher reqDis=request.getRequestDispatcher("Login.jsp");
            if(email.equals("") || password.equals("") || email==null || password==null){ 
                request.setAttribute("errormsg","Empty field(s)");
                reqDis.forward(request, response);
            }
            else if(indx==-1){
                request.setAttribute("errormsg","Invalid Email");
                reqDis.forward(request, response);
            }
            else{
                user=dataBase.checkUser(email,password);
                if(user!=null){
                    HttpSession session=request.getSession();
                    session.setAttribute("User",user);
                    response.sendRedirect("Details.jsp");
                }
                else{
                    request.setAttribute("errormsg","invalid username or password");
                    reqDis.forward(request, response);
                }
            }
           
        }catch(Exception e){
            e.printStackTrace();
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
