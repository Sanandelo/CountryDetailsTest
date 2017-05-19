package utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.*;

/**
 * Created by radga on 17.05.2017.
 */
public class HttpRequestsHandler {

    public static String invokeWebService(String webServiceURL, String xml, String name) {
        PostMethod post = null;
        HttpClient client = new HttpClient();

        try {
            post = new PostMethod(webServiceURL);
            post.setRequestHeader("Accept", "application/soap+xml,application/dime,multipart/related,text/*");
            post.setRequestHeader("SOAPAction", "\"http://www.webserviceX.NET/" + name + "\"");

            // Request content will be retrieved directly from the input stream
            RequestEntity entity = new StringRequestEntity(xml, "text/xml", "utf-8");
            post.setRequestEntity(entity);

            // Returns a number indicating the status of response
            int result = client.executeMethod(post);
            String response = post.getResponseBodyAsString();
            return response;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Release current connection to the connection pool once you are done
            post.releaseConnection();
        }
    return null;
    }

}
