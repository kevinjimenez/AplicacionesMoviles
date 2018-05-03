package com.example.kevin.leerarchivo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import Control.leerArchivoObjeto;
import modelo.Persona;


public class MainActivity extends AppCompatActivity {

    leerArchivoObjeto oleerarchivo = new leerArchivoObjeto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void leer(View v){
        //leerArchivoPlano();
        Persona p = oleerarchivo.leerArchivo("p.txt");
        Toast.makeText(getApplicationContext(),p.toString(),Toast.LENGTH_LONG).show();
    }

    public void crearArchivo(View view){
        oleerarchivo.escribirArchivo(new Persona("kevin","jimenez","12345678"),"p.txt");
        //escribirArchivoTextoPlano();
    }

    private void escribirArchivoTextoPlano(){
        OutputStreamWriter escribir = null;
        try {
            escribir = new OutputStreamWriter(openFileOutput("fichero.txt", Context.MODE_PRIVATE));
            escribir.write("txt de prueba");
        } catch (FileNotFoundException e) {
            Log.e("error",e.toString());
        } catch (IOException e) {
            Log.e("error",e.toString());
            e.printStackTrace();
        } finally {
            try {
                if (escribir != null) {
                    escribir.close();
                }
            } catch (IOException e) {
            }
        }

    }

    private void leerArchivoPlano(){
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(openFileInput("fichero.txt"));
            br = new BufferedReader(isr);
            String texto = br.readLine();
            while (texto!=null){
                Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_LONG).show();
                texto = br.readLine();
            }
        } catch (FileNotFoundException e) {
            Log.e("error", e.toString());
        } catch (IOException e) {
            Log.e("error", e.toString());
        }
    }



}
