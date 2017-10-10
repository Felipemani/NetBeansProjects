/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Thiago
 */
import java.security.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String args[]) throws Exception{
        
        Scanner scan = new Scanner(System.in);
        
        String access = null;
        String user = "";
        
        while(access == null){
            
            System.out.println("Entre com o usuário:");
            user = scan.nextLine();

            System.out.println("Entre com a senha local:");
            String senhaLocal = scan.nextLine();

            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senhaLocal.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
              hexString.append(String.format("%02X", 0xFF & b));
            }
            senhaLocal = hexString.toString();
        
            access = validar.validar(user, senhaLocal); 
        }
        List<String> listaSenhas = hash.hash(access.toString());
        System.out.println("0 - " +listaSenhas.get(0).toString());
        System.out.println("1 - " +listaSenhas.get(1).toString());
        System.out.println("2 - " +listaSenhas.get(2).toString());
        System.out.println("3 - " +listaSenhas.get(3).toString());
        System.out.println("4 - " +listaSenhas.get(4).toString());
   
            Socket s = null;

            try{
                int serverPort = 7896;
                s = new Socket("localhost", serverPort);    
                DataInputStream in = new DataInputStream( s.getInputStream());
                DataOutputStream out =new DataOutputStream( s.getOutputStream());
                while(true){
                    
                    //System.out.println("Deseja gerar outras senhas?");
                    //List<String> listaSenhas = hash.hash(senhaSemente);

                    out.writeUTF(user);

                    String data = in.readUTF();	    // read a line of data from the stream
                    System.out.println("Resposta Servidor: "+ data); 
                }
            }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
            }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
            }catch (IOException e){System.out.println("readline:"+e.getMessage());
            }finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
        
    }
}

class hash {
    public static List<String> hash(String text) throws Exception{
        
        //byte[] bytesOfMessage = text.getBytes("UTF-8");
        Calendar calendar = Calendar.getInstance();
        
        String data = String.valueOf(calendar.get(Calendar.YEAR)) +
                String.valueOf(calendar.get(Calendar.MONTH)) +
                String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) +
                String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) +
                String.valueOf(calendar.get(Calendar.MINUTE));
        
        String dataKey = text + data;
        
        List<String> listaHash = new ArrayList<String>();

        for(int i=0; i <= 4; i++){
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(dataKey.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
              hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhahex = hexString.toString();

            listaHash.add(senhahex);
            dataKey = senhahex;
        }
        
        return listaHash;
    
    }

}

class validar {
    public static String validar (String nomeUser, String senhaUser) throws Exception {
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
                return senhaS;
            }else{
                System.out.println("Senha incorreta");
                arq.close();
                return null;
            }
        }
        
        linha = lerArq.readLine(); 
      }
      
      System.out.println("Usuário não existe");
      System.out.println("Crie uma senha semente:");
      Scanner scan = new Scanner(System.in);
      senhaSemente = scan.nextLine();
      
      MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senhaSemente.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        senhaSemente = hexString.toString();
      
      
      FileWriter fw = new FileWriter(arquivo, true);
      BufferedWriter bw = new BufferedWriter(fw);
      
      bw.write(nomeUser+";"+senhaUser+";"+senhaSemente+"\r\n");
      
      bw.close();
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
    return senhaSemente;
  }
}
