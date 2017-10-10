/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Thiago
 */
public class CriptDES {
    byte[] textoPuro;
    byte[] textoEncriptado;
    byte[] textoDecriptografado;
    
    /**
     *
     * @param textoPuro
     * @return
     */
    public static String encript(byte[] textoPuro){
        String textoEncriptado = null;
        try{
            SecretKey chaveDES = new SecretKeySpec(("chave123").getBytes(), "DES");
            Cipher cifraDES;
            // Cria a cifra
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
            // Texto encriptado
            byte[] textoEncrip = cifraDES.doFinal(textoPuro);
            

            textoEncriptado = toHexString(textoEncrip);

        }catch(NoSuchAlgorithmException e){
               e.printStackTrace();
        }catch(NoSuchPaddingException e){
               e.printStackTrace();
        }catch(InvalidKeyException e){
               e.printStackTrace();
        }catch(IllegalBlockSizeException e){
               e.printStackTrace();
        }catch(BadPaddingException e){
               e.printStackTrace();
        }
        return textoEncriptado;
    }
    
        public static byte[] decript(String textoEncriptado){
        byte[] textoDecriptografado = null;
        try{
            SecretKey chaveDES = new SecretKeySpec(("chave123").getBytes(), "DES");
            Cipher cifraDES;
            // Cria a cifra
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
            // Decriptografa o texto
            byte[] textoEncrip = toByteArray(textoEncriptado);
            textoDecriptografado = cifraDES.doFinal(textoEncrip);

        }catch(NoSuchAlgorithmException e){
               e.printStackTrace();
        }catch(NoSuchPaddingException e){
               e.printStackTrace();
        }catch(InvalidKeyException e){
               e.printStackTrace();
        }catch(IllegalBlockSizeException e){
               e.printStackTrace();
        }catch(BadPaddingException e){
               e.printStackTrace();
        }
        return textoDecriptografado;
    }
        
    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }
    
}
