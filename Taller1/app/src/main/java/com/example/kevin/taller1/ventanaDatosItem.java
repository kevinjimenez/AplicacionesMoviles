package com.example.kevin.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import Producto.shoes;

public class ventanaDatosItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_datos_item);
        shoes detallesZapatos = (shoes) getIntent().getExtras().getSerializable("id");
        ((TextView) findViewById(R.id.Nombre)).setText(detallesZapatos.getNombre());
        ((TextView) findViewById(R.id.Marca)).setText(detallesZapatos.getMarca());
        ((TextView) findViewById(R.id.Talla)).setText(String.valueOf(detallesZapatos.getTalla()));
        ((TextView) findViewById(R.id.Precio)).setText(String.valueOf(detallesZapatos.getPrecio()));
        ((TextView) findViewById(R.id.Pais)).setText(detallesZapatos.getPais());
        
    }
}
