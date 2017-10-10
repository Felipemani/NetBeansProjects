/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_helloworld;

import HelloWorld.InterfaceCli;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Thiago
 */
public class InterfaceCliServant extends UnicastRemoteObject implements InterfaceCli{

    public InterfaceCli echo(String args) throws RemoteException {
        System.out.println(args);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
