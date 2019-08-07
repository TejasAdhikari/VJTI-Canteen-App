package com.example.menu2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sourabobs extends AppCompatActivity {
    public TextView welcomeTextView;
    public Button MenuBtn;
    public Button AboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sourabob);
        welcomeTextView = (TextView) findViewById(R.id.textView);

        MenuBtn = (Button) findViewById(R.id.button);
        MenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(sourabobs.this,"menu",Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mIntent);
            }
        });
        AboutBtn = (Button) findViewById(R.id.button2);
        AboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(sourabobs.this,"about us",Toast.LENGTH_SHORT).show();
            }
        });


    }
}