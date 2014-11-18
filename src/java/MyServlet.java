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
import java.util.Properties;

/**
 *
 * @author a.belovol
 */
public class MyServlet extends HttpServlet {

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
            String login = request.getParameter("login");
            
//            out.println(login); 
            String mail = "e-mail";
            String aUserFullName;
            mail = LdapReader.getUserMail(login);
//            out.println(mail);
            aUserFullName = LdapReader.getUserFullName(login);
            
           /// out.println(property);
                 //out.println("just the text"); 
                 out.println("try {");
                 out.println("   if(getenv(\" USER \") != \"\") {"); 
                 out.println("           var env_user    = getenv(\"USER\");"); 
                 out.println("           var env_home    = getenv(\"HOME\");"); 
                 out.println("   } else {"); 
                 out.println("           var env_user    = getenv(\"USERNAME\");"); 
                 out.println("           var env_home    = getenv(\"HOMEPATH\");"); 
                 out.println("   }"); 
                 out.println(""); 
                 out.println("   var server_addr    = \"192.168.1.1\";"); 
                 out.println("   var point_name     = \"" + aUserFullName + "\";");
                 
                 out.println("   var full_email     = \"" + mail +"\";"); 
                 out.println("   var organization   = \"Company Ukraine\";"); 
                 out.println("   var prefix_email   = " + login + "\";"); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.accountmanager.defaultaccount\", \"account1\");"); 
                 out.println("   lockPref(\"mail.accountmanager.accounts\", \"account1\");"); 
                 out.println("   lockPref(\"mail.account.account1.server\", \"server1\");"); 
                 out.println("   lockPref(\"mail.accountmanager.defaultaccount\", \"account1\");"); 
                 out.println("   lockPref(\"mail.account.lastKey\", 2); "); 
                 out.println("   lockPref(\"mail.attachment.store.version\", 1);"); 
                 out.println("   lockPref(\"mail.folder.views.version\", 1);"); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.rights.version\", 1);"); 
                 out.println("   lockPref(\"app.update.enabled\", false);"); 
                 out.println("   lockPref(\"extensions.update.enabled\", false);"); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.server.server1.type\", \"pop3\");"); 
                 out.println(""); 
                 out.println("   defaultPref(\"mail.server.server1.hostname\", server_addr);     "); 
                 out.println("   defaultPref(\"mail.server.server1.realhostname\", server_addr);  "); 
                 out.println("   defaultPref(\"mail.server.server1.port\", 110);                       "); 
                 out.println("   defaultPref(\"mail.server.server1.socketType\", 0);                   "); 
                 out.println("   defaultPref(\"mail.server.server1.name\", point_name);"); 
                 out.println("   defaultPref(\"mail.server.server1.userName\", full_email);              "); 
                 out.println("   defaultPref(\"mail.server.server1.realuserName\", full_email);          "); 
                 out.println("   lockPref(\"mail.server.server1.login_at_startup\", true);          "); 
                 out.println("   lockPref(\"mail.server.server1.isSecure\", true);                  "); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.server.server1.check_time\", 5);			  "); 
                 out.println("   lockPref(\"mail.server.server1.leave_on_server\", true);"); 
                 out.println("   lockPref(\"mail.server.server1.delete_by_age_from_server\", true);"); 
                 out.println("   lockPref(\"mail.server.server1.num_days_to_leave_on_server\", 30);"); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.identity.id1.reply_on_top\", 1);"); 
                 out.println("   lockPref(\"mail.identity.id1.sig_bottom\", false);"); 
                 out.println("   lockPref(\"mail.identity.id1.sig_on_fwd\", true);"); 
                 out.println(""); 
                 out.println("   defaultPref(\"mail.identity.id1.archive_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Archives\");"); 
                 out.println("   defaultPref(\"mail.identity.id1.draft_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Drafts\");"); 
                 out.println("   defaultPref(\"mail.identity.id1.fcc_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Sent\");"); 
                 out.println("   defaultPref(\"mail.identity.id1.stationery_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Templates\");"); 
                 out.println(""); 
                 out.println("   defaultPref(\"mail.server.server1.spamLevel\", 0);"); 
                 out.println(""); 
                 out.println("   defaultPref(\"mail.smtp.defaultserver\", \"smtp1\");"); 
                 out.println("   defaultPref(\"mail.smtpserver.smtp1.hostname\", server_addr);"); 
                 out.println("   defaultPref(\"mail.smtpserver.realhostname\", server_addr);"); 
                 out.println("   defaultPref(\"mail.smtpserver.smtp1.port\", 25);"); 
                 out.println("   defaultPref(\"mail.smtpserver.smtp1.description\", organization);"); 
                 out.println("   defaultPref(\"mail.smtpserver.smtp1.try_ssl\", 0);"); 
                 out.println("   defaultPref(\"mail.smtpserver.smtp1.auth_method\", 0);"); 
                 out.println("   defaultPref(\"mail.smtpserver.smtp1.username\", full_email);"); 
                 out.println(""); 
                 out.println("   defaultPref(\"mail.identity.id1.fullName\", point_name);          "); 
                 out.println("   defaultPref(\"mail.identity.id1.useremail\",  full_email);"); 
                 out.println("   defaultPref(\"mail.identity.id1.reply_to\", full_email);"); 
                 out.println("   defaultPref(\"mail.identity.id1.valid\", true);"); 
                 out.println("   defaultPref(\"mail.identity.id1.smtpServer\", \"smtp1\");"); 
                 out.println("   defaultPref(\"mail.identity.id1.organization\", organization);"); 
                 out.println("   defaultPref(\"mail.identity.id1.tmpl_folder_picker_mode\", \"0\");"); 
                 out.println(""); 
                 out.println("   lockPref(\"intl.charsetmenu.mailview.cache\", \"KOI8-R, KOI8-U, UTF-8, windows-1251, ISO-8859-1, ISO-8859-5\");"); 
                 out.println("   lockPref(\"mailnews.send_default_charset\", \"KOI8-R\");"); 
                 out.println("   lockPref(\"mailnews.view_default_charset\", \"KOI8-R\");"); 
                 out.println("   lockPref(\"mailnews.reply_in_default_charset\", true);"); 
                 out.println(""); 
                 out.println("   defaultPref(\"mailnews.start_page.enabled\", false);"); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.account.account1.identities\", \"id1\");"); 
                 out.println(""); 
                 out.println("   defaultPref(\"ldap_2.servers.domain.uri\", \"ldap://company.ua/DC=Company,DC=com,DC=ua??sub?(mail=*)\");"); 
                 out.println("   defaultPref(\"ldap_2.servers.domain.auth.dn\", \"company\\ldapuser\");"); 
                 out.println("   defaultPref(\"ldap_2.servers.domain.auth.saslmech\", \"\");"); 
                 out.println("   defaultPref(\"ldap_2.servers.domain.description\", \"Company\");"); 
                 out.println("   lockPref(\"ldap_2.servers.domain.filename\", \"empl.mab\");"); 
                 out.println("   lockPref(\"ldap_2.servers.domain.maxHits\", 300);"); 
                 out.println(""); 
                 out.println("   lockPref(\"ldap_2.autoComplete.directoryServer\", \"ldap_2.servers.domain\");"); 
                 out.println("   lockPref(\"ldap_2.autoComplete.useDirectory\", true);"); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.identity.id1.sig_file\", \"D:\\Podpisi\\\"+ env_user + \".html\");"); 
                 out.println(""); 
                 out.println("   defaultPref(\"mail.mdn.report.not_in_to_cc\", 1);"); 
                 out.println("   defaultPref(\"mail.mdn.report.other\", 1);"); 
                 out.println("   defaultPref(\"mail.mdn.report.outside_domain\", 0);	"); 
                 out.println("   defaultPref(\"mail.receipt.request_return_receipt_on\", true);"); 
                 out.println(""); 
                 out.println("   lockPref(\"mail.identity.id1.attach_signature\", true);"); 
                 out.println(""); 
                 out.println(""); 
                 out.println("} catch(e) {"); 
                 out.println("    displayError(\"lockedPref\", e);"); 
                 out.println("  }");  

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
