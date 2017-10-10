/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author Thiago
 */
import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String args[]) {
        try {
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }
}

class Connection extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        try {
            
            List<String> listaSenhas;
            listaSenhas = hash.hash("teste");
            boolean right = false;
            String user = null;
            while(true){
                if(user == null){
                    user = in.readUTF();
                }
                Scanner scan = new Scanner(System.in);
                System.out.println("Entre com o hash senha semente: ");
                String data = scan.nextLine();
                
                List<String> listaAux = hash.hash(buscaSemente.buscaSemente(user));
                
                if(!listaSenhas.get(0).equals(listaAux.get(0))){
                    listaSenhas = listaAux;
                }
                if(true){         
                    for(int a = 0; a < listaSenhas.size(); a++){
                        if(right){
                            listaSenhas.set(a, "");
                        }else if(listaSenhas.get(a).equals(data.toString())){
                            System.out.println("a senha hash foi: "+listaSenhas.get(a).toString()+ " posição: "+a);
                            listaSenhas.set(a, "");
                            right = true;
                        }
                    }
                }
                
                if(right){
                    System.out.println("acerto");
                    right = false;
                }else{
                    System.out.println("errou");
                }
                System.out.println("");       
                //out.writeUTF(data);
                //System.out.println(data);
            }
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } catch (Exception ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {/*close failed*/
            }
        }
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

class buscaSemente {
    public static String buscaSemente (String nomeUser) throws Exception {
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
            arq.close();
            return senhaS;
        }
        
        linha = lerArq.readLine(); 
      }
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
    return senhaSemente;
  }
}