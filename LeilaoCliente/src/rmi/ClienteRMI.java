/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import base.Cliente;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import leilaocliente.screen.Leilao;

/**
 *
 * @author ROSANA
 */
public class ClienteRMI extends Thread {
    
    private ClienteInterface clienteInterface;
    
    private LeiloeiroInterface leiloeiroInterface;
    
    public ClienteRMI(Leilao telaLeilao) throws RemoteException {
        clienteInterface = new ProcessoComprador(telaLeilao);
    }  
        
     /**
     * Faz a conezão com o MercadoRMI, obtendo a interface
     */
    public boolean inicializaRMI(String address, int porta) throws RemoteException, NotBoundException {

        Registry servidorRMI = LocateRegistry.getRegistry(address, porta);
        leiloeiroInterface = (LeiloeiroInterface) servidorRMI.lookup("LeiloeiroRMI");
        start();
        return false;
    }
         
    /**
     * Método para rodar a Thread
     */
    public void run() {
    }
    
    
    public void cadastraCliente(Cliente cliente) throws RemoteException, NotBoundException {
        leiloeiroInterface.cadastraCliente(cliente);
    }

    public LeiloeiroInterface getLeiloeiroInterface() {
        return leiloeiroInterface;
    }

    public ClienteInterface getClienteInterface() {
        return clienteInterface;
    }
        
}
