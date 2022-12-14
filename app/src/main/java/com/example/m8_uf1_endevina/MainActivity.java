package com.example.m8_uf1_endevina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int number = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
    int userTry = 0;
    //ArrayLIST DE USERS CREAR CLASE USER
    ArrayList<user>userList = new ArrayList<user>();
    //TextView logs = (TextView) findViewById(R.id.Logs);

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.comprovar);
        TextView input = (TextView) findViewById(R.id.userNumber);
        TextView numer = (TextView) findViewById(R.id.numero);
        TextView registry = (TextView) findViewById(R.id.Registry);
        TextView logs = (TextView) findViewById(R.id.Logs);
        Button ranking = (Button) findViewById(R.id.ranking);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //REVISAR PER A QUE QUAN ES FAGI CLICK A COMPROVAR BUIT NO PETI
                Context context = getApplicationContext();
                if (input.getText() == null) {
                    Toast.makeText(context, "You must put a number!", Toast.LENGTH_SHORT).show();
                }

                else {
                    int userGuess = Integer.valueOf(input.getText().toString());
                    userTry += 1;
                    numer.setText("Tries: "+userTry);
                    logs.setMovementMethod(new ScrollingMovementMethod());

                    Log.v("Intento","Intento numero: "+userTry);
                    //Log.v("Algo","Este sera el numero"+R.id.userNumber);
                    if (userGuess == number) {

                        Toast.makeText(context, "Correct, you have guessed it right", Toast.LENGTH_SHORT).show();
                        showDialog();
                    }
                    else if (userGuess < number) {
                        Toast.makeText(context, "The number has to be bigger!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context, "The number has to be smaller!", Toast.LENGTH_SHORT).show();

                        //Toast.makeText(context, "The number has to be smaller!", Toast.LENGTH_SHORT).show();
                    }
                    logs.append("Your last try was "+userGuess+"\n");

                }
                }

        });
        ranking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Cambiar de pestana aqui
                Intent rankIntent = new Intent(MainActivity.this, rankings.class);

                rankIntent.putExtra("Users",userList);
                startActivity(rankIntent);
                //Se necesitara recuperar el nombre de usuario
            }
        });
    }

    //En void no hi ha problema pero no se com recuperar el nom que agafem de l usuari
 public void showDialog(){
        //Para anadir el dialogo donde el usuario decidira si volver a jugar una nueva partida o no
     //Y que pueda guardar el campo del nombre de usuario
     AlertDialog.Builder builder = new AlertDialog.Builder(this);
     String message = "Congratulations";
     final EditText name = new EditText(this);


     builder.setView(name).setMessage(message).setPositiveButton("Play again", new DialogInterface.OnClickListener() {

         public void onClick(DialogInterface dialogInterface, int i) {
             String finalname = String.valueOf(name.getText());
            user newUser = new user(finalname,userTry);
            userList.add(newUser);
            number = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
            userTry = 0;
            TextView numer = (TextView) findViewById(R.id.numero);
            numer.setText("");
            TextView logs = (TextView) findViewById(R.id.Logs);
            logs.setText("");

             for (user user1: userList) {
                 Log.i("Name",user1.getName());
                 Log.i("Tries",Integer.toString(user1.getTries()));

             }

            //Les altres variables s han de posar globals com aquesta
         }
     });

      builder.create().show();
 }
}

