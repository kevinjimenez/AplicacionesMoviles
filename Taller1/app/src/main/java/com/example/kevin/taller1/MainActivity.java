package com.example.kevin.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        Intent intents = new Intent(getApplicationContext(),ventanaItems.class);
        intents.putExtra("idUser","Usuario: "+user.getText().toString());
        startActivity(intents);
    }
    public void openInvitado(View view){
        Intent intents = new Intent(getApplicationContext(),ventanaInvitado.class);
        startActivity(intents);
    }
}
