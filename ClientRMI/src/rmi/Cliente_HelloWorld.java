/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Thiago
 */
public class Cliente_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {

        Registry referenciaServicoNomes = LocateRegistry.getRegistry();
        InterfaceServ a;
        Lista minhasAcoes = new Lista();
        
        try {
            a = (InterfaceServ) referenciaServicoNomes.lookup("operacao");
            CliImpl aCliImpl = new CliImpl();
                
            if(true){
                a.operacao("consulta", aCliImpl, null);
            }
            if(true){
                Acao acao = new Acao();
                acao.setNome("Q1");
                acao.setValor(10);
                acao.setQuantidade(50);
                acao.setInterface_cli(aCliImpl);
                a.operacao("venda", aCliImpl, acao);
            }
            if(true){
                Acao acao = new Acao();
                acao.setNome("Q1");
                acao.setValor(10);
                acao.setQuantidade(40);
                acao.setInterface_cli(aCliImpl);
                a.operacao("compra", aCliImpl, acao);
            }
            
        
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente_HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(Cliente_HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
