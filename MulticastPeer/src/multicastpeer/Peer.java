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
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class Peer extends Thread {
    private boolean indexador;
    private int inGroup;
    private int numero;
    private MulticastSocket multicastSocket;
    private InetAddress group;
    private byte[] buffer = new byte[1000];

    public Peer(int numero) {
        this.numero = numero;
        this.indexador = false;
        
        MulticastSocket multicastSocket;
        try {
            this.group = InetAddress.getByName("228.5.6.7");
            multicastSocket = new MulticastSocket(6789);
            multicastSocket.joinGroup(group);
            this.multicastSocket = multicastSocket;
            multicastSocket.setSoTimeout(5000);
        }catch (IOException e){}
    }
    
    public void run(){
        eleicao();
        
        if(indexador){
            Anuncio anuncio = new Anuncio(numero, multicastSocket, group);
            anuncio.start();
        }
        
        while(true){
            try {
                
            DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
            multicastSocket.receive(messageIn);
            Object msgIn = Util.deserialize(messageIn.getData());
            
            if(msgIn.getClass().getName() == "PeerMsg"){
                PeerMsg msgPeerMsg = (PeerMsg) msgIn;
            }
            
            
            Thread.sleep(1000);
            
            } catch (IOException ex) {
                System.out.println("run: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Peer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Peer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //multicastSocket.leaveGroup(group);
    }
    
    public void eleicao(){
        try {
            double numeroLider = 0;
            String msg = ""+ numero;
            byte [] m = msg.getBytes();
            
            DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
            multicastSocket.send(messageOut);	
            
            for(int i=0; i< 4;i++) {
                
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(messageIn);
                
                if( numero < new Double(new String(messageIn.getData()))){
                    numeroLider = new Double(new String(messageIn.getData()));
                } else {
                    numeroLider = numero;
                }
            }
            String msgLider = ""+numeroLider;
            
            messageOut = new DatagramPacket(msgLider.getBytes(), msgLider.getBytes().length, group, 6789);
            multicastSocket.send(messageOut);
            
            DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
            multicastSocket.receive(messageIn);
            
            if(new Double(new String(messageIn.getData())) == numero){
                indexador = true;
                System.out.println("Lider "+numero);
            } else {
                indexador = false;
            }		
        }catch (SocketException e){System.out.println("Socket: " + e.getMessage());
        }catch (IOException e){System.out.println("IO: " + e.getMessage());
        }finally {if(multicastSocket != null) multicastSocket.close();}
    }

}

