/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.modelo;

/**
 *
 * @author sergi
 */

import cliente.modelo.Cliente;
import common.FileUtil;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class GestorClientes {
    final String filePath = "../clientes.dat";
    List<Cliente> clientes;
    
    public GestorClientes(){
    inicializarClientes();
}

    public void inicializarClientes() {
        File file = new File(filePath);
        if (!file.exists()) {
            clientes = new Vector<>();
            clientes.add(new Cliente("Aaron", "Garcia", "23459934Q", "Calle Real 23", "627384654", "aarongarcia@gmail.com", "aarongarcia", "1234"));
            clientes.add(new Cliente("Carlota", "Fernandez", "84273345I", "Calle Mayor 12", "638511033", "carlotafernandez@gmail.com", "carlotafernandez", "1234"));
            FileUtil.save(filePath, clientes);
        } else {
            cargarClientes();
        }
    }
    
    private void cargarClientes(){
        List<Cliente> cTemp = FileUtil.readList(filePath);
        if(cTemp!=null){
            clientes = cTemp;
        } else{
            clientes = new Vector<>();
    }
    }

    public boolean addCliente(Cliente cliente) {
           try{
               clientes.add(cliente);
               FileUtil.save(filePath, clientes);
           }catch(Exception e){
        return false;
    }
           return true;
    }


    public List<Cliente> readClientes() {
    return clientes;
    }


    public Cliente buscarCliente(String user){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getUsuario().equals(user)){
                return clientes.get(i);
            }
        }
        return null;
    }

    public Cliente buscarClienteDni(String dni){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getDni().equals(dni)){
                return clientes.get(i);
            }
        }
        return null;
    }



    public boolean updateCliente(String dniModificar, Cliente clienteNuevo){
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i);
            if(cliente.getDni().equals(dniModificar)){
                clientes.set(i, clienteNuevo);
                FileUtil.save(filePath, clientes);
                System.out.println("Cliente actualizado");
                return true;
            }
        }
        return false;
    }
    
public String MostrarClientes() {
    String clientesStr = "";
    for (int i = 0; i < clientes.size(); i++) {
        clientesStr += clientes.get(i).toString() + "\n";
    } 
    return clientesStr;
}


    public boolean deleteCliente(String dni) {
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i);
            if(cliente.getDni().equals(dni)){
                clientes.remove(i);
                FileUtil.save(filePath, clientes);
                System.out.println("Cliente eliminado");
                return true;
            }
        }
        System.out.println("No se ha encontrado el cliente");
        return false;
    }

    public boolean authentificarCliente(String usuario, String contraseña) {
        Cliente clienteAuthentificar = buscarCliente(usuario);
  
        if (clienteAuthentificar != null) {
            if (clienteAuthentificar.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        else{
            System.out.println("Credenciales incorrectas");
            return false;
        }
        return false;
    }
    

    }


