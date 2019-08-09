package com.example.menu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text = (TextView) findViewById(R.id.textView5);
        text.setText("CREDITS : \n \n CODING AND GRAPHICS BY Tejas Adhikari \n DOCUMENTATION BY Shubham Agrawal  \n CODING SIDEKICK : Sourasish Roy \n MOTIVATION BY Deep Vora, Tejas Adhikari, Shubham Agrawal and Sourasish Roy ");

    }
}
