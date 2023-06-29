/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import common.producto.GestorProductos;
import common.producto.Producto;
import java.util.List;

/**
 *
 * @author sergi
 */
public class Pruebas {
    
    public static void main(String[] args){
        GestorProductos productos = new GestorProductos();
        productos.inicializarProductos();
        List<Producto> productosList = productos.readProductos();
        System.out.println("h"+productosList.size());
        for(int i = 0; i < productosList.size(); i++){
            System.out.println(productosList.get(i).toString());
        }
    }
    
}
