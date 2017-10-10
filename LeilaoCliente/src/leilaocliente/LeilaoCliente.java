/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leilaocliente;

import base.Cliente;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import leilaocliente.screen.Leilao;
import rmi.ClienteRMI;

/**
 *
 * @author Alyson e Rosana
 */
public class LeilaoCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Leilao l = new Leilao();
        ClienteRMI rmi = new ClienteRMI(l); 
        rmi.inicializaRMI("localhost", 1099); 
        
        Cliente cliente = new Cliente("Juliano");          
        
        l.setClienteRMI(rmi);
        l.setCliente(cliente);
        l.setLeiloeiroInterface(rmi.getLeiloeiroInterface());
        l.setVisible(true);
        
    }
    
}