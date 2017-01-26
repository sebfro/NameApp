package com.example.nameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);

        //Henter score value
        Intent intent = getIntent();
        String message = intent.getStringExtra(learningMode.MESSAGE);

        //Lager ny textview med score streng
        TextView tw = (TextView) findViewById(R.id.scoreView);
        tw.setTextSize(40);
        tw.setText(message);


    }

    public void menu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
