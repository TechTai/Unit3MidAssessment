package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class RecyclerActivity extends AppCompatActivity {

    private SharedPreferences prefA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        String user = intent.getStringExtra("sharedpref");

        prefA = getApplicationContext().getSharedPreferences(user,MODE_PRIVATE);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        ArrayList<String> emailArrayList = new ArrayList<>();

        Map<String, ?> allEntries = prefA.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            emailArrayList.add(entry.getValue().toString());
        }




    }

}
