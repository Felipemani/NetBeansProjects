/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as;

import java.security.MessageDigest;

/**
 *
 * @author Thiago
 */
public class Hash {
    public static String hash(String text) throws Exception{
        
        String dataKey = text;
        
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(dataKey.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();
        
        return senhahex;
    }
}
