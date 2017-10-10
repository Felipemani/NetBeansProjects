/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Thiago 
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ{
    Lista lista = new Lista();
    List<InterfaceCli> listaInterface;
    Registry referenciaServicoNomes;
    
    public ServImpl(Registry referenciaServicoNomes)throws RemoteException {
        this.referenciaServicoNomes = referenciaServicoNomes;
        listaInterface = new ArrayList<InterfaceCli>();
        lista.create();
    }
    
    public void operacao(String tipo, InterfaceCli interface_cli, Acao acao ) throws RemoteException{
        
        
        if(!listaInterface.contains(interface_cli)){
            listaInterface.add(interface_cli);
        }
        
        if(tipo.equals("consulta")){

            interface_cli.exibeConsulta(lista);    
        }
        if(tipo.equals("venda")){
            
            lista.addAcao(acao);
            
            interface_cli.echo("Iten adicionado ao mercado de ações para venda!");
            try {
                for (InterfaceCli client: listaInterface) {
                     
                    client.exibeConsulta(lista);
                }
            } catch (AccessException ex) {
                Logger.getLogger(ServImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(tipo.equals("compra")){
            
            Boolean vendeu = false;
            Acao acaoServ = lista.containsAcao(acao);
            
            if(acaoServ != null){
                if(acaoServ.getValor() <=  acao.getValor()){
                    if(acaoServ.getQuantidade() >=  acao.getQuantidade()){
                        
                        if((acaoServ.getQuantidade() - acao.getQuantidade()) == 0 ) {
                            lista.removeAcao(acaoServ.getNome());
                        }else{
                            acaoServ.setQuantidade(acaoServ.getQuantidade() - acao.getQuantidade());
                        }
                        
                        interface_cli.echo("Acao comprada");
                        InterfaceCli interfaceVendedor = acao.getInterface_cli();
                        interfaceVendedor.echo("acao vendida");
                        vendeu = true;   
                    }else{
                        interface_cli.echo("Quantidade maior que o fornecido");
                    }
                }else{
                    interface_cli.echo("Valor abaixo do pedido");
                }
            }else{
                interface_cli.echo("Acao nao existe");
            }
            
            if(vendeu){
                try {
                    for (InterfaceCli client: listaInterface) {
                        client.exibeConsulta(lista);
                    }
                } catch (AccessException ex) {
                    Logger.getLogger(ServImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }
}


