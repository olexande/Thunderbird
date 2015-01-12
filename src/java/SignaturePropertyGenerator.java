
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
    public static List updateSignatureProperty(List listProp){
        
        listProp.add("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        listProp.add("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        listProp.add("<head>");
        listProp.add("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        listProp.add("<title>Signature</title>");
        listProp.add("<style type=\"text/css\">");
        listProp.add(".font-blue {\n" + "	color: #00F;\n" + "}");
        listProp.add("</style>");
        listProp.add("</head>");
        listProp.add("element 5");
        
        return listProp;
    }
}
