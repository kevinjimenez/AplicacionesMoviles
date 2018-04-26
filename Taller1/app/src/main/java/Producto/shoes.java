package Producto;

import java.io.Serializable;

public class shoes implements Serializable{

    String nombre,marca,pais;
    Integer talla,precio;
    shoes misZapatos [];

    public shoes() {
    }

    public shoes(String nombre, String marca, String pais, Integer talla, Integer precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.pais = pais;
        this.talla = talla;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }



    @Override
    public String toString() {
        return this.nombre +", $"+this.precio ;
    }

    public shoes [] cargarZapatos(){
        misZapatos = new shoes[] { new shoes("kkk","etnies","vietnan", 105,0),
                new shoes("kkk1","etnies","vietnan", 105,0),
                new shoes("kkk2","etnies","vietnan", 105,0),
                new shoes("kkk3","etnies","vietnan", 105,0),
                new shoes("kkk4","etnies","vietnan", 105,0),
                new shoes("kkk4","adidas","vietnan", 105,0),
        };

        return misZapatos;
    }

}

