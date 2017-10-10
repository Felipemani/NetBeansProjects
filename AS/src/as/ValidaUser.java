/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class ValidaUser {
    public static boolean validar (String nomeUser, String senhaUser) throws Exception {
    Scanner ler = new Scanner(System.in);
    String senhaSemente = null;
 
    try {
      File arquivo = new File("C:\\Users\\Thiago\\Desktop\\senhas.txt");
      FileReader arq = new FileReader(arquivo);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      
      while(linha != null){
        String[] parts = linha.split(";");
        String nome = parts[0];
        String senha = parts[1];
        String senhaS = parts[2];
        
        if(nomeUser.equals(nome)){
            if(senhaUser.equals(senha)){
                System.out.println("Usuário autenticado");
                arq.close();
                return true;
            }else{
                System.out.println("Senha incorreta");
                arq.close();
                return false;
            }
        }
        
        linha = lerArq.readLine(); 
      }
      System.out.println("Usuário não existe");
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
    return false;
  }
}
