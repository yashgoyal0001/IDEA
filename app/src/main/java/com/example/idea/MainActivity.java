package com.example.idea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView acv;
    AppCompatButton p1nxt;
    String[] mood = {"Happy", "Sad", "Excited", "Relaxed", "Angry", "Anxious", "Content", "Confused", "Playful", "Reflective"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acv = findViewById(R.id.autocompletetextview);
        p1nxt = findViewById(R.id.page1nextbutton);
        acv.setThreshold(0);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, mood);
        acv.setAdapter(adapter);

        p1nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(acv.getText().toString().equals("Happy")){
                    Intent npage = new Intent(MainActivity.this, happymood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Sad")){
                    Intent npage = new Intent(MainActivity.this, sadmood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Excited")){
                    Intent npage = new Intent(MainActivity.this, excitedmood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Relaxed")){
                    Intent npage = new Intent(MainActivity.this, relaxedmood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Angry")){
                    Intent npage = new Intent(MainActivity.this, angrymood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Anxious")){
                    Intent npage = new Intent(MainActivity.this, anxiousmood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Content")){
                    Intent npage = new Intent(MainActivity.this, contentmood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Confused")){
                    Intent npage = new Intent(MainActivity.this, confusedmood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Playful")){
                    Intent npage = new Intent(MainActivity.this, playfulmood.class);
                    startActivity(npage);
                }
                if(acv.getText().toString().equals("Reflective")){
                    Intent npage = new Intent(MainActivity.this, reflectivemood.class);
                    startActivity(npage);
                }
            }
        });
    }
}