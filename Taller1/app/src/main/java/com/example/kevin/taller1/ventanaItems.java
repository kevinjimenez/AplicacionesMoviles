package com.example.kevin.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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
        if ((user.equalsIgnoreCase("Kevin"))&&(pass.equalsIgnoreCase("Kevin"))) {
            miLista = (ListView) findViewById(R.id.miLista);
            cargarZapatos();
            adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, misZapatos);
            miLista.setAdapter(adapter);
            miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    openPopUp(view,misZapatos[position]);
                }
            });
        }
    }
    public void cargarZapatos(){
        misZapatos = new shoes().cargarZapatos();
    }

    public void openPopUp(final View view, final shoes zapatitos){
        PopupMenu popUp=new PopupMenu(this,view);
        popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent;
                switch (item.getItemId()){
                    case R.id.Ver:
                        intent = new Intent(getApplicationContext(), ventanaDatosItem.class);
                        intent.putExtra("id", zapatitos);
                        intent.putExtra("usuario", user);
                        intent.putExtra("pass", pass);
                        startActivity(intent);
                        return true;
                    case R.id.Comprar:
                        intent = new Intent(getApplicationContext(), ventanaDatosItem.class);
                        intent.putExtra("usuario", user);
                        intent.putExtra("pass", pass);
                        if ((user.equalsIgnoreCase("Kevin"))&&(pass.equalsIgnoreCase("Kevin"))) {
                            Toast.makeText(getApplicationContext(),"Compraste El articulo",Toast.LENGTH_LONG).show();
                        }
                        return true;
                    case  R.id.Modificacion:
                        return false;
                        default:return false;
                }
            }
        });
        popUp.inflate(R.menu.menuopciones);
        popUp.show();

    }
}
