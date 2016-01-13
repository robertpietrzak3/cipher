package robzii.wfis.unilodz.szyfrator.MainMenu.Handler;

import android.content.Intent;
import android.view.View;

import robzii.wfis.unilodz.szyfrator.DecryptMenu.DecryptActivity;
import robzii.wfis.unilodz.szyfrator.EncryptMenu.EncryptActivity;
import robzii.wfis.unilodz.szyfrator.MainMenu.MainActivity;

/**
 * Created by User on 2015-06-10.
 */
public class DecryptActivityHandler implements View.OnClickListener {

    MainActivity mainAnctivity;

    public DecryptActivityHandler(MainActivity main){
        this.mainAnctivity = main;
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(mainAnctivity, DecryptActivity.class);
        mainAnctivity.startActivity(intent);
    }
}
