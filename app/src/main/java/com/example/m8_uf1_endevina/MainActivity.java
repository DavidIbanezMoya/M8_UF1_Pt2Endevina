package com.example.m8_uf1_endevina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int number = 22;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.comprovar);
        TextView input = (TextView) findViewById(R.id.userNumber);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Context context = getApplicationContext();
                int userGuess = Integer.valueOf(input.getText().toString());
                //Log.v("Algo","Este sera el numero"+R.id.userNumber);
                if (userGuess == number) {
                    Toast.makeText(context, "Correct, you have guessed it right", Toast.LENGTH_SHORT).show();
                }
                if (userGuess < number) {
                    Toast.makeText(context, "The number has to be bigger!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "The number has to be smaller!", Toast.LENGTH_SHORT).show();

                    //Toast.makeText(context, "The number has to be smaller!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}