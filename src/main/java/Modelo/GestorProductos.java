/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author sergi
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorProductos {
    GestorId gestorId = new GestorId();



public void inicializarProductos() {
    File file = new File("../productos.txt");
    if (file.exists()) {
        System.out.println("El archivo está inicializado");
    } else {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Galaxy S10, " + 1128.0 + ", " + 10 + ", " + 4128 + ", " + ", Android, Samsung, Galaxy S10, Negro, Smartphone\n");
            writer.write("iPhone X, " + 999.0 + ", " + 10 + ", " + 3 + ", " + 64 + ", iOS, Apple, iPhone X, Gris, Smartphone\n");
            writer.write("JBL Flip4, " + 120 + ", " + 8 + ", " + 2800 + ", JBL, Flip 4, Negro, Altavoz\n");
            writer.write("Mi Speaker, " + 50 + ", " + 8 + ", " + 1000 + ", Xiaomi, Mi Speaker, Blanco, Altavoz\n");
            writer.write("Portatil, " + 1000 + ", " + 10 + ", " + 8 + ", " + 512 + ", Windows, Asus, Gris, Ordenador\n");
            writer.write("Ordenador de sobremesa, " + 1500 + ", " + 10 + ", " + 16 + ", " + 1024 + ", Windows, Asus, Negro, Ordenador\n");
            writer.write("miTv" + ", " + 580 + ", " + 12 + ", " + 52 + ", Xiaomi, miTv, Blanco, Televisor\n");
            writer.write("Sony, " + 1000 + ", " + 12 + ", " + 65 + ", Sony, qledTv, Negro, Televisor\n");
            writer.close();
            System.out.println("Archivo creado");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

// ...




    public void addProducto(Producto producto) {
    File file = new File("../productos.txt");
    if (file.exists()) {
        try {
            FileWriter writer = new FileWriter(file, true); // Modo de escritura adicional
            if (producto instanceof Altavoz) {
                writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Altavoz\n");
            } else if (producto instanceof Ordenador) {
                writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Ordenador\n");
            } else if (producto instanceof Smartphone) {
                writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Smartphone\n");
            } else if (producto instanceof Televisor) {
                writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Televisor\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


public List<Producto> readProductos() {
    List<Producto> productos = new ArrayList<>();
    try {
        File file = new File("../productos.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) { // Cambiado de scanner.hasNext()
            String[] datos = scanner.nextLine().split(", ");
            String tipo = datos[
                    datos.length - 1];
            switch (tipo) {
                case "Altavoz":
                    Altavoz altavoz = new Altavoz(gestorId.assignId(), datos[0], Double.parseDouble(datos[1]),
                            Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), datos[4], datos[5], datos[6]);
                    productos.add(altavoz);
                    break;
                case "Ordenador":
                    Ordenador ordenador = new Ordenador(gestorId.assignId(), datos[0], Double.parseDouble(datos[1]),
                            Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), datos[5],
                            datos[6], datos[7], datos[8]);
                    productos.add(ordenador);
                    break;
                case "Smartphone":
                    Smartphone smartphone = new Smartphone(gestorId.assignId(), datos[0], Double.parseDouble(datos[1]),
                            Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), datos[5],
                            datos[6], datos[7], datos[8]);
                    productos.add(smartphone);
                    break;
                case "Televisor":
                    Televisor televisor = new Televisor(gestorId.assignId(), datos[0], Double.parseDouble(datos[1]),
                            Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), datos[4], datos[5], datos[6]);
                    productos.add(televisor);
                    break;
                default:
                    break;
            }
        }
        scanner.close();
        return productos;
    } catch (IOException e) {
        System.out.println("Error de entrada/salida: " + e.getMessage());
        e.printStackTrace();
    }

    return productos;
}



    public Producto buscarProducto(int id){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getId() == id){
                return producto;
            }
        }
        return null;
    }

    public Producto buscarProducto(String nombre){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getNombre().equals(nombre)){
                return producto;
            }
        }
        return null;
    }

    public Producto buscarProducto(int id, String nombre){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getId() == id && producto.getNombre().equals(nombre)){
                return producto;
            }
        }
        return null;
    }

    public void updateProducto(int id, Producto producto) {
        List<Producto> productos = readProductos();
        for (Producto producto1 : productos) {
            if (producto1.getId() == id) {
                if (producto1 instanceof Altavoz) {
                    Altavoz altavoz = (Altavoz) producto1;
                    Altavoz altavoz1 = (Altavoz) producto;
                    altavoz.setPotencia(altavoz1.getPotencia());
                }
                if (producto1 instanceof Ordenador) {
                    Ordenador ordenador = (Ordenador) producto1;
                    Ordenador ordenador1 = (Ordenador) producto;
                    ordenador.setRam(ordenador1.getRam());
                    ordenador.setAlmacenamiento(ordenador1.getAlmacenamiento());
                    ordenador.setSistemaOperativo(ordenador1.getSistemaOperativo());
                }
                if (producto1 instanceof Smartphone) {
                    Smartphone smartphone = (Smartphone) producto1;
                    Smartphone smartphone1 = (Smartphone) producto;
                    smartphone.setSistemaOperativo(smartphone1.getSistemaOperativo());
                }
                if (producto1 instanceof Televisor) {
                    Televisor televisor = (Televisor) producto1;
                    Televisor televisor1 = (Televisor) producto;
                    televisor.setPulgadas(televisor1.getPulgadas());
                }
            }
        }
        try {
            File file = new File("../productos.txt");
            FileWriter writer = new FileWriter(file, true);
            for (Producto producto1 : productos) {
                if (producto1 instanceof Altavoz) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Altavoz"); //SIN ACABAR
                }
                if (producto1 instanceof Ordenador) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Ordenador"); //SIN ACABAR
                }
                if (producto1 instanceof Smartphone) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Movil"); //SIN ACABAR
                }
                if (producto1 instanceof Televisor) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Televisor"); //SIN ACABAR
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteProducto(int id){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getId() == id){
                productos.remove(producto);
                break;
            }
        }
        try {
            File file = new File("../productos.txt");
            FileWriter writer = new FileWriter(file);
            for (Producto producto : productos) {
                if (producto instanceof Altavoz) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Altavoz"); //SIN ACABAR
                }
                if (producto instanceof Ordenador) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Ordenador"); //SIN ACABAR
                }
                if (producto instanceof Smartphone) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Movil"); //SIN ACABAR
                }
                if (producto instanceof Televisor) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Televisor"); //SIN ACABAR
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getIdProducto(String nombre){
        for (Producto producto : readProductos()) {
            if(producto.getNombre().equals(nombre)){
                System.out.println(producto.getId());
            }
        }
    }

    public boolean existeProducto(int id){
        if(readProductos().size() <= id){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean existeProducto(String nombre){
        for(int i = 0; i < readProductos().size(); i++){
            if(readProductos().get(i).getNombre() == nombre){
                return true;
            }
        }
        return false;
    }

    public boolean existeProducto(String nombreProducto, int idProducto) {
        for (Producto producto : readProductos()) {
            if (producto.getNombre().equals(nombreProducto) && producto.getId() == idProducto) {
                return true;
            }
        }
        return false;
    }
    
    public String mostrarTodos(){
        List<Producto> productos = readProductos();
        String productosStr = "";
        for(int i = 0; i < productos.size(); i++){
            productosStr = productosStr + productos.get(i).toString() + "\n";
        }
        return productosStr;
    }
    
}
