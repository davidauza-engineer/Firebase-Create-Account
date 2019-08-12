package engineer.davidauza.firebasecreateaccount;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpNameEditText();
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
                Log.e("TextChange", "CHANGE");
                if (NAME_LAYOUT.getError() != null) {
                    NAME_LAYOUT.setError(null);
                }
//                if (s.length() > 0) {
//                    Log.e("1", "Empty");
//                    if (NAME_LAYOUT.getError() != null) {
//                        NAME_LAYOUT.setError(null);
//                        Log.e("2", "Quitado");
//                    }
//                }
            }
        });
    }
}
