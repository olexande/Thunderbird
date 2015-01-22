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
import java.io.FileWriter;
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
        try (PrintWriter pout = response.getWriter()) {
            
            // Установка полученных от пользователя параметров ...
            Sotrudnik aSotrudnik = new Sotrudnik();
            
            String login  = request.getParameter("login");
            aSotrudnik.setLogin(login);
            String fullName  = request.getParameter("fullName");
            aSotrudnik.setFullName(fullName);
            String posada = request.getParameter("posada");
            aSotrudnik.setPosada(posada);
            String city   = request.getParameter("city");
            aSotrudnik.setCity(city);
            String point  = request.getParameter("point");
            aSotrudnik.setPoint(point);
            String pfone  = request.getParameter("pfone");
            aSotrudnik.setPfone(pfone);
            String region = request.getParameter("Region");
            aSotrudnik.setRegion(region);
            
            List listProp = new LinkedList();      
        
            listProp = SignaturePropertyGenerator.updateSignatureProperty(listProp, aSotrudnik);

            Iterator iterator = listProp.iterator();
            while(iterator.hasNext()){
                String element = (String) iterator.next();
                pout.println(element);
            }
            
            File file = new File(login + ".html");
            if (file.exists()) {
//                out.println("file is true");
            }
            else{
                file.createNewFile();
                FileWriter fout = new FileWriter(file);
                Iterator iterator2 = listProp.iterator();
                while(iterator2.hasNext()){
                    String element = (String) iterator2.next();
                    fout.append(element);
                }
                fout.flush();
                fout.close();
            }
                    
//            out.println("Debug:");
//            out.println("<br/>");
//            out.println("Skript planiruetsia pologity v ... ");
//            out.println(region);
//            out.println("<br/>");

            
           /// out.println(property);
                 //out.println("just the text"); 
//                 out.println("try " + login);
                  
//                 out.println("  ");  

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
