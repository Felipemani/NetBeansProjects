/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import base.Cliente;
import base.Produto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Rosana
 */
public interface LeiloeiroInterface extends Remote{
    
    //Registra um cliente no servidor
    public void cadastraCliente(Cliente cliente) throws RemoteException;
    
    //Registra lance num produto
    public void lance(int produto, double lance, int cliente, ClienteInterface clienteInterface) throws RemoteException;
   
    public void incluirProduto(Produto produto) throws RemoteException;
    
    public List<Produto> listaProdutos() throws RemoteException;
    
    public List<Produto> meusProdutos(int clienteID) throws RemoteException;
    
    public List<Produto> produtosSubscribe(int clienteID)  throws RemoteException;
    
}
