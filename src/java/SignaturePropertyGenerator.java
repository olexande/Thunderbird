
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olexande
 */
public class SignaturePropertyGenerator {
    public static List updateSignatureProperty(List listProp, Sotrudnik aSotrudnik){
        
        listProp.add("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        listProp.add("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        listProp.add("<head>");
        listProp.add("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        listProp.add("<title>Signature</title>");
        listProp.add("<style type=\"text/css\">");
        listProp.add(".font-blue {\n" + "	color: #00F;\n" + "}");
        listProp.add("</style>");
        listProp.add("</head>");
        
        listProp.add("<body>");
        listProp.add("<p><img src=\"../../../../company-logo.jpg\" alt=\"company-logo\" width=\"60\" height=\"82\" /> <br />");
        listProp.add("  <span class=\"font-blue\"><strong><em>З Повагою,</em></strong> <br />");
        listProp.add("  <strong><em>" + aSotrudnik.getLogin() +"</em></strong>,<br />");
        listProp.add("  <strong><em>" + aSotrudnik.getFullName() +"</em></strong>,<br />");
        listProp.add("  <strong><em>" + aSotrudnik.getPosada() +"</em></strong><br />");
        listProp.add("  <strong><em>м. " + aSotrudnik.getCity() +"<br />");
        listProp.add("    " + aSotrudnik.getPoint() +"<br />");
        listProp.add("    моб. тел. " + aSotrudnik.getPfone() +"</em></strong></span></p>");
        listProp.add("</body>");
        listProp.add("</html>");
        
        return listProp;
    }
}
