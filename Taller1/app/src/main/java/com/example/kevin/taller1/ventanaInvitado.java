package com.example.kevin.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import Producto.shoes;


public class ventanaInvitado extends AppCompatActivity {

    ListView miListaInvitado;
    ArrayAdapter<shoes> adapter;
    shoes misZapatos [];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_invitado);
        miListaInvitado = (ListView) findViewById(R.id.listaInvitado);
        cargarZapatos();
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,misZapatos);
        miListaInvitado.setAdapter(adapter);
        
    }

    public void cargarZapatos(){
        misZapatos = new shoes().cargarZapatos();
    }
}
