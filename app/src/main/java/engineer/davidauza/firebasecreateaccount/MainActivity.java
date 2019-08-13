package engineer.davidauza.firebasecreateaccount;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpNameEditText();
        setUpEmailEditText();
        setUpPhoneEditText();
    }

    /**
     * This method configures the behavior of the name EditText.
     */
    private void setUpNameEditText() {
        TextInputEditText nameEditText = findViewById(R.id.txt_name);
        final TextInputLayout NAME_LAYOUT = findViewById(R.id.ly_name);
        // Listener for the action button on the editor
        nameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String nameEntered = v.getText().toString();
                if (nameEntered.equals("")) {
                    NAME_LAYOUT.setError(getString(R.string.main_activity_error_name));
                }
                return false;
            }
        });
        // Listener for changes in text
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    if (NAME_LAYOUT.getError() != null) {
                        NAME_LAYOUT.setError(null);
                    }
                }
            }
        });
    }

    /**
     * This method configures the behavior of the email EditText.
     */
    private void setUpEmailEditText() {
        TextInputEditText emailEditText = findViewById(R.id.txt_email);
        final TextInputLayout EMAIL_LAYOUT = findViewById(R.id.ly_email);
        // Listener for the action method on the editor
        emailEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (checkEmail(v.getText())) {
                    if (EMAIL_LAYOUT.getError() != null) {
                        EMAIL_LAYOUT.setError(null);
                    }
                } else {
                    EMAIL_LAYOUT.setError(getString(R.string.main_activity_error_email));
                }
                return false;
            }
        });
    }

    /**
     * This method checks if a CharSequence is built with an email format.
     *
     * @param pEmailEntered is the CharSequence to check.
     * @return true if the CharSequence contains a text with an email format, otherwise it returns
     * false.
     */
    private boolean checkEmail(CharSequence pEmailEntered) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(pEmailEntered).matches();
    }

    /**
     * This method configures the behavior of the phone EditText.
     */
    private void setUpPhoneEditText() {
        TextInputEditText phoneEditText = findViewById(R.id.txt_phone);
        final TextInputLayout PHONE_LAYOUT = findViewById(R.id.ly_phone);
        // Listener for the action method on the editor
        phoneEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (checkPhone(v.getText())) {
                    if (PHONE_LAYOUT != null) {
                        PHONE_LAYOUT.setError(null);
                    }
                } else {
                    PHONE_LAYOUT.setError(getString(R.string.main_activity_error_phone));
                }
                return false;
            }
        });
    }

    /**
     * This method checks if a CharSequence is built with a phone format.
     *
     * @param pPhoneEntered is the CharSequence to check.
     * @return true if the CharSequence contains a text with a phone format, otherwise it returns
     * false.
     */
    private boolean checkPhone(CharSequence pPhoneEntered) {
        return Patterns.PHONE.matcher(pPhoneEntered).matches();
    }

}
