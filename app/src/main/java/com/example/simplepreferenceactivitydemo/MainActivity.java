package com.example.simplepreferenceactivitydemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Button btnButton;
    TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = findViewById(R.id.txtContent);
        btnButton = findViewById(R.id.btnLaunch);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PrefsActivity.class);
                startActivity(intent);
            }
        });
    }

    //Nice visual proof that the sharedprefs work
    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            StringBuilder stringBuilder = new StringBuilder();

            Map<String, ?> allEntries = sharedPreferences.getAll();
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                stringBuilder.append(entry.getKey() + ": " + entry.getValue().toString() + "\n");
            }

            txtContent.setText(stringBuilder.toString());

    }
}
