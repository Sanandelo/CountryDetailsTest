package utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by radga on 18.05.2017.
 */
public class XmlToJavaConveror {
    public static String extractBody(String string){
        Pattern p = Pattern.compile("&lt;NewDataSet&gt;((.*?))&lt;/NewDataSet&gt;",Pattern.DOTALL);
        Matcher m = p.matcher(string);
        String xml=new String();
        while (m.find()) {
            xml = m.group(0).trim().replaceAll("&lt;","<").replaceAll("&gt;",">");
        }
        return xml;
    }
    public static Object convert(String string, Class cl) throws JAXBException {
        StringReader reader = new StringReader(string);
        Object object = null;

            JAXBContext jaxbContext = JAXBContext.newInstance(cl);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = (Object) jaxbUnmarshaller.unmarshal(reader);

        return object;
    }
}
