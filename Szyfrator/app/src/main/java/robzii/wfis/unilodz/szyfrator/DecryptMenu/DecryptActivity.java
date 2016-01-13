package robzii.wfis.unilodz.szyfrator.DecryptMenu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import robzii.wfis.unilodz.szyfrator.DecryptMenu.Handler.DoDecryptHandler;
import robzii.wfis.unilodz.szyfrator.MainMenu.Handler.DecryptActivityHandler;
import robzii.wfis.unilodz.szyfrator.R;

public class DecryptActivity extends ActionBarActivity {

    EditText etCipher , etPassword;
    TextView tvMessage;
    Button bDecrypt;

    public DecryptActivityMethods methods;
    DoDecryptHandler doDecryptHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        methods = new DecryptActivityMethods(this);
        etCipher = (EditText) findViewById(R.id.etCipher);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvMessage = (TextView) findViewById(R.id.tvMsg);
        bDecrypt = (Button) findViewById(R.id.bDoDecrypt);
        doDecryptHandler = new DoDecryptHandler(this);

        bDecrypt.setOnClickListener(doDecryptHandler);
        bDecrypt.getBackground().setAlpha(50);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_decrypt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(getRawKey(raw), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }



    public static byte[] decrypt2(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG" , "Crypto");
        sr.setSeed(seed);
        kgen.init(128, sr); // 192 and 256 bits may not be available
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        return raw;
    }

    public void copyAndDoToast(String message){

        ClipData myClip;
        ClipboardManager myClipboard =(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        myClip = ClipData.newPlainText("text", message);
        myClipboard.setPrimaryClip(myClip);
        doToast("Text Copied");
    }

    public void doToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

}
