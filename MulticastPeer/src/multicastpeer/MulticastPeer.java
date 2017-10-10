/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastpeer;

/**
 *
 * @author Thiago
 */
public class MulticastPeer{
    public static void main(String args[]){ 
            Peer peer = new Peer((int) ((Math.random() * (100 - 1))));
            peer.start();
            
            Peer peer2 = new Peer((int) ((Math.random() * (100 - 1))));
            peer2.start();
            
            Peer peer3 = new Peer((int) ((Math.random() * (100 - 1))));
            peer3.start();
            
            Peer peer4 = new Peer((int) ((Math.random() * (100 - 1))));
            peer4.start();
	}		      	
	
}
