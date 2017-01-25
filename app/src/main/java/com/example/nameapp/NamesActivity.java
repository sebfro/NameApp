package com.example.nameapp;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NamesActivity extends AppCompatActivity {
    String[] names = {"Sebastian", "Daniel", "Fedme"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.names_layout, names);

        ListView listView = (ListView) findViewById(R.id.nameList);
        listView.setAdapter(adapter);
    }

    public void nameClicked(View v){
        TextView tV = (TextView)findViewById(R.id.label);
        Toast.makeText(getApplicationContext(), tV.getText(),Toast.LENGTH_SHORT).show();
    }
}
