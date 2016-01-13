package robzii.wfis.unilodz.szyfrator.EncryptMenu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import robzii.wfis.unilodz.szyfrator.EncryptMenu.Handler.DoEncryptHandler;
import robzii.wfis.unilodz.szyfrator.R;


public class EncryptActivity extends ActionBarActivity {

    EditText etMessage;
    EditText etKey;
    EditText etHashed;
    Button bEncript;
    DoEncryptHandler encryptHandler;

    public EncryptActivityMethods methods = new EncryptActivityMethods(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        etMessage   = (EditText)findViewById(R.id.etMessage);
        etKey       = (EditText)findViewById(R.id.etKey);
        bEncript    = (Button) findViewById(R.id.bDoEncrypt);
        etHashed    = (EditText) findViewById(R.id.etEncypted);

        encryptHandler = new DoEncryptHandler(this);

        bEncript.setOnClickListener(encryptHandler);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_encrypt, menu);
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

    public static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {

        SecretKeySpec skeySpec;
            skeySpec = new SecretKeySpec(getRawKey(raw), "AES");
        Cipher cipher;
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);


        byte[] encrypted;
            encrypted = cipher.doFinal(clear);

        Log.w("encrypt", "encrypt");
        Log.e(new String(raw), new String(clear));
        return encrypted;
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
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

    public static byte[] encrypt2(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

}
