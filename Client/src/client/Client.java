/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Random;


/**
 *
 * @author Thiago
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        
        Date TR = new Date();
        TR.setMinutes(60);
        Random rn = new Random();
        rn.nextInt(999);
        String senha = Hash.hash("senha");
        
        String M1 = "cliente 1;" + "servico 1;" + TR.getMinutes() + ";" + rn.nextInt(999) + ";" + senha;

        sentence = inFromUser.readLine();
        System.out.println("das"+CriptDES.encript(M1.getBytes()));
        outToServer.writeBytes(CriptDES.encript(M1.getBytes()) + '\n');
        
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
    
}
