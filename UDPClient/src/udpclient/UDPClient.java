/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

/**
 *
 * @author Thiago
 */
import java.net.*;
import java.io.*;
public class UDPClient{
    public static void main(String args[]){ 
		// args give message contents and destination hostname
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
                        String msg = "ola";
			byte [] m = msg.getBytes();
			InetAddress aHost = InetAddress.getByName("localhost");
			int serverPort = 6789;		                                                 
			DatagramPacket request =
			 	new DatagramPacket(m,  msg.length(), aHost, serverPort);
			aSocket.send(request);			                        
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                        aSocket.setSoTimeout(2000);
			aSocket.receive(reply);
                         
			System.out.println("Reply: " + new String(reply.getData()));
                } catch (SocketTimeoutException e) {System.out.println("Socket timed out!");
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}
