/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_helloworld;

import java.rmi.RMISecurityManager;
import HelloWorld.InterfaceServ;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Thiago
 */
public class Servidor_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try{
            InterfaceServ aServ = new InterfaceServServant();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("servidor", aServ );
            System.out.println("server ready");
        }catch(Exception e) {
            System.out.println("ShapeList server main " + e.getMessage());
        }

    }
    
}