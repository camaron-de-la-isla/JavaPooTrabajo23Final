/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.pedido.modelo;

/**
 *
 * @author sergi
 */

import common.FileUtil;
import common.GestorId;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;



public class GestorPedidos {
    GestorId gestorId = new GestorId();
    final String filePath = "../pedidos.dat";
    List<Venta> pedidos;
    
    public GestorPedidos(){
        inicializarPedidos();
    }
    
    public void inicializarPedidos() {
        File file = new File(filePath);
        if (file.exists()) {
            cargarPedidos();
        } else {
                pedidos = new Vector<>();
                pedidos.add(new Venta(gestorId.assignId(), "11/03/2023", "43332223P", 1, 2, 200));
                pedidos.add(new Venta(gestorId.assignId(), "12/03/2023", "13427983L", 3, 1, 150));
                FileUtil.save(filePath, pedidos);
                System.out.println("Archivo creado");
            
            }
        }
        
    private void cargarPedidos() {
        List<Venta> cTemp = FileUtil.readList(filePath);
        if (cTemp != null){
            pedidos = cTemp;
        }
        else
            pedidos  = new Vector<>();
        
    }

    public void addPedido(Venta pedido){
        pedidos.add(pedido);
        FileUtil.save(filePath, pedidos);
    }

    public List<Venta> readPedidos(){
        return pedidos;
    }

    public Venta buscarVenta(int id){
        for(int i = 0; i < pedidos.size(); i++){
            if(pedidos.get(i).getId()==id){
                return pedidos.get(i);
            } 
        }
        return null;
    }


        public void updatePedido(int idModificar, Venta pedidoNuevo){
            for(int i = 0; i < pedidos.size(); i++){
                Venta pedido = pedidos.get(i);
                if(pedido.getId()==idModificar){
                    pedidos.set(i, pedidoNuevo);
                    FileUtil.save(filePath, pedidos);
                    System.out.println("Pedido actualizado");
                    return;
                }
            }
            System.out.println("Pedido no encontrado");
        }

        public void deletePedido(int idPedido){
            for(int i = 0; i < pedidos.size(); i++){
                Venta pedido = pedidos.get(i);
                if(pedido.getId()==idPedido){
                    pedidos.remove(i);
                    FileUtil.save(filePath, pedidos);
                    System.out.println("Pedido eliminado correctamente");
                    return;
                }
            }
            System.out.println("Pedido no encontrado");
    }

}
