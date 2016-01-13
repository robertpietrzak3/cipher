package robzii.wfis.unilodz.szyfrator.EncryptMenu;

import android.text.Editable;

/**
 * Created by User on 2015-06-06.
 */
public class EncryptActivityMethods {

    EncryptActivity encryptActivity;

    public EncryptActivityMethods(EncryptActivity encryptActivity) {
        this.encryptActivity = encryptActivity;
    }

    public String getKey(){
        String key;
            key = encryptActivity.etKey.getText().toString();
        return key;
    }

    public String getMessage(){
        String message;
            message = encryptActivity.etMessage.getText().toString();
        return message;

    }

    public void setEncryptedText(String message){
        encryptActivity.etHashed.setText(message);
    }




}
