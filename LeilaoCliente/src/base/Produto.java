package base;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shiotanialyson
 */
public class Produto implements Serializable{
    /**
     * ID do produto
     */
    private int produtoID;
    
    /**
     * Nome do produto
     */
    private String nomeProduto;
    
    /**
     * Descrição do produto
     */
    private String descricaoProduto; // String?
    
    /**
     * Preço inicial do produto
     */
    private double precoProduto;
    
    /**
     * Tempo do leilao em minutos
     */
    private int tempoProduto; 
    
    /**
     * ID do cliente que está vendendo o produto
     */
    private int clienteID;
    
    /**
     * Lance do produto
     */
    private double lanceProduto;
    
    /**
     * Status do leilão
     */    
    private boolean statusProduto;
    
    
    private int lanceID;
    
    
    public Produto (int produtoID, String nomeProduto, String descricaoProduto, double precoProduto, int tempoProduto, int clienteID, double lanceProduto,
            boolean statusProduto){
        this.produtoID = produtoID;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.tempoProduto = tempoProduto;
        this.clienteID = clienteID;
        this.lanceProduto = lanceProduto;
        this.statusProduto = statusProduto;
    }

    public Produto(String nomeProduto, String descricaoProduto, double precoProduto, int tempoProduto, int clienteID) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.tempoProduto = tempoProduto;
        this.clienteID = clienteID;
    }
     
    /**
     * Acessa o ID do produto
     */
    public int getID(){
        return produtoID;
    }
    
    /**
     * Acessa o Nome do produto
     */
    public String getNome(){
        return nomeProduto;
    }
    
    /**
     * Acessa a Descrição do produto
     */
    public String getDescricao(){
        return descricaoProduto;
    }
    
    /**
     * Acessa o Preço do produto
     */
    public double getPreco(){
        return precoProduto;
    }
    
   
    /**
     * Acessa o Tempo do produto no leilão
     */
    public int getTempo(){
        return tempoProduto;
    }
    
    /**
     * Acessa o lance mais alto do produto
     */
    public double getLance(){
        return lanceProduto;
    }
    
    /**
     * Acessa o status do produto
     */
    public boolean getStatus(){
        return statusProduto;
    }
    
    /**
     * Modifica o Nome do produto
     */
    public void setNome(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    
    /**
     * Modifica a Descrição do produto
     */
    public void setDescricao(String descricaoProduto){
        this.descricaoProduto = descricaoProduto;
    }
    
    /**
     * Modifica o Preço do produto
     */
    
    public void setPreco(double precoProduto){
        this.precoProduto = precoProduto;
    }
    
       
    /**
     * Modifica o Lance do produto
     */
    public void setLance(double lanceProduto){
        this.lanceProduto = lanceProduto;
    }
    
    /**
     * Modifica o Status do produtoo
     */
    
    public void setStatus(boolean statusProduto){
        this.statusProduto = statusProduto;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getLanceID() {
        return lanceID;
    }

    public void setLanceID(int lanceID) {
        this.lanceID = lanceID;
    }
    
    
}
