/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as;

import java.io.*;
import java.net.*;

/**
 *
 * @author Thiago
 */
public class AS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
             new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println(clientSentence);
            System.out.println("das"+CriptDES.decript(clientSentence));
            System.out.println("das string"+new String(CriptDES.decript(clientSentence)));
            //System.out.println("Received: " + clientSentence);
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
        }
        
    }
    
}
