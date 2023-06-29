
import common.producto.GestorProductos;
import common.producto.Producto;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sergi
 */
public class Main {
    public static void main(String[] args){
        GestorProductos gestorProductos = new GestorProductos();
        gestorProductos.inicializarProductos();
        List<Producto> productos = gestorProductos.readProductos();
        System.out.println("Tamanio de productos="+productos.size());
        for(int i = 0; i < productos.size(); i++){
            System.out.println(productos.get(i).toString());
        }
    }
    
}
