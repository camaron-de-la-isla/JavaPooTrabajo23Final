/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.producto.modelo;

/**
 *
 * @author sergi
 */

import common.FileUtil;
import common.GestorId;
import common.producto.modelo.Televisor;
import common.producto.modelo.Smartphone;
import common.producto.modelo.Ordenador;
import common.producto.modelo.Altavoz;
import common.producto.modelo.Producto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class GestorProductos {
    GestorId gestorId = new GestorId();
    final String filePath = "../productos.dat";
    List<Producto> productos;
    
    public GestorProductos(){
        inicializarProductos();
    }



public void inicializarProductos() {
    File file = new File(filePath);
    if (file.exists()) {
        cargarProductos();
    } else {
            productos = new Vector<>();
            productos.add(new Smartphone(gestorId.assignId(), "Galaxy S10", 1128.0, 10, 4128,6400, "Android", "Samsung", "Galaxy S10", "Negro"));
            productos.add(new Smartphone(gestorId.assignId(), "iPhone X", 999.0, 10, 2400, 6400, "iOS", "Apple", "iPhone X", "Gris"));
            productos.add(new Altavoz(gestorId.assignId(), "JBL Flip4", 120, 8, 2800, "JBL", "Flip 4", "Negro"));
            productos.add(new Altavoz(gestorId.assignId(), "Mi Speaker", 50, 8, 1000, "Xiaomi", "Mi Speaker", "Blanco"));
            productos.add(new Ordenador(gestorId.assignId(), "Portatil", 1000, 10, 8, 512, "Windows", "Asus", "laptop Pro", "Gris"));
            productos.add(new Ordenador(gestorId.assignId(), "Ordenador de sobremesa", 1500, 10, 16, 1024, "Windows", "Asus", "AsusPC 1200", "Negro"));
            productos.add(new Televisor(gestorId.assignId(), "miTv", 580, 12, 52, "Xiaomi", "miTv", "Blanco"));
            productos.add(new Televisor(gestorId.assignId(), "Sony", 1000, 12, 65, "Sony", "qledTv", "Negro"));
            FileUtil.save(filePath, productos);
            System.out.println("Archivo creado");
       
    }
}

    private void cargarProductos() {
        List<Producto> cTemp = FileUtil.readList(filePath);
        if (cTemp != null) {
            productos = cTemp;
        }
        else{
            productos = new Vector<>();
        }
        
    }

    public void addProducto(Producto producto) {
            if (producto instanceof Altavoz) {
                productos.add(new Altavoz(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock(), ((Altavoz) producto).getPotencia(), ((Altavoz) producto).getMarca(), ((Altavoz) producto).getModelo(), ((Altavoz) producto).getColor()));
            } else if (producto instanceof Ordenador) {
                productos.add(new Ordenador(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock(), ((Ordenador) producto).getRam(), ((Ordenador) producto).getAlmacenamiento(), ((Ordenador) producto).getSistemaOperativo(), ((Ordenador) producto).getMarca(), ((Ordenador) producto).getModelo(), ((Ordenador) producto).getColor()));
            } else if (producto instanceof Smartphone) {
                productos.add(new Smartphone(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock(), ((Smartphone) producto).getRam(), ((Smartphone) producto).getAlmacenamiento(), ((Smartphone) producto).getSistemaOperativo(), ((Smartphone) producto).getMarca(), ((Smartphone) producto).getModelo(), ((Smartphone) producto).getColor()));
            } else if (producto instanceof Televisor) {
                productos.add(new Televisor(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock(), ((Televisor) producto).getPulgadas(), ((Televisor) producto).getMarca(), ((Televisor) producto).getModelo(), ((Televisor) producto).getColor()));
            }
            FileUtil.save(filePath, productos);
}


public List<Producto> readProductos() {
    return productos;
}



    public Producto buscarProductoId(int id){
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getId()==id){
                return productos.get(i);
            } 
        }
        return null;
    }

    public Producto buscarProductoNombre(String nombre){
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getNombre().equals(nombre)){
                return productos.get(i);
            } 
        }
        return null;
    }

    public void updateProducto(int id, Producto productoNuevo) {
        for(int i = 0; i < productos.size(); i++) {
            Producto producto  = productos.get(i);
            if(producto.getId()==id){
                productos.set(i, productoNuevo);
                FileUtil.save(filePath, productos);
                System.out.println("Producto actualizado");
            }
        }
    }
    
    public String MostrarProductos() {
    String productosStr = "";
    for (int i = 0; i < productos.size(); i++) {
        productosStr += productos.get(i).toString() + "\n";
    } 
    return productosStr;
}

    public boolean deleteProducto(int id){
        for(int i = 0; i < productos.size(); i++){
            Producto producto = productos.get(i);
            if(producto.getId()==id){
                productos.remove(i);
                FileUtil.save(filePath, productos);
                System.out.println("Producto eliminado correctamente");
                return true;
            }
        }
        System.out.println("No se encontró ningún producto con el ID especificado");        
        return false;
    }
    
    public boolean deleteProducto(String nombre){
        for(int i = 0; i < productos.size(); i++){
            Producto producto = productos.get(i);
            if(producto.getNombre()==nombre){
                productos.remove(i);
                FileUtil.save(filePath, productos);
                System.out.println("Producto eliminado correctamente");
                return true;
            }
        }
        System.out.println("No se encontró ningún producto con el ID especificado");        
        return false;
    }

    public int getIdProducto(String nombre){
        for (Producto producto : readProductos()) {
            if(producto.getNombre().equals(nombre)){
                return producto.getId();
            }
        }
        return 0;
    } 
    
    
    
}
