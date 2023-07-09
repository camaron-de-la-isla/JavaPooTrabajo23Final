/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.authentificacion.modelo;

/**
 *
 * @author sergi
 */



import cliente.modelo.Cliente;
import cliente.modelo.GestorClientes;
import empleado.modelo.Empleado;
import empleado.modelo.GestorEmpleados;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class PasarelaAuthentificacion {
        
    public static Cliente authentificarCliente(String user, String pass){
        GestorClientes gestorClientes = new GestorClientes();
        if(gestorClientes.authentificarCliente(user, pass) == true){
            return gestorClientes.buscarCliente(user);
        }
        else return  null;
    }
    
    public static Empleado authentificarEmpleado(String dni, String pass){
        GestorEmpleados gestorEmpleados = new GestorEmpleados();
        if(gestorEmpleados.authentificarEmpleado(dni, pass) == true){
            return gestorEmpleados.buscarEmpleado(dni);
        }
        else return  null;
    }
    
}
