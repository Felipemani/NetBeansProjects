/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Thiago
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCli {
    
    public CliImpl()throws RemoteException {}
    
    public void echo( String text ) throws RemoteException{
        System.out.println(text);
    }
    
    public void exibeConsulta(Lista lista) throws RemoteException {
        
        for (String name: lista.lista.keySet()){

            String key = name;
            Acao value = lista.lista.get(name);  
            System.out.println("Empresa: " + key + " - Valor: " + value.getValor() + " - Quantidade: " + value.getQuantidade());  
        }
    }  
}
