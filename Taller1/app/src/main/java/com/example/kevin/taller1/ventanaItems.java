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

public class ventanaItems extends AppCompatActivity {

    ListView miLista;
    ArrayAdapter<shoes> adapter;
    shoes misZapatos[];
    String user,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_items);
        user = getIntent().getExtras().getString("idUser");
        pass = getIntent().getExtras().getString("idPass");
        miLista = (ListView) findViewById(R.id.miLista);
        cargarZapatos();
        adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,misZapatos);
        miLista.setAdapter(adapter);
        miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ventanaDatosItem.class);
                intent.putExtra("id",misZapatos[position]);
                intent.putExtra("usuario",user);
                intent.putExtra("pass",pass);
                startActivity(intent);
            }
        });
    }
    public void cargarZapatos(){
        misZapatos = new shoes().cargarZapatos();
    }
}
