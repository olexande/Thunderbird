/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author a.belovol
 */
public class SignatureGenerator extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Sotrudnik aSotrudnik = new Sotrudnik();
            
            String login  = request.getParameter("login");
//            aSotrudnik.setLogin(login);
            String posada = request.getParameter("posada");
            String city   = request.getParameter("city");
            String point  = request.getParameter("point");
            String pfone  = request.getParameter("pfone");
            String region = request.getParameter("Region");
//            String login = request.getParameter("point");
            

            
            String body1 = ("<body>");
            String body2 = ("<p><img src=\"../../../../company-logo.jpg\" alt=\"company-logo\" width=\"60\" height=\"82\" /> <br />");
            String body3 = ("  <span class=\"font-blue\"><strong><em>З Повагою,</em></strong> <br />");
            String body4 = ("  <strong><em>" + login +"</em></strong>,<br />");
            String body5 = ("  <strong><em>" + posada +"</em></strong><br />");
            String body6 = ("  <strong><em>м. " + city +"<br />");
            String body7 = ("    " + point +"<br />");
            String body8 = ("    моб. тел. " + pfone +"</em></strong></span></p>");
            String body9 = ("</body>");
            String body10 = ("</html>");
            
            List listProp = new LinkedList();      
        
            listProp = SignaturePropertyGenerator.updateSignatureProperty(listProp);

            Iterator iterator = listProp.iterator();
            while(iterator.hasNext()){
                String element = (String) iterator.next();
                out.println(element);
            }
            
            out.println(body1);
            out.println(body2);
            out.println(body3);
            out.println(body4);
            out.println(body5);
            out.println(body6);
            out.println(body7);
            out.println(body8);
            out.println(body9);
            out.println(body10);
            
            out.println("Debug:");
            out.println("<br/>");
            out.println("Skript planiruetsia pologity v ... ");
            out.println(region);
            out.println("<br/>");

            
           /// out.println(property);
                 //out.println("just the text"); 
//                 out.println("try " + login);
                  
//                 out.println("  ");  
            
            
            
            
            
            

        } finally {
            out.close();
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
//        String login = request.getParameter("login");
        
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
