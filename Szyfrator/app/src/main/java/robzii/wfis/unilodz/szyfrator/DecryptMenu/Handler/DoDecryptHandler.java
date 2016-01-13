package robzii.wfis.unilodz.szyfrator.DecryptMenu.Handler;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import robzii.wfis.unilodz.szyfrator.DecryptMenu.DecryptActivity;
import robzii.wfis.unilodz.szyfrator.MainMenu.SimpleCrypto;

/**
 * Created by User on 2015-06-10.
 */
public class DoDecryptHandler implements View.OnClickListener {

    DecryptActivity activity;

    public DoDecryptHandler(DecryptActivity decrypt){
        this.activity = decrypt;
    }

    @Override
    public void onClick(View v){
        /*byte[] hash_key = new byte[0];
        byte[] key_finnal = new byte[0];
        byte [] hash_cipher = new byte[0];
        byte [] hash_Message = new byte[0];


        String charset = "UTF-8";

        try {
            hash_key = activity.methods.getKey().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //hash_key = Base64.decode( activity.methods.getKey() , Base64.DEFAULT);
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
        sr.setSeed(hash_key);
            kgen.init(128, sr); // 192 and 256 bits may not be available
            SecretKey skey = kgen.generateKey();
            key_finnal = skey.getEncoded();

      *//*  } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*//*
      //  try {
            hash_cipher = Base64.decode(activity.methods.getCipher(), Base64.DEFAULT);
//           / hash_cipher = activity.methods.getCipher().getBytes(charset);
       *//* } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*//*

        try {
            hash_Message = activity.decrypt2(key_finnal , hash_cipher);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        if(!activity.methods.getKey().isEmpty() || !activity.methods.getCipher().isEmpty()) {
            String s = "";
            try {
                System.out.println("Dekodowane :" + s);
                s = SimpleCrypto.decrypt(activity.methods.getKey(), activity.methods.getCipher());

            } catch (Exception e) {
                e.printStackTrace();
            }

            //String s = Base64.encodeToString(hash_Message , Base64.DEFAULT);
            //System.out.println(s);
            activity.methods.setMessage(s);
            activity.copyAndDoToast(s);
            if(s.isEmpty()){
                activity.methods.setMessage("Probably bad password");
            }
        }
        else {
            activity.doToast("Message or Password is empty");
        }


    }

}
