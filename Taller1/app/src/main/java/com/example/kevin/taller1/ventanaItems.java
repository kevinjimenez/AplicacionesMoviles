package com.example.kevin.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import Producto.shoes;

public class ventanaItems extends AppCompatActivity {

    ListView miLista;
    ArrayAdapter<shoes> adapter;
    shoes misZapatos[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_items);
        ((TextView) findViewById(R.id.Usuario)).setText(getIntent().getExtras().getString("idUser"));
        miLista = (ListView) findViewById(R.id.miLista);
        cargarZapatos();
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,misZapatos);
        miLista.setAdapter(adapter);
    }

    public void cargarZapatos(){
        misZapatos = new shoes[] { new shoes("kkk","etnies","vietnan", 105,0),
                new shoes("kkk1","etnies","vietnan", 105,0),
                new shoes("kkk2","etnies","vietnan", 105,0),
                new shoes("kkk3","etnies","vietnan", 105,0),
                new shoes("kkk4","etnies","vietnan", 105,0),
        };
    }
}
