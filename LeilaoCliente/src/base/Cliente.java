package base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shiotanialyson
 */
public class Cliente implements Serializable{
    /**
     * Identificação do cliente
     */
    private int Id;    
    
    /**
     * Nome do cliente
     */
    private String Nome;
        
    private List<Produto> produtos;
    /**
     * Método construtor
     */
    public Cliente (String nome){
        this.Id = (int)(Math.random()*10000000);
        this.Nome = nome;  
        this.produtos = new ArrayList();
    }
    
    /**
     * Acessa o Id do cliente 
     */
    public int getId(){
        return Id;
    }
      
    
    /**
     * Acessa o Nome do cliente
     */
    public String getNome(){
        return Nome;
    }
        
    /**
     * Modifica o nome do cliente
     */
    
    public void setNome(String nome){
        this.Nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }
}
