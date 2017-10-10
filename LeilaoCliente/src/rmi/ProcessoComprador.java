/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import leilaocliente.screen.Leilao;

/**
 *
 * @author ROSANA
 */
public class ProcessoComprador extends UnicastRemoteObject implements ClienteInterface{

    private Leilao telaLeilao;
    
    public ProcessoComprador(Leilao telaLeilao)throws RemoteException{
        this.telaLeilao = telaLeilao;
        
    }

    @Override
    public void notificar(int produto, double lance) throws RemoteException {
        telaLeilao.adicionarLog("Novo lance no produto "+produto+" : "+lance);
    }

    @Override
    public void encerrar(int produto, double valorFinal, String vencedor) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
