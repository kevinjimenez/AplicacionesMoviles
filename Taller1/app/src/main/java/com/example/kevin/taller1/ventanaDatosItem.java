package com.example.kevin.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Producto.shoes;

public class ventanaDatosItem extends AppCompatActivity {

    String Usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_datos_item);
        shoes detallesZapatos = (shoes) getIntent().getExtras().getSerializable("id");
        Usuario = getIntent().getExtras().getString("usuario");
        Button opcionDeCompra = (Button) findViewById(R.id.btnComprar);
        ((TextView) findViewById(R.id.Nombre)).setText(detallesZapatos.getNombre());
        ((TextView) findViewById(R.id.Marca)).setText(detallesZapatos.getMarca());
        ((TextView) findViewById(R.id.Talla)).setText(String.valueOf(detallesZapatos.getTalla()));
        ((TextView) findViewById(R.id.Precio)).setText(String.valueOf(detallesZapatos.getPrecio()));
        ((TextView) findViewById(R.id.Pais)).setText(detallesZapatos.getPais());
        opcionDeCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Usuario.equalsIgnoreCase("Kevin"))){
                    Toast.makeText(getApplicationContext(),"COMPRASTE EL ARTICULO",Toast.LENGTH_LONG).show();
                }
                if(Usuario.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingresa bro no, esta logeado",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
