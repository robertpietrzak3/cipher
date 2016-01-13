package robzii.wfis.unilodz.szyfrator.MainMenu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import robzii.wfis.unilodz.szyfrator.DecryptMenu.DecryptActivity;
import robzii.wfis.unilodz.szyfrator.MainMenu.Handler.DecryptActivityHandler;
import robzii.wfis.unilodz.szyfrator.MainMenu.Handler.EncryptActivityHandler;
import robzii.wfis.unilodz.szyfrator.R;


public class MainActivity extends ActionBarActivity {

    Button encrypt;
    Button decrypt;

    //EncryptActivityHandler hEncryptActivity = new EncryptActivityHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EncryptActivityHandler  EAH = new EncryptActivityHandler(this);
        DecryptActivityHandler  DAH = new DecryptActivityHandler(this);

        encrypt = (Button) findViewById(R.id.butChipher);
        decrypt = (Button) findViewById(R.id.butEncript);

        encrypt.getBackground().setAlpha(50);
        decrypt.getBackground().setAlpha(50);

        decrypt.setOnClickListener(DAH);
        encrypt.setOnClickListener(EAH);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
