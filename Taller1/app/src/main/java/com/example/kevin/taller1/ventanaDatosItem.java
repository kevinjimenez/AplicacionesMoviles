package com.example.kevin.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Producto.shoes;

public class ventanaDatosItem extends AppCompatActivity {

    String Usuario,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_datos_item);
        shoes detallesZapatos = (shoes) getIntent().getExtras().getSerializable("id");
        Usuario = getIntent().getExtras().getString("usuario");
        Password = getIntent().getExtras().getString("pass");

        Button opcionDeCompra = (Button) findViewById(R.id.btnComprar);
        ((TextView) findViewById(R.id.Nombre)).setText("Nombre: "+detallesZapatos.getNombre());
        ((TextView) findViewById(R.id.Marca)).setText("Marca: "+detallesZapatos.getMarca());
        ((TextView) findViewById(R.id.Talla)).setText("Talla del Zapato: "+String.valueOf(detallesZapatos.getTalla()));
        ((TextView) findViewById(R.id.Precio)).setText("Precio: $"+String.valueOf(detallesZapatos.getPrecio()));
        ((TextView) findViewById(R.id.Pais)).setText("Pais de Fabricacion: "+detallesZapatos.getPais());
        opcionDeCompra.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if ((Usuario.equalsIgnoreCase("Kevin"))&&(Password.equalsIgnoreCase("Kevin"))){
                    Toast.makeText(getApplicationContext(),"COMPRASTE EL ARTICULO",Toast.LENGTH_LONG).show();
                }
                if((Usuario.isEmpty()&&(Password.isEmpty()))){
                    Toast.makeText(getApplicationContext(),"Ingresa bro ,no esta logeado",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
