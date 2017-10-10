/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_helloworld;

import HelloWorld.InterfaceCli;
import HelloWorld.InterfaceServ;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Thiago
 */
public class InterfaceServServant extends UnicastRemoteObject implements InterfaceServ {
    
    public InterfaceCli chamar(String nome, InterfaceCli refCli) throws RemoteException {
        return refCli.echo(nome);
    }
}