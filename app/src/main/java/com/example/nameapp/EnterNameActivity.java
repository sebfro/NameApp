package com.example.nameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
    }

    public void submitName(View v){
        EditText eT = (EditText)findViewById(R.id.userInput);
        String name = eT.getText().toString();
        Intent i = new Intent(this, MainActivity.class);
        MainActivity.drawableArrayList.get(MainActivity.images).setName(name);
        MainActivity.addImage();
        finish();
    }
}
