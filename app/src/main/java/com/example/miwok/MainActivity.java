package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNumbersList();
            }
        });

        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorsList();
            }
        });

        TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFamilyList();
            }
        });

        TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPhrasesList();
            }
        });
    }

    public void openNumbersList(){
        Intent intent = new Intent(this,NumbersActivity.class);
        startActivity(intent);
    }

    public void openColorsList(){
        Intent intent = new Intent(this,ColorsActivity.class);
        startActivity(intent);
    }

    public void openPhrasesList(){
        Intent intent = new Intent(this,PhrasesActivity.class);
        startActivity(intent);
    }

    public void openFamilyList(){
        Intent intent = new Intent(this,FamilyActivity.class);
        startActivity(intent);
    }
}
