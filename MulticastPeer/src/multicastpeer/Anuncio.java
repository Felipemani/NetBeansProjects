/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastpeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class Anuncio extends Thread {
   
    private String msgLider;
    private MulticastSocket multicastSocket;
    InetAddress group;
            
    public Anuncio(int lider, MulticastSocket multicastSocket, InetAddress group) {
        this.msgLider = ""+lider;
        this.multicastSocket = multicastSocket;
        this.group = group;
    }
    
    public void run() {
        while (true){
            try{
                
                DatagramPacket messageOut = new DatagramPacket(msgLider.getBytes(), msgLider.getBytes().length, group, 6789);
                multicastSocket.send(messageOut); 
                Thread.sleep(1000);
                System.out.println(messageOut);

            } catch(IOException e){
                //Handle the exception.
            } catch (InterruptedException ex) {
                Logger.getLogger(Peer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
