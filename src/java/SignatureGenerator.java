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
//        request.setCharacterEncoding("Windows-1251");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter pout = response.getWriter()) {
            
            // Установка полученных от пользователя параметров ...
            Sotrudnik aSotrudnik = new Sotrudnik();
            
            /*
            
            http://www.javaportal.ru/java/articles/ruschars/ruschars.html#servlet
            
            Проблема с перекодировкой полученного от пользователя.
            
            //////////////////////////
            О методе перекодировки символов

            Этот метод многие используют неправильно, наверное, не совсем понимая его суть и ограничения.
            Он предназначен для восстановления верных кодов букв, если они были неверно проинтерпретированы.
            Суть метода проста: из полученных неверных символов, используя соответствующую кодовую страницу,
            восстанавливается исходный массив байтов.
            Затем из этого массива байтов, используя уже корректную страницу, получаются нормальные кода символов. Пример:

    String res = new String( src.getBytes("ISO-8859-1"), "Cp1251" );

            Проблем в использовании этого приёма может быть несколько.
            Например, для восстановления используется неверная страница, или же она может измениться в некоторых ситуациях.
            Другая проблема может быть в том, что некоторые страницы выполняют неоднозначное преобразование byte <-> char.
            Смотрите, например, описание ошибки за номером 4296969.

            Поэтому пользоваться этим методом стоит только в самом крайнем случае, когда уже ничто другое не помогает,
            и Вы чётко себе представляете, где именно происходит неверное преобразование символов. 
            //////////////////////////
            
            
            Ииное пока не получилось. предложения выше не помогли. Хотя, может и "не все варианты перепробовал перепробовал"...
            У меня чуть другая "пара". 
            
            Ранее хватало 2-х строк:
            String login  = request.getParameter("login");
            aSotrudnik.setLogin(login);
            
            Может, 2 строки и избыточно, но что-то помешало все "слепить". Хотя, так - нагляднее ... 
            
            Уже "нормально" получается:
            String login  = request.getParameter("login");
            String res = new String( login.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setLogin(res);
            
            Так и просится "метод-перекодировщик, что-бы убрать эту копи-пасту" ...
            */
            
            
            
            // Получаю login
            String login  = request.getParameter("login");
            String res = new String( login.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setLogin(res);
            
             // Получаю 
            String fullName  = request.getParameter("fullName");
            res = new String( fullName.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setFullName(res);
            
             // Получаю posada
            String posada = request.getParameter("posada");
            res = new String( posada.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setPosada(res);
            
             // Получаю city
            String city   = request.getParameter("city");
            res = new String( city.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setCity(res);
            
             // Получаю point
            String point  = request.getParameter("point");
            res = new String( point.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setPoint(res);
            
             // Получаю pfone
            String pfone  = request.getParameter("pfone");
            res = new String( pfone.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setPfone(res);
            
             // Получаю region
            String region = request.getParameter("Region");
            res = new String( region.getBytes("ISO-8859-1"), "UTF-8" );
            aSotrudnik.setRegion(res);
            
            List listProp = new LinkedList();      
        
            listProp = SignaturePropertyGenerator.updateSignatureProperty(listProp, aSotrudnik);

            Iterator iterator = listProp.iterator();
            while(iterator.hasNext()){
                String element = (String) iterator.next();
                pout.println(element);
            }
            
            File file = new File(login + ".html");
            if (file.exists()) {
//               TODO: write add logics
//               TODO: разобраться как работает при наличии файла
//               TODO: Будет очень актуальни на момент "перезаписи подписи и конфига"
                         
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
