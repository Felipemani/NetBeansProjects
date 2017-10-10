/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_helloworld;

import HelloWorld.InterfaceServ;
import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Thiago
 */
public class Cliente_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        InterfaceServ interfaceServ = null;
        try{
            interfaceServ = (InterfaceServ) LocateRegistry.getRegistry();
            InterfaceCliServant clientServant = new InterfaceCliServant();
            clientServant.
            Vector sList = aShapeList.allShapes();
        } catch(RemoteException e) {System.out.println(e.getMessage());
            }catch(Exception e) {System.out.println("Client: " + e.getMessage());
        }

    }

}