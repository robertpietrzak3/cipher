package robzii.wfis.unilodz.szyfrator.DecryptMenu;

/**
 * Created by User on 2015-06-10.
 */
public class DecryptActivityMethods {

    DecryptActivity activity;

    DecryptActivityMethods(DecryptActivity activity){
        this.activity = activity;
    }

    public String getCipher(){
        String cipher;
            cipher = activity.etCipher.getText().toString();
        return cipher;
    }

    public String getKey(){
        String key;
            key = activity.etPassword.getText().toString();
        System.out.println(key);
        return key;
    }

    public void setMessage(String message) {
        activity.tvMessage.setText(message);
    }
}
