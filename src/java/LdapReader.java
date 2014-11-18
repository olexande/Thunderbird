//package ldap_reader;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
 * User: gmc
 * Date: 16/02/11
 * http://code.google.com/p/java-use-examples/source/browse/trunk/src/com/aw/ad/LdapBasicExample.java?r=2
 */
public class LdapReader {

        private static String userName = "ldapuser";
        private static String userLogin = "company" + "\\" + userName;
        private static String userPasswd = "ldappassword";
        private static String user;
        private static String requestAnswer;
    
    public static String LdapReader(String request) {
//        System.out.println("request = " + request);
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://company.com.ua/DC=company,DC=com,DC=ua");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userLogin);
        env.put(Context.SECURITY_CREDENTIALS, userPasswd);
        env.put(Context.REFERRAL, "follow");
        env.put("com.sun.jndi.ldap.read.timeout", "500");

        DirContext ctx = null;
        NamingEnumeration results = null;
        try {
            ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            controls.getCountLimit();
            
            String filter = "(sAMAccountName=" + request + ")";
            
            String base="";
	
            results = ctx.search(base, filter, controls);
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("cn");
                String cn = (String) attr.get();
//                System.out.println(" Person Common Name = " + attributes.get("cn"));
//                System.out.println(" Person e-mail = " + attributes.get("mail"));
//                System.out.println(" userPrincipalName = " + attributes.get("userPrincipalName"));
                
                Attribute usersMail = attributes.get("mail");
                requestAnswer = usersMail.toString();
//                System.out.println(attributes.get("mail"));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                }
            }
            //
            
        }
        return requestAnswer;
    }
    
    //TODO Переписать на универсальный запрос, что-бы принимало логин + поле и получало ответ
    public static String LdapUserReader(String loginRequest) {
//        System.out.println("request = " + request);
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://company.com.ua/DC=company,DC=com,DC=ua");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, userLogin);
        env.put(Context.SECURITY_CREDENTIALS, userPasswd);
        env.put(Context.REFERRAL, "follow");
        env.put("com.sun.jndi.ldap.read.timeout", "500");

        DirContext ctx = null;
        NamingEnumeration results = null;
        try {
            ctx = new InitialDirContext(env);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            controls.getCountLimit();
            
            String filter = "(sAMAccountName=" + loginRequest + ")";
            
            String base="";
	
            results = ctx.search(base, filter, controls);
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("cn");
                String cn = (String) attr.get();
//                System.out.println(" Person Common Name = " + attributes.get("cn"));
//                System.out.println(" Person e-mail = " + attributes.get("mail"));
//                System.out.println(" userPrincipalName = " + attributes.get("userPrincipalName"));
                
                Attribute usersMail = attributes.get("displayName");
                requestAnswer = usersMail.toString();
//                System.out.println(attributes.get("mail"));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                }
            }
            //
            
        }
        return requestAnswer;
    }
    
    public static String getUserMail(String user){
  //      /*
        String answer;
        answer = LdapReader(user);
//        System.out.println(answer);
        
        //answer по какой-то причине получается от сервера с префиксом "mail: ". 
        // -- Убираем левый префикс
        String temp_answer = "" ;
        for (String s: answer.split(" ")) {
//          System.out.println(s);
          temp_answer = s;
        }
        // == Убираем
        
        answer = temp_answer;
        // */
        /*answer = "pupkin@company.com.ua";*/
        return answer;
    }
    
    public static String getUserFullName(String user){
        String answer;
        answer = LdapUserReader(user);
//        System.out.println(answer);
        
        //answer по какой-то причине получается от сервера с префиксом "mail: ".  //debug
        // -- Убираем левый префикс
////////        String temp_answer = "" ;
////////        for (String s: answer.split(" ")) {
//////////          System.out.println(s);
////////          temp_answer = s;
////////        }
        // == Убираем                                                               // debug
        System.out.println(answer);
////////        answer = temp_answer;
        return answer;
    }
}


