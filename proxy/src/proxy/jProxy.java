
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.io.InputStream;
import java.net.*;

public class jProxy {

    public static void main (String args[]) throws Exception
    {

        URL url = new URL("https://docs.oracle.com/javase/7/docs/api/java/net/HttpURLConnection.html");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        String code = connection.getRequestMethod();
        //code.toString();
        System.out.println("Response code of the object is "+ code);

    }
}

