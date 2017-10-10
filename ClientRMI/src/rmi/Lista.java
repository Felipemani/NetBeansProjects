/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thiago
 */
public class Lista implements Serializable{
    
    Map<String, Acao> lista = new HashMap<String, Acao>();
    
    public Map create(){
        
        Acao novaAcao = new Acao();
        
        novaAcao.setNome("A1");
        novaAcao.setValor(10);
        novaAcao.setQuantidade(100);
        novaAcao.setInterface_cli(null);
        
        lista.put("A1", novaAcao);
        return lista;
    }
    
    public Map addAcao( Acao novaAcao ){
        lista.put(novaAcao.getNome(), novaAcao);
        return lista;
    }
    
    public Map removeAcao(String nome) throws RemoteException{
        Acao removedAcao = lista.get(nome);
        removedAcao.getInterface_cli().echo("ação vendida");
        
        lista.remove(nome);
        return lista;
    }
    
    public Acao containsAcao( Acao novaAcao ){
        return lista.get(novaAcao.getNome());
    }   
}

class Acao implements Serializable{

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the interface_cli
     */
    public InterfaceCli getInterface_cli() {
        return interface_cli;
    }

    /**
     * @param interface_cli the interface_cli to set
     */
    public void setInterface_cli(InterfaceCli interface_cli) {
        this.interface_cli = interface_cli;
    }
    private String nome;
    private int valor;
    private int quantidade;
    private InterfaceCli interface_cli;

}
