
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a.belovol
 */
public class ConfigGenerator  extends HttpServlet {
    public static void ConfigGenerator(HttpServletRequest request, HttpServletResponse response) {
                    
        String login = request.getParameter("login");
//        System.out.println("login = " + login);
        

        setUserFile(login);         
                    
                    
                
        }
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConfigGenerator(request, response);
//        String login = request.getParameter("login");
        
    }
    
    public static void setUserFile(String userLogin){
        
        String login = userLogin;
        
////////////////////////////////        
                File file = new File(login + ".cfg");
    //        boolean exists = file.exists();
            if (file.exists()) {
//                System.out.println("true");
            }
            else{
                try {
                    file.createNewFile();
                    FileWriter out = new FileWriter(file);

        //            out.println(login); //debug
                    String mail = "e-mail";
                    String aUserFullName;
                    mail = LdapReader.getUserMail(login);
        //            out.println(mail); //debug
                    aUserFullName = LdapReader.getUserFullName(login);
                    
//                    String login = args; //debug start block
//                    String login = "user";
        //            out.append(login); 
//                    String mail = "e-mail";
//                    String aUserFullName; //debug stop block
                    mail = LdapReader.getUserMail(login);
                    System.out.println(aUserFullName);
        //            out.append(mail);
                    aUserFullName = LdapReader.getUserFullName(login);

                    /// out.append(property); //debug 
                    //out.append("just the text"); 
        //                 out.

                    out.append("try {" + "\r\n");
//                    out.append("\\n");
                    out.append("   if(getenv(\" USER \") != \"\") {" + "\r\n");
                    out.append("           var env_user    = getenv(\"USER\");" + "\r\n");
                    out.append("           var env_home    = getenv(\"HOME\");" + "\r\n");
                    out.append("   } else {" + "\r\n");
                    out.append("           var env_user    = getenv(\"USERNAME\");" + "\r\n");
                    out.append("           var env_home    = getenv(\"HOMEPATH\");" + "\r\n");
                    out.append("   }" + "\r\n");
                    out.append("" + "\r\n");
                                                 
/* FIXME */
                    out.append("   var server_addr    = \"192.168.1.1\";" + "\r\n"); // Fix Server Address
                    out.append("   var point_name     = \"" + aUserFullName + "\";" + "\r\n");

                    out.append("   var full_email     = \"" + mail +"\";" + "\r\n");
                    
/* FIXME */
                    out.append("   var organization   = \"Company Name\";" + "\r\n"); // Fix Company Name
                    out.append("   var prefix_email   = \"" + login + "\";" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.accountmanager.defaultaccount\", \"account1\");" + "\r\n");
                    out.append("   lockPref(\"mail.accountmanager.accounts\", \"account1\");" + "\r\n");
                    out.append("   lockPref(\"mail.account.account1.server\", \"server1\");" + "\r\n");
                    out.append("   lockPref(\"mail.accountmanager.defaultaccount\", \"account1\");" + "\r\n");
                    out.append("   lockPref(\"mail.account.lastKey\", 2); " + "\r\n");
                    out.append("   lockPref(\"mail.attachment.store.version\", 1);" + "\r\n");
                    out.append("   lockPref(\"mail.folder.views.version\", 1);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.rights.version\", 1);" + "\r\n");
                    out.append("   lockPref(\"app.update.enabled\", false);" + "\r\n");
                    out.append("   lockPref(\"extensions.update.enabled\", false);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.type\", \"pop3\");" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.hostname\", server_addr);     " + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.realhostname\", server_addr);  " + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.port\", 110);                       " + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.socketType\", 0);                   " + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.name\", point_name);" + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.userName\", full_email);              " + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.realuserName\", full_email);          " + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.login_at_startup\", true);          " + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.isSecure\", true);                  " + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.check_time\", 5);			  " + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.leave_on_server\", true);" + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.delete_by_age_from_server\", true);" + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.num_days_to_leave_on_server\", 30);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.identity.id1.reply_on_top\", 1);" + "\r\n");
                    out.append("   lockPref(\"mail.identity.id1.sig_bottom\", false);" + "\r\n");
                    out.append("   lockPref(\"mail.identity.id1.sig_on_fwd\", true);" + "\r\n");
                    out.append("" + "\r\n");

/* FIXME */
                    out.append("   defaultPref(\"mail.identity.id1.archive_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Archives\");" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.draft_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Drafts\");" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.fcc_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Sent\");" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.stationery_folder\", \"mailbox://\"+ prefix_email + \"%40company.com.ua@192.168.1.1/Templates\");" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   defaultPref(\"mail.server.server1.spamLevel\", 0);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   defaultPref(\"mail.smtp.defaultserver\", \"smtp1\");" + "\r\n");
                    out.append("   defaultPref(\"mail.smtpserver.smtp1.hostname\", server_addr);" + "\r\n");
                    out.append("   defaultPref(\"mail.smtpserver.realhostname\", server_addr);" + "\r\n");
                    out.append("   defaultPref(\"mail.smtpserver.smtp1.port\", 25);" + "\r\n");
                    out.append("   defaultPref(\"mail.smtpserver.smtp1.description\", organization);" + "\r\n");
                    out.append("   defaultPref(\"mail.smtpserver.smtp1.try_ssl\", 0);" + "\r\n");
                    out.append("   defaultPref(\"mail.smtpserver.smtp1.auth_method\", 0);" + "\r\n");
                    out.append("   defaultPref(\"mail.smtpserver.smtp1.username\", full_email);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.fullName\", point_name);          " + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.useremail\",  full_email);" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.reply_to\", full_email);" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.valid\", true);" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.smtpServer\", \"smtp1\");" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.organization\", organization);" + "\r\n");
                    out.append("   defaultPref(\"mail.identity.id1.tmpl_folder_picker_mode\", \"0\");" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"intl.charsetmenu.mailview.cache\", \"KOI8-R, KOI8-U, UTF-8, windows-1251, ISO-8859-1, ISO-8859-5\");" + "\r\n");
                    out.append("   lockPref(\"mailnews.send_default_charset\", \"KOI8-R\");" + "\r\n");
                    out.append("   lockPref(\"mailnews.view_default_charset\", \"KOI8-R\");" + "\r\n");
                    out.append("   lockPref(\"mailnews.reply_in_default_charset\", true);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   defaultPref(\"mailnews.start_page.enabled\", false);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.account.account1.identities\", \"id1\");" + "\r\n");
                    out.append("" + "\r\n");
                    
/* FIXME */
                    out.append("   defaultPref(\"ldap_2.servers.domain.uri\", \"ldap://company.com.ua/DC=company,DC=com,DC=ua??sub?(mail=*)\");" + "\r\n");

/* FIXME */
                    out.append("   defaultPref(\"ldap_2.servers.domain.auth.dn\", \"company\\\\ldapuser\");" + "\r\n");
                    out.append("   defaultPref(\"ldap_2.servers.domain.auth.saslmech\", \"\");" + "\r\n");
                    out.append("   defaultPref(\"ldap_2.servers.domain.description\", \"company\");" + "\r\n");
                    out.append("   lockPref(\"ldap_2.servers.domain.filename\", \"empl.mab\");" + "\r\n");
                    out.append("   lockPref(\"ldap_2.servers.domain.maxHits\", 300);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"ldap_2.autoComplete.directoryServer\", \"ldap_2.servers.domain\");" + "\r\n");
                    out.append("   lockPref(\"ldap_2.autoComplete.useDirectory\", true);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.identity.id1.sig_file\", \"D:\\\\Podpisi\\\\\"+ env_user + \".html\");" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   defaultPref(\"mail.mdn.report.not_in_to_cc\", 1);" + "\r\n");
                    out.append("   defaultPref(\"mail.mdn.report.other\", 1);" + "\r\n");
                    out.append("   defaultPref(\"mail.mdn.report.outside_domain\", 0);	" + "\r\n");
                    out.append("   defaultPref(\"mail.receipt.request_return_receipt_on\", true);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("   lockPref(\"mail.identity.id1.attach_signature\", true);" + "\r\n");
                    out.append("   lockPref(\"mail.server.server1.download_on_biff\", true);" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("" + "\r\n");
                    out.append("} catch(e) {" + "\r\n");
                    out.append("    displayError(\"lockedPref\", e);" + "\r\n");
                    out.append("  }" + "\r\n");    
                    
                    out.flush();
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ConfigGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (file.exists()) {
//                System.out.println("now is true"); //debug
            }
        
////////////////////////////////        
        
        
        
    }
}

