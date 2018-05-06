package Producto;

import java.io.Serializable;

public class shoes implements Serializable{

    String nombre,marca,pais;
    String misNombres[];
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





    public shoes [] cargarZapatos(){
        misZapatos = new shoes[] {
                new shoes("Marana","etnies","vietnan", 10,100),
                new shoes("Predator","nike","china", 8,120),
                new shoes("skate","adidas","vietnan", 5,95),
                new shoes("Nyjah","DC","vietman", 7,98),
                new shoes("Navy","etnies","vietman", 6,93),
                new shoes("Run","adidas","china", 11,80),
                new shoes("Marana","etnies","vietnan", 10,100),
                new shoes("Predator","nike","china", 8,120),
                new shoes("skate","adidas","vietnan", 5,95),
                new shoes("Nyjah","DC","vietman", 7,98),
                new shoes("Navy","etnies","vietman", 6,93),
                new shoes("Run","adidas","china", 11,80),
                new shoes("Marana","etnies","vietnan", 10,100),
                new shoes("Predator","nike","china", 8,120),
                new shoes("skate","adidas","vietnan", 5,95),
                new shoes("Nyjah","DC","vietman", 7,98),
                new shoes("Navy","etnies","vietman", 6,93),
                new shoes("Run","adidas","china", 11,80),
                new shoes("Marana","etnies","vietnan", 10,100),
                new shoes("Predator","nike","china", 8,120),
                new shoes("skate","adidas","vietnan", 5,95),
                new shoes("Nyjah","DC","vietman", 7,98),
                new shoes("Navy","etnies","vietman", 6,93),
                new shoes("Run","adidas","china", 11,80),
                new shoes("Converse","converser","Tailandia", 5,70),
        };
        return misZapatos;
    }

    /*public String [] nombresDeZapatos(){
        misNombres = new String[cargarZapatos().length];
        for (int i=0;i<misNombres.length;i++){
            misNombres[i]=cargarZapatos()[i].getNombre();
        }
        return misNombres;
    }*/
    @Override
    public String toString() {
        return this.nombre + " ,$"+this.precio;
    }
}

