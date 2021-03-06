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

import Controlador.controlListaShoes;
import Producto.shoes;


public class ventanaInvitado extends AppCompatActivity {

    controlListaShoes micontrol = new controlListaShoes();
    ListView miListaInvitado;
    ArrayAdapter<String> adapter;
    shoes misZapatos [];
    String [] nombreDeZapatos;
    String invitado,passInvitado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_invitado);
        miListaInvitado = (ListView) findViewById(R.id.listaInvitado);
        invitado = getIntent().getExtras().getString("idUser");
        passInvitado = getIntent().getExtras().getString("idPass");
        micontrol.escribirArchivo(new shoes().cargarZapatos(),"miArchivoInvitado.shoes");
        misZapatos = (shoes[])micontrol.leerArchivo("miArchivoInvitado.shoes");
        //if((invitado.isEmpty()&&(passInvitado.isEmpty()))) {
            adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,cargarNombres());
            miListaInvitado.setAdapter(adapter);
            miListaInvitado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    openPopUp(view,misZapatos[position]);
                }
            });
        //}
    }

    public String[] cargarNombres(){
        nombreDeZapatos = new String[misZapatos.length];
        for (int i=0;i<nombreDeZapatos.length;i++){
            nombreDeZapatos[i]=misZapatos[i].getNombre();
        }
        return nombreDeZapatos;
    }
    //public void cargarZapatos(){
    //    misZapatos = new shoes().cargarZapatos();
    //}
    public void intentos(shoes articulo){
        Intent intent = new Intent(getApplicationContext(), ventanaDatosItem.class);
        intent.putExtra("id", articulo);
        intent.putExtra("usuario", invitado);
        intent.putExtra("pass", passInvitado);
        startActivity(intent);
    }

    public void openPopUp(final View view, final shoes zapatitos){
        PopupMenu popUp=new PopupMenu(this,view);
        popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.opcionVer:
                        intentos(zapatitos);
                        return true;
                    case R.id.opcionComprar:
                        Toast.makeText(getApplicationContext(),"Lo siento logeate",Toast.LENGTH_LONG).show();
                        return true;
                    default:return false;
                }
            }
        });
        popUp.inflate(R.menu.menu_invitado);
        popUp.show();

    }


}
