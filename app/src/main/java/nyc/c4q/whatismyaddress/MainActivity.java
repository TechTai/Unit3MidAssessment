package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "address_shared_preferences";
    private EditText userEmail;
    private Button saveButton;
    private Button submitButton;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = (EditText) findViewById(R.id.useremail_edittext);
        saveButton = (Button) findViewById(R.id.saveemail_button);
        submitButton = (Button) findViewById(R.id.submit_button);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = login.edit();
                userEmail.setText(login.getString("email_address", null));
                editor.putString("email_address", userEmail.getText().toString());
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra("sharedpref", SHARED_PREFS_KEY);
                startActivity(intent);

            }
        });

    }
}
