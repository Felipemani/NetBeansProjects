/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastpeer;

import java.io.Serializable;

/**
 *
 * @author Thiago
 */
public class PeerMsg implements Serializable {
    private String type;
    private String msg;
    
    public void setMsg(String msg){
        this.msg = msg;
    }
    
    public String getMsg(){
        return this.msg;
    }
    
    public void setType(String msg){
        this.type = type;
    }
    
    public String getType(){
        return this.type;
    }
}
