/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.producto.modelo;

import java.io.Serializable;

/**
 *
 * @author sergi
 */

public class Producto implements Serializable{
    private
    static final long serialVersionUID = -1315886448553080707L;  
    int id;
    String nombre;
    double precio;

    int stock;


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void restarStock(int cantidad) {
        this.stock -= cantidad;
    }

    public void sumarStock(int cantidad) {
        this.stock += cantidad;
    }

}

