package com.example.circlecisetup3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {

    private TextView name;
    private TextView occupation;
    private TextView age;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        name = findViewById(R.id.name);
        occupation = findViewById(R.id.occupation);
        age = findViewById(R.id.age);
        description = findViewById(R.id.description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            if (bundle.containsKey(Constants.USERNAME_KEY)) {
                name.setText(bundle.getString(Constants.USERNAME_KEY));
            }
            if (bundle.containsKey(Constants.AGE_KEY)) {
                age.setText("" + bundle.getInt(Constants.AGE_KEY));
            }
            if (bundle.containsKey(Constants.OCCUPATION_KEY)) {
                occupation.setText(bundle.getString(Constants.OCCUPATION_KEY));
            }
            if (bundle.containsKey(Constants.DESCRIPTION_KEY)) {
                description.setText(bundle.getString(Constants.DESCRIPTION_KEY));
            }
        }
    }

    public void onBackClick(View view) {
        finish();
    }
}