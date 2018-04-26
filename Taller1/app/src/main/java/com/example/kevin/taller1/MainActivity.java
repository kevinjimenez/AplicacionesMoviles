package com.example.kevin.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText)  findViewById(R.id.inputUser);
        pass = (EditText)  findViewById(R.id.inputPass);
    }

    public void openItems(View view){
        if(user.getText().toString().equalsIgnoreCase("Kevin")){
            //Toast.makeText(getApplicationContext(),"PON ALGO BRO",Toast.LENGTH_LONG).show();
            Intent intents = new Intent(getApplicationContext(),ventanaItems.class);
            intents.putExtra("idUser",user.getText().toString());
            startActivity(intents);
        }
    }
    public void openInvitado(View view){
        if((user.getText().toString().isEmpty())){
            Intent intents = new Intent(getApplicationContext(),ventanaInvitado.class);
            intents.putExtra("idUser",user.getText().toString());
            startActivity(intents);
        }

    }
}
