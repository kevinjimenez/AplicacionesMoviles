package Controlador;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Producto.shoes;

public class controlListaShoes{
    private File archivo = Environment.getExternalStorageDirectory();
    private String ruta = archivo.getAbsolutePath()+File.separator;


    public void escribirArchivo(shoes misZapatos[],String nombreArchivos){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(ruta+nombreArchivos);
            out = new ObjectOutputStream(fos);
            out.writeObject(misZapatos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("error archivo",e.toString());
        } catch (IOException e) {
            Log.e("error io",e.toString());
        }
    }

    public shoes[] leerArchivo(String nombreArchivo){
        shoes[] misListaZapatos = new shoes[]{};
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(ruta+nombreArchivo);
            in = new ObjectInputStream(fis);
            misListaZapatos = (shoes[]) in.readObject();
        } catch (FileNotFoundException e) {
            Log.e("error archivo",e.toString());
        } catch (IOException e) {
            Log.e("error io",e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("error de lista",e.toString());
        }
        return misListaZapatos;
    }


}
