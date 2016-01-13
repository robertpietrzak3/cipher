package robzii.wfis.unilodz.szyfrator.EncryptMenu.Handler;

import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import robzii.wfis.unilodz.szyfrator.EncryptMenu.EncryptActivity;
import robzii.wfis.unilodz.szyfrator.MainMenu.SimpleCrypto;

/**
 * Created by User on 2015-06-06.
 */
public class DoEncryptHandler implements View.OnClickListener{

    EncryptActivity encryptActivity;

    public DoEncryptHandler(EncryptActivity encryptActivity){
            this.encryptActivity = encryptActivity;
        }
    @Override
    public void onClick(View v) {

 /*       byte[] key = new byte[0];
        byte[] key_finnal;
        byte [] message = new byte[0];
        byte [] hashMessage;
        String hashedMessage;

        String charset = "UTF-8";
        *//*try {*//*
            //key = encryptActivity.methods.getKey().getBytes("UTF-8");
            key = Base64.decode(encryptActivity.methods.getKey() , Base64.DEFAULT);
        KeyGenerator kgen = null;
        try {
            kgen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        sr.setSeed(key);
            kgen.init(128, sr); // 192 and 256 bits may not be available
            SecretKey skey = kgen.generateKey();
            key_finnal = skey.getEncoded();
        *//*} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*//*
        //try {
           // message = encryptActivity.methods.getMessage().getBytes( charset );
        message = Base64.decode(encryptActivity.methods.getMessage() , Base64.DEFAULT);
     *//*   } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
*//*

        try {
            Log.w( encryptActivity.methods.getKey(), encryptActivity.methods.getMessage() );
            hashMessage = encryptActivity.encrypt2(key_finnal  ,message);
            String s = Base64.encodeToString(hashMessage , Base64.DEFAULT);
            encryptActivity.methods.setEncryptedText(s);
            encryptActivity.copyAndDoToast(s);



            System.out.println(s);

            Log.w(encryptActivity.methods.getKey(), encryptActivity.methods.getMessage());
//           / Log.w( hashedMessage, hashedMessage );


        } catch (Exception e) {
            Log.e("DoEncryptHandler","encrypt Exception");
            e.printStackTrace();
        }*/

        if(!encryptActivity.methods.getKey().isEmpty() && !encryptActivity.methods.getMessage().isEmpty() ) {
            try {
                String s = SimpleCrypto.encrypt(encryptActivity.methods.getKey(), encryptActivity.methods.getMessage());
                encryptActivity.methods.setEncryptedText(s);
                encryptActivity.copyAndDoToast(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            encryptActivity.doToast("Cipher or Password is empty.");
        }


    }
}
