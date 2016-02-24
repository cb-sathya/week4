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
public class editDetails extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control","no-store");
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("User");
        if(user!=null){
            PrintWriter out = response.getWriter();
            RequestDispatcher reqDis=request.getRequestDispatcher("EditDetails.jsp");
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
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
                out.print("<center>Update successfull</center>");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
