/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Thiago
 */
public interface InterfaceCli extends Remote{
    
   InterfaceCli echo(String args) throws RemoteException;
}
