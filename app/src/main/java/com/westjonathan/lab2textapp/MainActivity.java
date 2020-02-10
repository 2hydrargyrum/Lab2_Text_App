package com.westjonathan.lab2textapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare android elements
    Button submitButton;
    Button msgChange;
    Resources res;
    EditText responseText;
    TextView dispMessage;
    TextView dispMessage2;
    String[] msgArr;
    private int msgIndy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.submitButton);
        responseText=findViewById(R.id.responseEditText);
        dispMessage=findViewById(R.id.msgBox);
        dispMessage2=findViewById(R.id.cycleMsg);
        msgChange=findViewById(R.id.changeMsg);
        msgArr = getResources().getStringArray(R.array.text_array);
        res = getResources();

        dispMessage2.setVisibility(View.INVISIBLE);
        msgChange.setVisibility(View.INVISIBLE);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(!responseText.getText().toString().trim().equals("")) {
                    System.out.println("modified123");
                    dispMessage.setText(getString(R.string.greetWName, responseText.getText()));
                    responseText.setText("");
                    // Set up cycling messages:
                    cycleMessages(dispMessage2);
                    dispMessage2.setVisibility(View.VISIBLE);
                    msgChange.setVisibility(View.VISIBLE);
                    submitButton.setVisibility(View.INVISIBLE);
                    responseText.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    public void cycleMessages(View view) {
        if(msgIndy >= msgArr.length){
            msgIndy = 0;}
        dispMessage2.setText(msgArr[msgIndy++]);
    }
}