/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rosana
 */
public interface ClienteInterface extends Remote{
    
    public void notificar(int produto, double lance)throws RemoteException;
    
    public void encerrar(int produto, double valorFinal, String vencedor)throws RemoteException;
}
