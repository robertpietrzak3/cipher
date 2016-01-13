package robzii.wfis.unilodz.szyfrator.MainMenu.Handler;


import android.content.Intent;
import android.view.View;

import robzii.wfis.unilodz.szyfrator.EncryptMenu.EncryptActivity;
import robzii.wfis.unilodz.szyfrator.MainMenu.MainActivity;

/**
 * Created by User on 2015-06-04.
 */
public class EncryptActivityHandler implements View.OnClickListener {

    MainActivity mainAnctivity;

    public EncryptActivityHandler(MainActivity main){
        this.mainAnctivity = main;
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(mainAnctivity, EncryptActivity.class);
        mainAnctivity.startActivity(intent);
    }
}
