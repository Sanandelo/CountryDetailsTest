package utils;

import org.xembly.Directives;
import org.xembly.ImpossibleModificationException;
import org.xembly.Xembler;

/**
 * Created by radga on 18.05.2017.
 */
public class EnvelopCreator {
    public static String createEnvelopeWithParams(String action, String paramName, String paramValue){
        String body = null;
        try {
            body = new Xembler(
                    new Directives()
                            .add("soap:Envelope")
                            .attr("xmlns:xs", "http://www.w3.org/2001/XMLSchema-instance")
                            .attr("xmlns:xsd", "http://www.w3.org/2001/XMLSchema")
                            .attr("xmlns:soap", "http://schemas.xmlsoap.org/soap/envelope/")
                            .add("soap:Body")
                            .add(action)
                            .attr("xmlns", "http://www.webserviceX.NET")
                            .add(paramName)
                            .set(paramValue)).xml();
        } catch (ImpossibleModificationException e) {
            e.printStackTrace();
        }
        return body;
    }
    public static String createEnvelopeWithoutParams(String action){
        String body = null;
        try {
            body = new Xembler(
                    new Directives()
                            .add("soap:Envelope")
                            .attr("xmlns:xs", "http://www.w3.org/2001/XMLSchema-instance")
                            .attr("xmlns:xsd", "http://www.w3.org/2001/XMLSchema")
                            .attr("xmlns:soap", "http://schemas.xmlsoap.org/soap/envelope/")
                            .add("soap:Body")
                            .add(action)
                            .attr("xmlns", "http://www.webserviceX.NET"))
                            .xml();
        } catch (ImpossibleModificationException e) {
            e.printStackTrace();
        }
        return body;
    }
}
