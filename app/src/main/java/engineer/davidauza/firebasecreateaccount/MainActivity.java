package engineer.davidauza.firebasecreateaccount;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
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
        final TextInputEditText NAME_EDIT_TEXT = findViewById(R.id.txt_name);
        final TextInputLayout NAME_LAYOUT = findViewById(R.id.ly_name);
        // Listener for focus changes
        NAME_EDIT_TEXT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String nameEntered = "";
                    try {
                        nameEntered = NAME_EDIT_TEXT.getText().toString();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                    // Remove spaces from the String
                    nameEntered = nameEntered.replaceAll("\\s", "");
                    // Set the error for the name layout in case the text is less than 4 characters
                    // long, once the spaces had been removed
                    if (nameEntered.length() < 4) {
                        NAME_LAYOUT.setError(getString(R.string.main_activity_error_name) + " "
                                + getString(R.string.main_activity_helper_name));
                    }
                }
            }
        });
        // Listener for changes in text
        NAME_EDIT_TEXT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() >= 5) {
                    // If there is an error being displayed, clear it
                    if (NAME_LAYOUT.getError() != null) {
                        // Get the content in the name EditText without spaces
                        String editTextContent = NAME_EDIT_TEXT.getText().toString().
                                replaceAll("\\s", "");
                        if (editTextContent.length() >= 4) {
                            // Remove the error if there are more than 4 characters once spaces
                            // have been removed.
                            NAME_LAYOUT.setError(null);
                        }
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
