package com.example.kevin.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import Controlador.controlListaShoes;
import Producto.shoes;

public class ventanaItems extends AppCompatActivity {

    ListView miLista;
    ArrayAdapter<shoes> adapter;
    shoes misZapatos[];
    String user,pass;
    controlListaShoes miControl=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_items);
        user = getIntent().getExtras().getString("idUser");
        pass = getIntent().getExtras().getString("idPass");
        miControl = (controlListaShoes) getIntent().getExtras().getSerializable("miArchivo");
        miControl.escribirArchivo(new shoes().cargarZapatos(),"miArchivo.txt");
        misZapatos = miControl.leerArchivo("miArchivo.txt");
        //if ((user.equalsIgnoreCase("Kevin"))&&(pass.equalsIgnoreCase("Kevin"))) {
            miLista = (ListView) findViewById(R.id.miLista);
            //cargarZapatos();
            adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,misZapatos);
            miLista.setAdapter(adapter);
            miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    openPopUp(view,misZapatos[position]);
                }
            });
        //}
    }
    /*public void cargarZapatos(){
        misZapatos = new shoes().cargarZapatos();
    }*/
    public void intentos(shoes articulo){
        Intent intent = new Intent(getApplicationContext(), ventanaDatosItem.class);
        intent.putExtra("id", articulo);
        intent.putExtra("usuario", user);
        intent.putExtra("pass", pass);
        startActivity(intent);
    }

    public void openPopUp(final View view, final shoes zapatitos){
        PopupMenu popUp=new PopupMenu(this,view);
        popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Ver:
                        intentos(zapatitos);
                        return true;
                    case R.id.Comprar:
                        if ((user.equalsIgnoreCase("Kevin"))&&(pass.equalsIgnoreCase("Kevin"))) {
                            Toast.makeText(getApplicationContext(),"Compraste El articulo",Toast.LENGTH_LONG).show();
                        }
                        return true;
                    case  R.id.Modificacion:
                        Toast.makeText(getApplicationContext(),"FALTA ESTA OPCION",Toast.LENGTH_LONG).show();
                        return true;
                        default:return false;
                }
            }
        });
        popUp.inflate(R.menu.menuopciones);
        popUp.show();

    }
}
