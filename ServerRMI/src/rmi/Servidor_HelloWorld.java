/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author Thiago
 */
public class Servidor_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{

            Registry referenciaServicoNomes = LocateRegistry.createRegistry(1099);
        
            ServImpl aServerRMIServant = new ServImpl(referenciaServicoNomes);
            referenciaServicoNomes.rebind("operacao", aServerRMIServant );

        }catch(Exception e) {
            System.out.println("server main " + e.getMessage());
        }
    }
    
}
