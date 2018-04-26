package com.example.kevin.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import Producto.shoes;


public class ventanaInvitado extends AppCompatActivity {

    ListView miListaInvitado;
    ArrayAdapter<shoes> adapter;
    shoes misZapatos [];
    String invitado,passInvitado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_invitado);
        miListaInvitado = (ListView) findViewById(R.id.listaInvitado);
        invitado = getIntent().getExtras().getString("idUser");
        passInvitado = getIntent().getExtras().getString("idPass");
        cargarZapatos();
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,misZapatos);
        miListaInvitado.setAdapter(adapter);
        miListaInvitado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ventanaDatosItem.class);
                intent.putExtra("id",misZapatos[position]);
                intent.putExtra("usuario",invitado);
                intent.putExtra("pass",passInvitado);
                startActivity(intent);
            }
        });
    }

    public void cargarZapatos(){
        misZapatos = new shoes().cargarZapatos();
    }
}
